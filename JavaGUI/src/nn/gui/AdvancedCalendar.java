package nn.gui;

import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class AdvancedCalendar extends JFrame {
    private LocalDate currentDate;
    private LocalDate selectedDate;
    private JLabel monthYearLabel;
    private JPanel calendarGrid;
    private List<JButton> dayButtons;
    private Map<LocalDate, List<Event>> events;
    private CalendarView currentView;
    private Theme currentTheme;
    private JPanel sidebar;
    private JList<Event> eventList;
    private DefaultListModel<Event> eventListModel;
    private JTextField searchField;
    private JComboBox<String> categoryFilter;
    
    // Themes
    private static final Map<String, Theme> THEMES = new HashMap<>();
    static {
        THEMES.put("Light", new Theme(
            new Color(248, 250, 252), // background
            Color.WHITE,              // surface
            new Color(79, 70, 229),   // primary
            new Color(99, 102, 241),  // secondary
            new Color(15, 23, 42),    // text primary
            new Color(100, 116, 139), // text secondary
            new Color(34, 197, 94),   // accent
            new Color(241, 245, 249)  // hover
        ));
        THEMES.put("Dark", new Theme(
            new Color(15, 23, 42),    // background
            new Color(30, 41, 59),    // surface
            new Color(99, 102, 241),  // primary
            new Color(129, 140, 248), // secondary
            new Color(248, 250, 252), // text primary
            new Color(148, 163, 184), // text secondary
            new Color(34, 197, 94),   // accent
            new Color(51, 65, 85)     // hover
        ));
        THEMES.put("Ocean", new Theme(
            new Color(240, 249, 255), // background
            Color.WHITE,              // surface
            new Color(14, 165, 233),  // primary
            new Color(56, 189, 248),  // secondary
            new Color(15, 23, 42),    // text primary
            new Color(71, 85, 105),   // text secondary
            new Color(16, 185, 129),  // accent
            new Color(224, 242, 254)  // hover
        ));
    }
    
    private enum CalendarView {
        MONTH, WEEK, AGENDA
    }
    
    public AdvancedCalendar() {
        currentDate = LocalDate.now();
        selectedDate = LocalDate.now();
        currentView = CalendarView.MONTH;
        currentTheme = THEMES.get("Light");
        events = new HashMap<>();
        dayButtons = new ArrayList<>();
        eventListModel = new DefaultListModel<>();
        
        // Add sample events
        addSampleEvents();
        
        initializeUI();
        updateCalendar();
    }
    
    private void addSampleEvents() {
        LocalDate today = LocalDate.now();
        addEvent(today, "Team Meeting", "Weekly sync meeting", "Work", LocalTime.of(10, 0));
        addEvent(today.plusDays(1), "Doctor Appointment", "Annual checkup", "Health", LocalTime.of(14, 30));
        addEvent(today.plusDays(3), "Birthday Party", "John's birthday celebration", "Personal", LocalTime.of(18, 0));
        addEvent(today.plusDays(5), "Project Deadline", "Submit final report", "Work", LocalTime.of(23, 59));
        addEvent(today.minusDays(2), "Gym Session", "Cardio workout", "Health", LocalTime.of(7, 0));
    }
    
    private void initializeUI() {
        setTitle("Advanced Calendar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(1000, 600));
        
        applyTheme();
        setLayout(new BorderLayout(10, 10));
        
        // Create components
        add(createToolbar(), BorderLayout.NORTH);
        add(createMainContent(), BorderLayout.CENTER);
        add(createStatusBar(), BorderLayout.SOUTH);
        
        // Add padding
        ((JComponent) getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10));
        
        // Keyboard shortcuts
        setupKeyboardShortcuts();
    }
    
    private JPanel createToolbar() {
        JPanel toolbar = new JPanel(new BorderLayout());
        toolbar.setBackground(currentTheme.surface);
        toolbar.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
            new EmptyBorder(15, 20, 15, 20)
        ));
        
        // Left section - Navigation
        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        leftPanel.setBackground(currentTheme.surface);
        
        JButton prevButton = createToolbarButton("‹", e -> navigateMonth(-1));
        JButton nextButton = createToolbarButton("›", e -> navigateMonth(1));
        JButton todayButton = createToolbarButton("Today", e -> goToToday());
        
        monthYearLabel = new JLabel();
        monthYearLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        monthYearLabel.setForeground(currentTheme.textPrimary);
        monthYearLabel.setBorder(new EmptyBorder(0, 15, 0, 15));
        
        leftPanel.add(prevButton);
        leftPanel.add(nextButton);
        leftPanel.add(monthYearLabel);
        leftPanel.add(todayButton);
        
        // Center section - View buttons
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        centerPanel.setBackground(currentTheme.surface);
        
        ButtonGroup viewGroup = new ButtonGroup();
        JToggleButton monthBtn = createViewButton("Month", CalendarView.MONTH);
        JToggleButton weekBtn = createViewButton("Week", CalendarView.WEEK);
        JToggleButton agendaBtn = createViewButton("Agenda", CalendarView.AGENDA);
        
        viewGroup.add(monthBtn);
        viewGroup.add(weekBtn);
        viewGroup.add(agendaBtn);
        monthBtn.setSelected(true);
        
        centerPanel.add(monthBtn);
        centerPanel.add(weekBtn);
        centerPanel.add(agendaBtn);
        
        // Right section - Actions
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 0));
        rightPanel.setBackground(currentTheme.surface);
        
        JButton addEventBtn = createToolbarButton("+ Add Event", e -> showAddEventDialog());
        addEventBtn.setBackground(currentTheme.primary);
        addEventBtn.setForeground(Color.WHITE);
        
        JComboBox<String> themeSelector = new JComboBox<>(THEMES.keySet().toArray(new String[0]));
        themeSelector.setSelectedItem("Light");
        themeSelector.addActionListener(e -> switchTheme((String) themeSelector.getSelectedItem()));
        
        rightPanel.add(themeSelector);
        rightPanel.add(addEventBtn);
        
        toolbar.add(leftPanel, BorderLayout.WEST);
        toolbar.add(centerPanel, BorderLayout.CENTER);
        toolbar.add(rightPanel, BorderLayout.EAST);
        
        return toolbar;
    }
    
    private JPanel createMainContent() {
        JPanel mainContent = new JPanel(new BorderLayout(10, 0));
        mainContent.setBackground(currentTheme.background);
        
        // Calendar panel
        JPanel calendarPanel = new JPanel(new BorderLayout());
        calendarPanel.setBackground(currentTheme.surface);
        calendarPanel.setBorder(BorderFactory.createLineBorder(new Color(226, 232, 240), 1));
        
        calendarGrid = new JPanel();
        calendarPanel.add(calendarGrid, BorderLayout.CENTER);
        
        // Sidebar
        sidebar = createSidebar();
        
        mainContent.add(calendarPanel, BorderLayout.CENTER);
        mainContent.add(sidebar, BorderLayout.EAST);
        
        return mainContent;
    }
    
    private JPanel createSidebar() {
        JPanel sidebar = new JPanel(new BorderLayout(0, 10));
        sidebar.setPreferredSize(new Dimension(300, 0));
        sidebar.setBackground(currentTheme.surface);
        sidebar.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(226, 232, 240), 1),
            new EmptyBorder(15, 15, 15, 15)
        ));
        
        // Search section
        JPanel searchPanel = new JPanel(new BorderLayout(5, 5));
        searchPanel.setBackground(currentTheme.surface);
        
        JLabel searchLabel = new JLabel("Search Events");
        searchLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        searchLabel.setForeground(currentTheme.textPrimary);
        
        searchField = new JTextField();
        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                filterEvents();
            }
        });
        
        categoryFilter = new JComboBox<>(new String[]{"All Categories", "Work", "Personal", "Health"});
        categoryFilter.addActionListener(e -> filterEvents());
        
        searchPanel.add(searchLabel, BorderLayout.NORTH);
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(categoryFilter, BorderLayout.SOUTH);
        
        // Events list
        JPanel eventsPanel = new JPanel(new BorderLayout(0, 5));
        eventsPanel.setBackground(currentTheme.surface);
        
        JLabel eventsLabel = new JLabel("Upcoming Events");
        eventsLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        eventsLabel.setForeground(currentTheme.textPrimary);
        
        eventList = new JList<>(eventListModel);
        eventList.setCellRenderer(new EventListCellRenderer());
        eventList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        eventList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Event selectedEvent = eventList.getSelectedValue();
                    if (selectedEvent != null) {
                        showEventDetails(selectedEvent);
                    }
                }
            }
        });
        
        JScrollPane eventScrollPane = new JScrollPane(eventList);
        eventScrollPane.setPreferredSize(new Dimension(280, 200));
        
        eventsPanel.add(eventsLabel, BorderLayout.NORTH);
        eventsPanel.add(eventScrollPane, BorderLayout.CENTER);
        
        // Mini calendar
        JPanel miniCalendar = createMiniCalendar();
        
        sidebar.add(searchPanel, BorderLayout.NORTH);
        sidebar.add(eventsPanel, BorderLayout.CENTER);
        sidebar.add(miniCalendar, BorderLayout.SOUTH);
        
        return sidebar;
    }
    
    private JPanel createMiniCalendar() {
        JPanel mini = new JPanel(new BorderLayout(0, 5));
        mini.setBackground(currentTheme.surface);
        
        JLabel miniLabel = new JLabel("Quick Navigation");
        miniLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        miniLabel.setForeground(currentTheme.textPrimary);
        
        JPanel miniGrid = new JPanel(new GridLayout(7, 7, 2, 2));
        miniGrid.setBackground(currentTheme.surface);
        
        // Add day headers
        String[] dayNames = {"S", "M", "T", "W", "T", "F", "S"};
        for (String day : dayNames) {
            JLabel dayLabel = new JLabel(day);
            dayLabel.setFont(new Font("Segoe UI", Font.BOLD, 10));
            dayLabel.setForeground(currentTheme.textSecondary);
            dayLabel.setHorizontalAlignment(SwingConstants.CENTER);
            miniGrid.add(dayLabel);
        }
        
        // Add mini day buttons
        YearMonth yearMonth = YearMonth.of(currentDate.getYear(), currentDate.getMonth());
        LocalDate firstDay = yearMonth.atDay(1);
        int startDayOfWeek = firstDay.getDayOfWeek().getValue() % 7;
        int daysInMonth = yearMonth.lengthOfMonth();
        
        for (int i = 0; i < 42; i++) {
            JButton miniBtn = new JButton();
            miniBtn.setFont(new Font("Segoe UI", Font.PLAIN, 10));
            miniBtn.setPreferredSize(new Dimension(25, 25));
            miniBtn.setMargin(new Insets(0, 0, 0, 0));
            miniBtn.setBorderPainted(false);
            miniBtn.setFocusPainted(false);
            
            if (i >= startDayOfWeek && i < startDayOfWeek + daysInMonth) {
                int day = i - startDayOfWeek + 1;
                miniBtn.setText(String.valueOf(day));
                LocalDate buttonDate = yearMonth.atDay(day);
                
                if (buttonDate.equals(LocalDate.now())) {
                    miniBtn.setBackground(currentTheme.accent);
                    miniBtn.setForeground(Color.WHITE);
                } else if (buttonDate.equals(selectedDate)) {
                    miniBtn.setBackground(currentTheme.primary);
                    miniBtn.setForeground(Color.WHITE);
                } else {
                    miniBtn.setBackground(currentTheme.surface);
                    miniBtn.setForeground(currentTheme.textPrimary);
                }
                
                miniBtn.addActionListener(e -> {
                    selectedDate = buttonDate;
                    currentDate = buttonDate;
                    updateCalendar();
                });
            } else {
                miniBtn.setText("");
                miniBtn.setEnabled(false);
                miniBtn.setBackground(currentTheme.surface);
            }
            
            miniGrid.add(miniBtn);
        }
        
        mini.add(miniLabel, BorderLayout.NORTH);
        mini.add(miniGrid, BorderLayout.CENTER);
        
        return mini;
    }
    
    private JPanel createStatusBar() {
        JPanel statusBar = new JPanel(new BorderLayout());
        statusBar.setBackground(currentTheme.surface);
        statusBar.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(226, 232, 240)),
            new EmptyBorder(8, 15, 8, 15)
        ));
        
        JLabel statusLabel = new JLabel("Ready");
        statusLabel.setForeground(currentTheme.textSecondary);
        statusLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        
        JLabel dateLabel = new JLabel(LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy - HH:mm")));
        dateLabel.setForeground(currentTheme.textSecondary);
        dateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        
        statusBar.add(statusLabel, BorderLayout.WEST);
        statusBar.add(dateLabel, BorderLayout.EAST);
        
        return statusBar;
    }
    
    private void updateCalendar() {
        switch (currentView) {
            case MONTH:
                updateMonthView();
                break;
            case WEEK:
                updateWeekView();
                break;
            case AGENDA:
                updateAgendaView();
                break;
        }
        updateEventList();
        updateMiniCalendar();
    }
    
    private void updateMonthView() {
        monthYearLabel.setText(currentDate.format(DateTimeFormatter.ofPattern("MMMM yyyy")));
        
        calendarGrid.removeAll();
        calendarGrid.setLayout(new BorderLayout());
        calendarGrid.setBackground(currentTheme.surface);
        
        // Day headers
        JPanel dayHeaders = new JPanel(new GridLayout(1, 7, 1, 1));
        dayHeaders.setBackground(currentTheme.surface);
        dayHeaders.setBorder(new EmptyBorder(15, 15, 10, 15));
        
        String[] dayNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        for (String day : dayNames) {
            JLabel dayLabel = new JLabel(day);
            dayLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
            dayLabel.setForeground(currentTheme.textSecondary);
            dayLabel.setHorizontalAlignment(SwingConstants.CENTER);
            dayHeaders.add(dayLabel);
        }
        
        // Days grid
        JPanel daysGrid = new JPanel(new GridLayout(6, 7, 1, 1));
        daysGrid.setBackground(currentTheme.surface);
        daysGrid.setBorder(new EmptyBorder(0, 15, 15, 15));
        
        dayButtons.clear();
        YearMonth yearMonth = YearMonth.of(currentDate.getYear(), currentDate.getMonth());
        LocalDate firstDay = yearMonth.atDay(1);
        int startDayOfWeek = firstDay.getDayOfWeek().getValue() % 7;
        int daysInMonth = yearMonth.lengthOfMonth();
        
        for (int i = 0; i < 42; i++) {
            JPanel dayPanel = new JPanel(new BorderLayout());
            dayPanel.setBorder(BorderFactory.createLineBorder(new Color(226, 232, 240), 1));
            dayPanel.setBackground(currentTheme.surface);
            dayPanel.setPreferredSize(new Dimension(120, 100));
            
            if (i >= startDayOfWeek && i < startDayOfWeek + daysInMonth) {
                int day = i - startDayOfWeek + 1;
                LocalDate date = yearMonth.atDay(day);
                
                // Day number button
                JButton dayBtn = new JButton(String.valueOf(day));
                dayBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
                dayBtn.setHorizontalAlignment(SwingConstants.CENTER);
                dayBtn.setBorderPainted(false);
                dayBtn.setFocusPainted(false);
                dayBtn.setContentAreaFilled(false);
                dayBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                
                // Style day button
                if (date.equals(LocalDate.now())) {
                    dayBtn.setForeground(Color.WHITE);
                    dayBtn.setOpaque(true);
                    dayBtn.setBackground(currentTheme.accent);
                } else if (date.equals(selectedDate)) {
                    dayBtn.setForeground(Color.WHITE);
                    dayBtn.setOpaque(true);
                    dayBtn.setBackground(currentTheme.primary);
                } else if (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                    dayBtn.setForeground(new Color(239, 68, 68));
                } else {
                    dayBtn.setForeground(currentTheme.textPrimary);
                }
                
                dayBtn.addActionListener(e -> {
                    selectedDate = date;
                    updateCalendar();
                });
                
                // Events panel
                JPanel eventsPanel = new JPanel();
                eventsPanel.setLayout(new BoxLayout(eventsPanel, BoxLayout.Y_AXIS));
                eventsPanel.setBackground(currentTheme.surface);
                
                List<Event> dayEvents = events.getOrDefault(date, new ArrayList<>());
                for (int j = 0; j < Math.min(dayEvents.size(), 3); j++) {
                    Event event = dayEvents.get(j);
                    JLabel eventLabel = new JLabel(event.title);
                    eventLabel.setFont(new Font("Segoe UI", Font.PLAIN, 10));
                    eventLabel.setForeground(getEventColor(event.category));
                    eventLabel.setBorder(new EmptyBorder(1, 3, 1, 3));
                    eventLabel.setOpaque(true);
                    eventLabel.setBackground(getEventColor(event.category).brighter());
                    eventsPanel.add(eventLabel);
                }
                
                if (dayEvents.size() > 3) {
                    JLabel moreLabel = new JLabel("+" + (dayEvents.size() - 3) + " more");
                    moreLabel.setFont(new Font("Segoe UI", Font.PLAIN, 9));
                    moreLabel.setForeground(currentTheme.textSecondary);
                    eventsPanel.add(moreLabel);
                }
                
                dayPanel.add(dayBtn, BorderLayout.NORTH);
                dayPanel.add(eventsPanel, BorderLayout.CENTER);
                
                // Add context menu
                dayPanel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (e.isPopupTrigger()) {
                            showContextMenu(e, date);
                        }
                    }
                    @Override
                    public void mouseReleased(MouseEvent e) {
                        if (e.isPopupTrigger()) {
                            showContextMenu(e, date);
                        }
                    }
                });
                
                dayButtons.add(dayBtn);
            }
            
            daysGrid.add(dayPanel);
        }
        
        calendarGrid.add(dayHeaders, BorderLayout.NORTH);
        calendarGrid.add(daysGrid, BorderLayout.CENTER);
        calendarGrid.revalidate();
        calendarGrid.repaint();
    }
    
    private void updateWeekView() {
        LocalDate weekStart = selectedDate.with(DayOfWeek.SUNDAY);
        monthYearLabel.setText("Week of " + weekStart.format(DateTimeFormatter.ofPattern("MMMM d, yyyy")));
        
        calendarGrid.removeAll();
        calendarGrid.setLayout(new BorderLayout());
        
        // Week header
        JPanel weekHeader = new JPanel(new GridLayout(1, 8, 1, 1));
        weekHeader.setBackground(currentTheme.surface);
        weekHeader.setBorder(new EmptyBorder(15, 15, 10, 15));
        
        weekHeader.add(new JLabel("Time"));
        for (int i = 0; i < 7; i++) {
            LocalDate day = weekStart.plusDays(i);
            JLabel dayLabel = new JLabel(day.format(DateTimeFormatter.ofPattern("EEE d")));
            dayLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
            dayLabel.setForeground(currentTheme.textPrimary);
            dayLabel.setHorizontalAlignment(SwingConstants.CENTER);
            
            if (day.equals(LocalDate.now())) {
                dayLabel.setOpaque(true);
                dayLabel.setBackground(currentTheme.accent);
                dayLabel.setForeground(Color.WHITE);
            }
            
            weekHeader.add(dayLabel);
        }
        
        // Week grid
        JPanel weekGrid = new JPanel(new GridLayout(24, 8, 1, 1));
        weekGrid.setBackground(currentTheme.surface);
        weekGrid.setBorder(new EmptyBorder(0, 15, 15, 15));
        
        for (int hour = 0; hour < 24; hour++) {
            // Time label
            JLabel timeLabel = new JLabel(String.format("%02d:00", hour));
            timeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 11));
            timeLabel.setForeground(currentTheme.textSecondary);
            timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
            timeLabel.setBorder(BorderFactory.createLineBorder(new Color(226, 232, 240), 1));
            weekGrid.add(timeLabel);
            
            // Day cells
            for (int day = 0; day < 7; day++) {
                LocalDate cellDate = weekStart.plusDays(day);
                JPanel cellPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 2));
                cellPanel.setBorder(BorderFactory.createLineBorder(new Color(226, 232, 240), 1));
                cellPanel.setBackground(currentTheme.surface);
                cellPanel.setPreferredSize(new Dimension(100, 30));
                
                // Add events for this hour
                List<Event> dayEvents = events.getOrDefault(cellDate, new ArrayList<>());
                for (Event event : dayEvents) {
                    if (event.time != null && event.time.getHour() == hour) {
                        JLabel eventLabel = new JLabel(event.title);
                        eventLabel.setFont(new Font("Segoe UI", Font.PLAIN, 9));
                        eventLabel.setOpaque(true);
                        eventLabel.setBackground(getEventColor(event.category));
                        eventLabel.setForeground(Color.WHITE);
                        eventLabel.setBorder(new EmptyBorder(1, 3, 1, 3));
                        cellPanel.add(eventLabel);
                    }
                }
                
                weekGrid.add(cellPanel);
            }
        }
        
        JScrollPane scrollPane = new JScrollPane(weekGrid);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        
        calendarGrid.add(weekHeader, BorderLayout.NORTH);
        calendarGrid.add(scrollPane, BorderLayout.CENTER);
        calendarGrid.revalidate();
        calendarGrid.repaint();
    }
    
    private void updateAgendaView() {
        monthYearLabel.setText("Agenda View");
        
        calendarGrid.removeAll();
        calendarGrid.setLayout(new BorderLayout());
        
        String[] columnNames = {"Date", "Time", "Event", "Category", "Description"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        // Add events to table
        events.entrySet().stream()
            .sorted(Map.Entry.comparingByKey())
            .forEach(entry -> {
                LocalDate date = entry.getKey();
                List<Event> dayEvents = entry.getValue();
                dayEvents.sort(Comparator.comparing(e -> e.time != null ? e.time : LocalTime.MIN));
                
                for (Event event : dayEvents) {
                    Object[] row = {
                        date.format(DateTimeFormatter.ofPattern("MMM d, yyyy")),
                        event.time != null ? event.time.format(DateTimeFormatter.ofPattern("HH:mm")) : "All Day",
                        event.title,
                        event.category,
                        event.description
                    };
                    tableModel.addRow(row);
                }
            });
        
        JTable agendaTable = new JTable(tableModel);
        agendaTable.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        agendaTable.setRowHeight(25);
        agendaTable.setBackground(currentTheme.surface);
        agendaTable.setForeground(currentTheme.textPrimary);
        agendaTable.setSelectionBackground(currentTheme.primary);
        agendaTable.setSelectionForeground(Color.WHITE);
        agendaTable.getTableHeader().setBackground(currentTheme.background);
        agendaTable.getTableHeader().setForeground(currentTheme.textPrimary);
        
        JScrollPane scrollPane = new JScrollPane(agendaTable);
        scrollPane.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        calendarGrid.add(scrollPane, BorderLayout.CENTER);
        calendarGrid.revalidate();
        calendarGrid.repaint();
    }
    
    private void updateEventList() {
        eventListModel.clear();
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(30);
        
        events.entrySet().stream()
            .filter(entry -> !entry.getKey().isBefore(startDate) && !entry.getKey().isAfter(endDate))
            .sorted(Map.Entry.comparingByKey())
            .forEach(entry -> {
                List<Event> dayEvents = entry.getValue();
                dayEvents.sort(Comparator.comparing(e -> e.time != null ? e.time : LocalTime.MIN));
                for (Event event : dayEvents) {
                    eventListModel.addElement(event);
                }
            });
    }
    
    private void updateMiniCalendar() {
        // Mini calendar is updated in createMiniCalendar method
        // This could be enhanced to dynamically update
    }
    
    private void filterEvents() {
        String searchText = searchField.getText().toLowerCase();
        String selectedCategory = (String) categoryFilter.getSelectedItem();
        
        eventListModel.clear();
        
        events.values().stream()
            .flatMap(List::stream)
            .filter(event -> {
                boolean matchesSearch = searchText.isEmpty() || 
                    event.title.toLowerCase().contains(searchText) ||
                    event.description.toLowerCase().contains(searchText);
                boolean matchesCategory = "All Categories".equals(selectedCategory) ||
                    event.category.equals(selectedCategory);
                return matchesSearch && matchesCategory;
            })
            .sorted(Comparator.comparing(event -> {
                LocalDate eventDate = events.entrySet().stream()
                    .filter(entry -> entry.getValue().contains(event))
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .orElse(LocalDate.now());
                return eventDate;
            }))
            .forEach(eventListModel::addElement);
    }
    
    private void showAddEventDialog() {
        JDialog dialog = new JDialog(this, "Add New Event", true);
        dialog.setSize(400, 350);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new BorderLayout(10, 10));
        
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(currentTheme.surface);
        formPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Event title
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Event Title:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField titleField = new JTextField(20);
        formPanel.add(titleField, gbc);
        
        // Description
        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE;
        formPanel.add(new JLabel("Description:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.BOTH;
        JTextArea descArea = new JTextArea(3, 20);
        descArea.setLineWrap(true);
        descArea.setWrapStyleWord(true);
        formPanel.add(new JScrollPane(descArea), gbc);
        
        // Date
        gbc.gridx = 0; gbc.gridy = 2; gbc.fill = GridBagConstraints.NONE;
        formPanel.add(new JLabel("Date:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField dateField = new JTextField(selectedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        formPanel.add(dateField, gbc);
        
        // Time
        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(new JLabel("Time:"), gbc);
        gbc.gridx = 1;
        JTextField timeField = new JTextField("09:00");
        formPanel.add(timeField, gbc);
        
        // Category
        gbc.gridx = 0; gbc.gridy = 4;
        formPanel.add(new JLabel("Category:"), gbc);
        gbc.gridx = 1;
        JComboBox<String> categoryCombo = new JComboBox<>(new String[]{"Work", "Personal", "Health", "Other"});
        formPanel.add(categoryCombo, gbc);
        
        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(currentTheme.surface);
        
        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(e -> dialog.dispose());
        
        JButton saveBtn = new JButton("Save Event");
        saveBtn.setBackground(currentTheme.primary);
        saveBtn.setForeground(Color.WHITE);
        saveBtn.addActionListener(e -> {
            try {
                String title = titleField.getText().trim();
                String description = descArea.getText().trim();
                LocalDate date = LocalDate.parse(dateField.getText());
                LocalTime time = timeField.getText().trim().isEmpty() ? null : LocalTime.parse(timeField.getText());
                String category = (String) categoryCombo.getSelectedItem();
                
                if (title.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "Please enter an event title.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                addEvent(date, title, description, category, time);
                updateCalendar();
                dialog.dispose();
                
                JOptionPane.showMessageDialog(this, "Event added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Invalid date or time format. Please check your input.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        buttonPanel.add(cancelBtn);
        buttonPanel.add(saveBtn);
        
        dialog.add(formPanel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }
    
    private void showEventDetails(Event event) {
        LocalDate eventDate = events.entrySet().stream()
            .filter(entry -> entry.getValue().contains(event))
            .map(Map.Entry::getKey)
            .findFirst()
            .orElse(LocalDate.now());
        
        JDialog dialog = new JDialog(this, "Event Details", true);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new BorderLayout(10, 10));
        
        JPanel detailsPanel = new JPanel(new GridBagLayout());
        detailsPanel.setBackground(currentTheme.surface);
        detailsPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.NORTHWEST;
        
        // Event details
        gbc.gridx = 0; gbc.gridy = 0;
        detailsPanel.add(new JLabel("Title:"), gbc);
        gbc.gridx = 1;
        JLabel titleLabel = new JLabel(event.title);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        detailsPanel.add(titleLabel, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        detailsPanel.add(new JLabel("Date:"), gbc);
        gbc.gridx = 1;
        detailsPanel.add(new JLabel(eventDate.format(DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy"))), gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        detailsPanel.add(new JLabel("Time:"), gbc);
        gbc.gridx = 1;
        detailsPanel.add(new JLabel(event.time != null ? event.time.format(DateTimeFormatter.ofPattern("HH:mm")) : "All Day"), gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        detailsPanel.add(new JLabel("Category:"), gbc);
        gbc.gridx = 1;
        JLabel categoryLabel = new JLabel(event.category);
        categoryLabel.setForeground(getEventColor(event.category));
        categoryLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
        detailsPanel.add(categoryLabel, gbc);
        
        gbc.gridx = 0; gbc.gridy = 4;
        detailsPanel.add(new JLabel("Description:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.BOTH; gbc.weightx = 1.0; gbc.weighty = 1.0;
        JTextArea descArea = new JTextArea(event.description);
        descArea.setEditable(false);
        descArea.setLineWrap(true);
        descArea.setWrapStyleWord(true);
        descArea.setBackground(currentTheme.background);
        detailsPanel.add(new JScrollPane(descArea), gbc);
        
        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(currentTheme.surface);
        
        JButton editBtn = new JButton("Edit");
        editBtn.setBackground(currentTheme.secondary);
        editBtn.setForeground(Color.WHITE);
        editBtn.addActionListener(e -> {
            dialog.dispose();
            showEditEventDialog(event, eventDate);
        });
        
        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBackground(new Color(239, 68, 68));
        deleteBtn.setForeground(Color.WHITE);
        deleteBtn.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(dialog, 
                "Are you sure you want to delete this event?", 
                "Confirm Delete", 
                JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                removeEvent(eventDate, event);
                updateCalendar();
                dialog.dispose();
            }
        });
        
        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(e -> dialog.dispose());
        
        buttonPanel.add(editBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(closeBtn);
        
        dialog.add(detailsPanel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }
    
    private void showEditEventDialog(Event event, LocalDate eventDate) {
        JDialog dialog = new JDialog(this, "Edit Event", true);
        dialog.setSize(400, 350);
        dialog.setLocationRelativeTo(this);
        dialog.setLayout(new BorderLayout(10, 10));
        
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(currentTheme.surface);
        formPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        // Pre-fill fields with current event data
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Event Title:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField titleField = new JTextField(event.title, 20);
        formPanel.add(titleField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1; gbc.fill = GridBagConstraints.NONE;
        formPanel.add(new JLabel("Description:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.BOTH;
        JTextArea descArea = new JTextArea(event.description, 3, 20);
        descArea.setLineWrap(true);
        descArea.setWrapStyleWord(true);
        formPanel.add(new JScrollPane(descArea), gbc);
        
        gbc.gridx = 0; gbc.gridy = 2; gbc.fill = GridBagConstraints.NONE;
        formPanel.add(new JLabel("Date:"), gbc);
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        JTextField dateField = new JTextField(eventDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        formPanel.add(dateField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(new JLabel("Time:"), gbc);
        gbc.gridx = 1;
        JTextField timeField = new JTextField(event.time != null ? event.time.format(DateTimeFormatter.ofPattern("HH:mm")) : "");
        formPanel.add(timeField, gbc);
        
        gbc.gridx = 0; gbc.gridy = 4;
        formPanel.add(new JLabel("Category:"), gbc);
        gbc.gridx = 1;
        JComboBox<String> categoryCombo = new JComboBox<>(new String[]{"Work", "Personal", "Health", "Other"});
        categoryCombo.setSelectedItem(event.category);
        formPanel.add(categoryCombo, gbc);
        
        // Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(currentTheme.surface);
        
        JButton cancelBtn = new JButton("Cancel");
        cancelBtn.addActionListener(e -> dialog.dispose());
        
        JButton saveBtn = new JButton("Save Changes");
        saveBtn.setBackground(currentTheme.primary);
        saveBtn.setForeground(Color.WHITE);
        saveBtn.addActionListener(e -> {
            try {
                String title = titleField.getText().trim();
                String description = descArea.getText().trim();
                LocalDate newDate = LocalDate.parse(dateField.getText());
                LocalTime time = timeField.getText().trim().isEmpty() ? null : LocalTime.parse(timeField.getText());
                String category = (String) categoryCombo.getSelectedItem();
                
                if (title.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "Please enter an event title.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                // Remove old event
                removeEvent(eventDate, event);
                
                // Add updated event
                addEvent(newDate, title, description, category, time);
                
                updateCalendar();
                dialog.dispose();
                
                JOptionPane.showMessageDialog(this, "Event updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Invalid date or time format. Please check your input.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        buttonPanel.add(cancelBtn);
        buttonPanel.add(saveBtn);
        
        dialog.add(formPanel, BorderLayout.CENTER);
        dialog.add(buttonPanel, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }
    
    private void showContextMenu(MouseEvent e, LocalDate date) {
        JPopupMenu contextMenu = new JPopupMenu();
        
        JMenuItem addEventItem = new JMenuItem("Add Event");
        addEventItem.addActionListener(event -> {
            selectedDate = date;
            showAddEventDialog();
        });
        
        JMenuItem viewEventsItem = new JMenuItem("View Events");
        viewEventsItem.setEnabled(events.containsKey(date) && !events.get(date).isEmpty());
        viewEventsItem.addActionListener(event -> {
            // Show events for this date in a popup
            showDayEventsDialog(date);
        });
        
        contextMenu.add(addEventItem);
        contextMenu.add(viewEventsItem);
        contextMenu.show(e.getComponent(), e.getX(), e.getY());
    }
    
    private void showDayEventsDialog(LocalDate date) {
        List<Event> dayEvents = events.getOrDefault(date, new ArrayList<>());
        if (dayEvents.isEmpty()) return;
        
        JDialog dialog = new JDialog(this, "Events for " + date.format(DateTimeFormatter.ofPattern("MMMM d, yyyy")), true);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);
        
        DefaultListModel<Event> model = new DefaultListModel<>();
        dayEvents.forEach(model::addElement);
        
        JList<Event> eventsList = new JList<>(model);
        eventsList.setCellRenderer(new EventListCellRenderer());
        eventsList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Event selectedEvent = eventsList.getSelectedValue();
                    if (selectedEvent != null) {
                        dialog.dispose();
                        showEventDetails(selectedEvent);
                    }
                }
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(eventsList);
        dialog.add(scrollPane, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(e -> dialog.dispose());
        buttonPanel.add(closeBtn);
        
        dialog.add(buttonPanel, BorderLayout.SOUTH);
        dialog.setVisible(true);
    }
    
    private void setupKeyboardShortcuts() {
        // Ctrl+N - New Event
        getRootPane().registerKeyboardAction(
            e -> showAddEventDialog(),
            KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK),
            JComponent.WHEN_IN_FOCUSED_WINDOW
        );
        
        // Ctrl+T - Today
        getRootPane().registerKeyboardAction(
            e -> goToToday(),
            KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.CTRL_DOWN_MASK),
            JComponent.WHEN_IN_FOCUSED_WINDOW
        );
        
        // Arrow keys for navigation
        getRootPane().registerKeyboardAction(
            e -> navigateMonth(-1),
            KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, KeyEvent.CTRL_DOWN_MASK),
            JComponent.WHEN_IN_FOCUSED_WINDOW
        );
        
        getRootPane().registerKeyboardAction(
            e -> navigateMonth(1),
            KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, KeyEvent.CTRL_DOWN_MASK),
            JComponent.WHEN_IN_FOCUSED_WINDOW
        );
    }
    
    private JButton createToolbarButton(String text, ActionListener listener) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setBackground(currentTheme.surface);
        button.setForeground(currentTheme.textPrimary);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        button.setBorder(new EmptyBorder(8, 15, 8, 15));
        
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!button.getBackground().equals(currentTheme.primary)) {
                    button.setBackground(currentTheme.hover);
                }
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                if (!button.getBackground().equals(currentTheme.primary)) {
                    button.setBackground(currentTheme.surface);
                }
            }
        });
        
        return button;
    }
    
    private JToggleButton createViewButton(String text, CalendarView view) {
        JToggleButton button = new JToggleButton(text);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setBackground(currentTheme.surface);
        button.setForeground(currentTheme.textPrimary);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        button.setBorder(new EmptyBorder(8, 15, 8, 15));
        
        button.addActionListener(e -> {
            currentView = view;
            updateCalendar();
        });
        
        button.addItemListener(e -> {
            if (button.isSelected()) {
                button.setBackground(currentTheme.primary);
                button.setForeground(Color.WHITE);
            } else {
                button.setBackground(currentTheme.surface);
                button.setForeground(currentTheme.textPrimary);
            }
        });
        
        return button;
    }
    
    private void switchTheme(String themeName) {
        currentTheme = THEMES.get(themeName);
        applyTheme();
        
        // Update all panels
        getContentPane().removeAll();
        initializeUI(); // Reinitialize all components with new theme
        
        // Update calendar data
        updateCalendar();
        
        revalidate();
        repaint();
    }
    
    private void applyTheme() {
        getContentPane().setBackground(currentTheme.background);
        
        // Update all buttons and text components
        SwingUtilities.invokeLater(() -> {
            updateComponentsWithTheme(this);
        });
    }
    
    private void updateComponentsWithTheme(Container container) {
        for (Component comp : container.getComponents()) {
            if (comp instanceof JButton) {
                JButton button = (JButton) comp;
                if (!button.getBackground().equals(currentTheme.primary)) {
                    button.setBackground(currentTheme.surface);
                    button.setForeground(currentTheme.textPrimary);
                }
            } else if (comp instanceof JLabel) {
                ((JLabel) comp).setForeground(currentTheme.textPrimary);
            } else if (comp instanceof JPanel) {
                ((JPanel) comp).setBackground(currentTheme.surface);
                updateComponentsWithTheme((Container) comp);
            } else if (comp instanceof Container) {
                updateComponentsWithTheme((Container) comp);
            }
        }
    }
    
    private void navigateMonth(int direction) {
        currentDate = currentDate.plusMonths(direction);
        updateCalendar();
    }
    
    private void goToToday() {
        currentDate = LocalDate.now();
        selectedDate = LocalDate.now();
        updateCalendar();
    }
    
    private void addEvent(LocalDate date, String title, String description, String category, LocalTime time) {
        Event event = new Event(title, description, category, time);
        events.computeIfAbsent(date, k -> new ArrayList<>()).add(event);
    }
    
    private void removeEvent(LocalDate date, Event event) {
        List<Event> dayEvents = events.get(date);
        if (dayEvents != null) {
            dayEvents.remove(event);
            if (dayEvents.isEmpty()) {
                events.remove(date);
            }
        }
    }
    
    private Color getEventColor(String category) {
        return switch (category) {
            case "Work" -> new Color(59, 130, 246);
            case "Personal" -> new Color(139, 69, 19);
            case "Health" -> new Color(34, 197, 94);
            default -> new Color(107, 114, 128);
        };
    }
    
    // Inner classes
    private static class Event {
        String title;
        String description;
        String category;
        LocalTime time;
        
        public Event(String title, String description, String category, LocalTime time) {
            this.title = title;
            this.description = description;
            this.category = category;
            this.time = time;
        }
        
        @Override
        public String toString() {
            String timeStr = time != null ? time.format(DateTimeFormatter.ofPattern("HH:mm")) + " - " : "";
            return timeStr + title;
        }
    }
    
    private static class Theme {
        Color background, surface, primary, secondary, textPrimary, textSecondary, accent, hover;
        
        public Theme(Color background, Color surface, Color primary, Color secondary, 
                    Color textPrimary, Color textSecondary, Color accent, Color hover) {
            this.background = background;
            this.surface = surface;
            this.primary = primary;
            this.secondary = secondary;
            this.textPrimary = textPrimary;
            this.textSecondary = textSecondary;
            this.accent = accent;
            this.hover = hover;
        }
    }
    
    private class EventListCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            
            if (value instanceof Event) {
                Event event = (Event) value;
                setIcon(createColorIcon(getEventColor(event.category)));
                
                if (!isSelected) {
                    setBackground(currentTheme.surface);
                    setForeground(currentTheme.textPrimary);
                }
            }
            
            return this;
        }
        
        private Icon createColorIcon(Color color) {
            return new Icon() {
                @Override
                public void paintIcon(Component c, Graphics g, int x, int y) {
                    g.setColor(color);
                    g.fillOval(x, y, getIconWidth(), getIconHeight());
                }
                
                @Override
                public int getIconWidth() { return 12; }
                
                @Override
                public int getIconHeight() { return 12; }
            };
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            new AdvancedCalendar().setVisible(true);
        });
    }
}