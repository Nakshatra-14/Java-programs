package nn.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HexViewer extends JFrame implements ActionListener {

    JTextField filename;
    JLabel output, header;
    JTextArea textArea;
    int n = 0;
    int p = 1;
    boolean hasMoreData;
    FileInputStream fis;

    public void addButton(JPanel p, String txt, ActionListener lsn) {
        JButton btn = new JButton(txt);
        btn.setActionCommand(txt);
        btn.addActionListener(lsn);
        p.add(btn);
    }

    public HexViewer() {
        setTitle("Hex Viewer");
        setSize(590, 690);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new JPanel();

        p.add(new JLabel("Enter file name"));
        filename = new JTextField("E:\\code\\Java\\SplitFile\\splited\\sign.pdf.001", 20);
        p.add(filename);

        addButton(p, "Submit", this);


        textArea = new JTextArea("", 30, 30);
        textArea.setFont(new Font("Courier New", Font.PLAIN, 12));
        p.add(textArea);

        addButton(p, "Next Page", this);

        add(p);
    }

    public static void main(String[] args) {
        new HexViewer().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton btn = (JButton) e.getSource();

        
        File file = new File(filename.getText());
        
        
        
        
        try {
            if (btn.getActionCommand().equals("Submit")) {
                    fis = new FileInputStream(file);
                    hasMoreData = true;
                    n = 0;
                    p = 1;
                    hasMoreData = showPage(fis, n, p);
                    p++;
                }
                else if(btn.getActionCommand().equals("Next Page"))
                {
                    if(hasMoreData)
                    {
                        hasMoreData = showPage(fis, n, p);
                        p++;
                    }
                }
            }
        catch (IOException ex) {
            textArea.setText(ex.getMessage());
        }

    }

    public boolean showPage(InputStream is, int lno, int pno) throws IOException {

        byte buff[] = new byte[16];
        int byteCount = 0;
        final int TOTLINE = 20;

        textArea.setText("");

        textArea.append(String.format(" ".repeat(9)));
        for (int i = 0; i <= 15; i++)
            textArea.append(String.format("%02X ", i));
        textArea.append("\n");
        // textArea.append("ABCDEFGHIJKLMNOPQRST");
        // if(true)
        //     return true;
        for(int k = 0 ; k < TOTLINE ; k++) {

            int count = is.read(buff);
            if (count == -1)
                return false;

            textArea.append(String.format("%08X ", byteCount));

            for (int i = 0; i < count; i++)

                textArea.append(String.format("%02X ", buff[i]));
            while (count < 16) {
                textArea.append("   ");
                count++;
            }
            textArea.append("  ");
            for (int i = 0; i < count; i++) {
                textArea.append(String.format("%c", ((buff[i] < 32) ? '.' : buff[i])));

            }
            textArea.append("\n");
        }

        return true;
    }
}
