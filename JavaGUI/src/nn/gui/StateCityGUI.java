package nn.gui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class StateCityGUI {

    public static String[] showCapitalAndCities(File file, String state) throws IOException
    {
        Scanner inp = new Scanner(file);
        ArrayList<String> al = new ArrayList<>();
        // boolean gotCap = false;
        // String cap = "";
        while(inp.hasNextLine())
        {
            boolean f = false;
            String s = inp.nextLine();
            String sta = s.substring(43);
            String city = s.substring(0, 43).trim();
            if(state.equals(sta))
            {
                // if(!gotCap)
                // {
                //     cap = city;
                //     gotCap = true;
                // }
                // else
                // {
                    al.add(city);
                    f = true;
                // }
            }
            if(f && !state.equals(sta))
                break;
        }
        inp.close();
        String cities[] = new String[al.size()];
        cities = al.toArray(cities);
        System.out.println("Capital: " + cities[0]);
        System.out.println("States:\n" + Arrays.toString(cities));

        return cities;
    }
    
    public static void main(String[] args) throws IOException {

        File file = new File("StatewiseCitiesOfIndia.txt");
        Scanner inp = new Scanner(file);
        ArrayList<String> al = new ArrayList<>();
        inp.nextLine(); //Skip first line
        String prvState = "";
        while(inp.hasNextLine())
        {
            String s = inp.nextLine();
            String state = s.substring(43);
            String city = s.substring(0, 43).trim();
            if(!prvState.equals(state))
            {
                al.add(state);
                prvState = state;
            }
        }
        inp.close();

        String states[] = new String[al.size()];

        states = al.toArray(states);
        // System.out.println(Arrays.toString(states));

        JFrame jf = new JFrame();
        // jf.setSize(300, 250);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        
        JPanel jp = new JPanel();
        jf.add(jp);

        JTextField jtf = new JTextField(" ".repeat(40));

        JList<String> stateList = new JList<>(states);
        stateList.setPrototypeCellValue("w".repeat(20));
        JScrollPane scpName = new JScrollPane(stateList);

        stateList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        stateList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!stateList.getValueIsAdjusting())
                {
                    String s = stateList.getSelectedValue();
                    try {
                        String cities[] = showCapitalAndCities(file, s);
                        jtf.setText("helloo");
                    } catch (IOException ex) {
                    }
                }
            }
            
        });

        
        jp.add(scpName);
        jp.add(jtf);
        jf.pack();
        jf.setVisible(true);
    }
}
