package nn.gui;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.AbstractListModel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListDataListener;
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

    public static void updateCities(JList<String> lst, String[] arr)
    {
        AbstractListModel<String> model = new AbstractListModel<String>() {

            @Override
            public int getSize() {
                return arr.length-1;
            }

            @Override
            public String getElementAt(int index) {
               return arr[index+1];
            }
        };
        lst.setModel(model);
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
        jf.setTitle("States, Capitals and Cities");
        // jf.setSize(300, 250);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        
        // JPanel jp = new JPanel();
        JPanel jp = new JPanel(new BorderLayout(10, 10));
        JPanel pFlowlyt = new JPanel();
        jf.add(jp);
        jp.add(pFlowlyt, BorderLayout.SOUTH);
        JTextField jtf = new JTextField(" ".repeat(40));

        JList<String> cityList = new JList<>();
        JList<String> stateList = new JList<>(states);
        stateList.setPrototypeCellValue("w".repeat(40));
        // cityList.setPrototypeCellValue("w".repeat(20));
        JScrollPane scpState = new JScrollPane(stateList);
        JScrollPane scpCity = new JScrollPane(cityList);

        stateList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        stateList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!stateList.getValueIsAdjusting())
                {
                    String s = stateList.getSelectedValue();
                    try {
                        String cities[] = showCapitalAndCities(file, s);
                        jtf.setText(cities[0]);

                        // if(cities[1] == null)
                        //     updateCities(cityList, new String[] {"No City"});
                        updateCities(cityList, cities);
                    } catch (IOException ex) {
                    }
                }
            }
            
        });

        jp.add(new JLabel("States:"), BorderLayout.NORTH);
        jp.add(scpState, BorderLayout.CENTER);
        pFlowlyt.add(new JLabel("Capital: "));
        pFlowlyt.add(jtf);
        pFlowlyt.add(new JLabel("City: "));
        pFlowlyt.add(scpCity);
        jf.pack();
        jf.setVisible(true);

        // jp.add(scpState);
        // jp.add(new JLabel("Capital: "));
        // jp.add(jtf);
        // jp.add(scpCity);
        // jf.pack();
        // jf.setVisible(true);
    }
}
