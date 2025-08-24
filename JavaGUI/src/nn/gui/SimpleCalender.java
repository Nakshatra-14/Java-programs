package nn.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SimpleCalender extends JFrame{

    JLabel monthJl, yearJl, weekday;
    String dayName[] = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
    String months[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September","October", "November", "December" };
    Integer[] years = { 2020, 2021, 2022, 2023, 2024, 2025 };
    // int days[] = new int[7*6];
    JLabel dayLabels[] = new JLabel[7*6];
    Font headerFont = new Font("Times New Roman", Font.PLAIN, 30);
    JComboBox<String> cmbMonth;
    JComboBox<Integer> cmbYear;


    public String getMonth(int n)
    {
        return months[n];
    }

    // public void setDaysInArr()
    // {
    //     int mday = gc.get(Calendar.DAY_OF_MONTH);
    //     for(int i = 0 ; i < days.length ; i++)
    //     {
    //         if(i < mday)
    //             days[i] = i+1;
    //     }
    // }

    // public void setDaysInArr()
    // {
    //     int dFirst = new GregorianCalendar(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH), 1).get(Calendar.DAY_OF_WEEK);
    //     int dMax = gc.getMaximum(Calendar.DAY_OF_MONTH);
    //     System.out.println(dFirst + " " + dMax);
    //     int n = 1;
    //     for(int i = 1 ; i < dMax + dFirst ; i++)
    //     {
    //         if(i >= dFirst)
    //         {
    //             days[i-1] = n;
    //             n++;
    //         }
    //         else
    //             days[i-1] = 0;
    //     }
    // }

    private void showCalender()
    {
        // int month = 7;//august
        // int year = 2025;
        int month = cmbMonth.getSelectedIndex();
        int year = (Integer) cmbYear.getSelectedItem();
        int dow; // day of week no. of a given month 
        GregorianCalendar gc = new GregorianCalendar(year, month, 1);
        dow = gc.get(Calendar.DAY_OF_WEEK) - Calendar.SUNDAY;
        

        
        gc.add(Calendar.DATE, -1);
        int lastMaxDay = gc.get(Calendar.DATE);
        
        gc.add(Calendar.MONTH, 1);
        int maxDay = gc.get(Calendar.DATE);
        System.out.println(maxDay);

        gc = new GregorianCalendar();
        int curDay = gc.get(Calendar.DATE);
        int curMonth = gc.get(Calendar.MONTH);
        int curYear = gc.get(Calendar.YEAR);
        // System.out.println(Calendar.SUNDAY);

        System.out.println(year + " " + month);

        for(int i = dow - 1 ; i >= 0 ; i--)
        {
            dayLabels[i].setForeground(Color.gray);
            dayLabels[i].setText(String.valueOf(lastMaxDay));
            lastMaxDay--;
        }
        int d = dow;
        for(int i = 1 ; i <= maxDay ; i++)
        {
            Color c = Color.BLACK;
            if(dow%7 == 0)
                c = Color.RED;
            dayLabels[dow].setForeground(c);
            dayLabels[dow].setText(String.valueOf(i));
            dow++;
        }

        int n = 1;
        for (int i = dow ; i < dayLabels.length; i++) {
            dayLabels[i].setForeground(Color.gray);
            dayLabels[i].setText(String.valueOf(n));
            n++;
        }

        if(year == curYear && month == curMonth)
        {
            dayLabels[d + curDay - 1].setForeground(Color.green);
            System.out.println(curDay);
        }


        
    }

    public SimpleCalender()
    {
        setTitle("Calender");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel main = new JPanel(new BorderLayout());
        JPanel header = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        JPanel container = new JPanel(new BorderLayout());
        JPanel headerDays = new JPanel(new GridLayout(1, 7));
        JPanel daysContainer = new JPanel(new GridLayout(6, 7));

        main.add(header, BorderLayout.NORTH);
        main.add(container, BorderLayout.CENTER);
        container.add(headerDays, BorderLayout.NORTH);
        container.add(daysContainer, BorderLayout.CENTER);
        add(main);

        JButton backwardBtn = new JButton("<");
        backwardBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int index = cmbMonth.getSelectedIndex() - 1;
                if(index < 0)
                {
                    index = cmbMonth.getItemCount() - 1;
                    cmbYear.setSelectedIndex(cmbYear.getSelectedIndex() - 1);
                }
               cmbMonth.setSelectedIndex(index);
            }

        });
        header.add(backwardBtn);

        cmbMonth = new JComboBox<>(months);
        cmbMonth.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                showCalender();
            }

        });
        header.add(cmbMonth);

        cmbYear = new JComboBox<>(years);
        cmbYear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               showCalender();
            }

        });
        header.add(cmbYear);

        JButton forwardBtn = new JButton(">");
        forwardBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               
            }

        });
        header.add(forwardBtn);

        for (int i = 0; i < dayName.length; i++)    //weekday Label
        {
            JLabel dayNameTxt = new JLabel(dayName[i]);
            dayNameTxt.setHorizontalAlignment(JLabel.CENTER);
            headerDays.add(dayNameTxt);
        }

        // setDaysInArr();

        for(int i = 0 ; i < dayLabels.length ; i++) // day Label
        {
            JLabel daysTxt = new JLabel("  ");
            daysTxt.setHorizontalAlignment(JLabel.CENTER);
            daysContainer.add(daysTxt);
            dayLabels[i] = daysTxt;
        }

        // pack();
        GregorianCalendar g = new GregorianCalendar();
        int curMonth = g.get(Calendar.MONTH);
        int curYear = g.get(Calendar.YEAR);

        cmbMonth.setSelectedIndex(curMonth);
        cmbYear.setSelectedIndex(curYear - cmbYear.getItemAt(0));
        showCalender();
    }

    public static void main(String[] args) {
        new SimpleCalender().setVisible(true);
    }
}
