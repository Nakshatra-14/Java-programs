package nn.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calender extends JFrame implements ActionListener {

    String[] days = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
    String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December" };
    String[] years = { "2020", "2021", "2022", "2023", "2024", "2025" };
    JButton forwardBtn, backwardBtn;
    JComboBox<String> cmbMonth;
    JComboBox<String> cmbYear;
    Font dayHeaderfont = new Font("Times New Roman", Font.PLAIN, 20);
    int day[] = new int[35];
    String selectedMonth, selectedYear;
    GregorianCalendar gc = new GregorianCalendar();

    public void setShow()
    {
        System.out.println("Selected Month: " + selectedMonth + ", Selected Year: " + selectedYear);
    }

    public Calender() {
        setTitle("Calender");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel main = new JPanel(new BorderLayout());
        JPanel header = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 2));
        JPanel container = new JPanel(new BorderLayout());
        JPanel dayHeader = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 2));
        JPanel showDay = new JPanel(new FlowLayout());

        main.add(header, BorderLayout.NORTH);
        main.add(container, BorderLayout.CENTER);

        container.add(dayHeader, BorderLayout.NORTH);
        container.add(showDay, BorderLayout.CENTER);

        add(main);

        main.setBackground(Color.CYAN);
        header.setBackground(Color.BLUE);
        container.setBackground(Color.PINK);
        dayHeader.setBackground(Color.RED);
        showDay.setBackground(Color.GREEN);

        backwardBtn = new JButton("<");
        backwardBtn.addActionListener(this);
        header.add(backwardBtn);

        cmbMonth = new JComboBox<>(months);
        cmbMonth.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selectedMonth = (String) cmbMonth.getSelectedItem();
                selectedYear = String.valueOf(cmbYear.getSelectedItem());
                System.out.println("Selected Month: " + selectedMonth + ", Selected Year: " + selectedYear);
            }

        });
        header.add(cmbMonth);

        cmbYear = new JComboBox<>(years);
        cmbYear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                selectedMonth = (String) cmbMonth.getSelectedItem();
                selectedYear = String.valueOf(cmbYear.getSelectedItem());
                System.out.println("Selected Month: " + selectedMonth + ", Selected Year: " + selectedYear);
            }

        });
        header.add(cmbYear);

        forwardBtn = new JButton(">");
        forwardBtn.addActionListener(this);
        header.add(forwardBtn);

        for (int i = 0; i < days.length; i++)
            showDay.add(new JLabel(days[i])).setFont(dayHeaderfont);


    }

    public static void main(String[] args) {
        new Calender().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        setShow();

    }

}
