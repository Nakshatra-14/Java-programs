package com.example.nn;

public class HiddenApp {

    // --- Windows API JNA Mapping ---
    public interface MyUser32 extends StdCallLibrary {
        MyUser32 INSTANCE = Native.load("user32", MyUser32.class, W32APIOptions.DEFAULT_OPTIONS);
        int WDA_EXCLUDEFROMCAPTURE = 0x00000011;
        boolean SetWindowDisplayAffinity(HWND hWnd, int dwAffinity);
    }

    // --- OpenRouter API Details ---
    private static final String API_URL = "https://openrouter.ai/api/v1/chat/completions";
    private static final String API_KEY = "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";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Secret AI Window");
            frame.setUndecorated(true);
            frame.setBackground(new Color(0, 0, 0, 180)); // Slightly darker for better text readability
            frame.setSize(500, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setLayout(new BorderLayout());

            // --- 1. UI Setup: Output Area (Top/Center) ---
            JTextArea outputArea = new JTextArea("AI Assistant Ready. Type a prompt below...\n\n");
            outputArea.setEditable(false);
            outputArea.setLineWrap(true);
            outputArea.setWrapStyleWord(true);
            outputArea.setForeground(Color.WHITE);
            outputArea.setFont(new Font("Consolas", Font.PLAIN, 14));
            outputArea.setOpaque(false); // Keep it translucent

            JScrollPane scrollPane = new JScrollPane(outputArea);
            scrollPane.setOpaque(false);
            scrollPane.getViewport().setOpaque(false);
            scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            frame.add(scrollPane, BorderLayout.CENTER);

            // --- 2. UI Setup: Input Area & Button (Bottom) ---
            JPanel inputPanel = new JPanel(new BorderLayout(5, 0));
            inputPanel.setOpaque(false);
            inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JTextField inputField = new JTextField();
            inputField.setBackground(new Color(50, 50, 50, 200));
            inputField.setForeground(Color.WHITE);
            inputField.setCaretColor(Color.WHITE);
            inputField.setFont(new Font("Consolas", Font.PLAIN, 14));

            JButton submitBtn = new JButton("Send");
            submitBtn.setBackground(new Color(70, 70, 70));
            submitBtn.setForeground(Color.WHITE);

            inputPanel.add(inputField, BorderLayout.CENTER);
            inputPanel.add(submitBtn, BorderLayout.EAST);
            frame.add(inputPanel, BorderLayout.SOUTH);

            // --- 3. Draggable Window Logic ---
            MouseAdapter dragListener = new MouseAdapter() {
                int pX, pY;
                public void mousePressed(MouseEvent e) { pX = e.getX(); pY = e.getY(); }
                public void mouseDragged(MouseEvent e) {
                    frame.setLocation(frame.getLocation().x + e.getX() - pX, frame.getLocation().y + e.getY() - pY);
                }
            };
            outputArea.addMouseListener(dragListener);
            outputArea.addMouseMotionListener(dragListener);

            // --- 4. Button Click / API Call Logic ---
            submitBtn.addActionListener(e -> {
                String prompt = inputField.getText().trim();
                if (prompt.isEmpty()) return;

                outputArea.append("You: " + prompt + "\n");
                inputField.setText("");
                submitBtn.setEnabled(false); // Disable button while loading

                // Run API call on a background thread so the UI doesn't freeze
                CompletableFuture.runAsync(() -> callOpenRouterAPI(prompt, outputArea, submitBtn));
            });

            // Allow hitting "Enter" to send
            inputField.addActionListener(e -> submitBtn.doClick());

            // --- 5. Show Window & Apply Invisibility ---
            frame.setVisible(true);

            HWND hwnd = new HWND(Native.getWindowPointer(frame));
            MyUser32.INSTANCE.SetWindowDisplayAffinity(hwnd, MyUser32.WDA_EXCLUDEFROMCAPTURE);
        });
    }

    // --- Helper Method: Make the API Request ---
    private static void callOpenRouterAPI(String prompt, JTextArea outputArea, JButton submitBtn) {
        try {
            // Build the JSON payload safely
            JSONObject message = new JSONObject().put("role", "user").put("content", prompt);
            JSONArray messages = new JSONArray().put(message);
            JSONObject payload = new JSONObject()
                    .put("model", "minimax/minimax-m2.5")
                    .put("messages", messages)
                    .put("reasoning", new JSONObject().put("enabled", true));

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + API_KEY)
                    .POST(HttpRequest.BodyPublishers.ofString(payload.toString()))
                    .build();

            // Send request
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            // Print the raw response to your IDE console for debugging
            System.out.println("Raw Response: " + response.body());

            // Parse response
            JSONObject jsonResponse = new JSONObject(response.body());

            // 1. Check if the API returned an error message
            if (jsonResponse.has("error")) {
                String errorMsg = jsonResponse.getJSONObject("error").optString("message", "Unknown API Error");
                SwingUtilities.invokeLater(() -> outputArea.append("API Error: " + errorMsg + "\n\n"));
                return; // Stop here
            }

            // 2. Safely check if "choices" exists before trying to read it
            if (jsonResponse.has("choices")) {
                String aiReply = jsonResponse.getJSONArray("choices")
                        .getJSONObject(0)
                        .getJSONObject("message")
                        .getString("content");

                // Update UI safely on the main thread
                SwingUtilities.invokeLater(() -> {
                    outputArea.append("AI: " + aiReply + "\n\n");
                    outputArea.setCaretPosition(outputArea.getDocument().getLength());
                });
            } else {
                // 3. Fallback for completely unexpected JSON
                SwingUtilities.invokeLater(() -> outputArea.append("Unexpected response from server.\n\n"));
            }

        } catch (Exception ex) {
            SwingUtilities.invokeLater(() -> outputArea.append("System Error: " + ex.getMessage() + "\n\n"));
        } finally {
            SwingUtilities.invokeLater(() -> submitBtn.setEnabled(true));
        }
    }
}

