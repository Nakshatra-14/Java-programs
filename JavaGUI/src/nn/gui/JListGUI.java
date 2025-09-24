package nn.gui;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JListGUI {
    public static void main(String[] args) {
        String names[] = {
            "Alice", "Bob", "Charlie", "David", "Eve",
            "Frank", "Grace", "Hannah", "Ivy", "Jack",
            "Karen", "Leo", "Mona", "Nina", "Oscar",
            "Paul", "Quinn", "Rita", "Sam", "Tina"
        };

        JList<String> nameList = new JList<>(names);

        JScrollPane scpName = new JScrollPane(nameList);

        nameList.setVisibleRowCount(10);

        // nameList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        nameList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        nameList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent ev) {
                if(!nameList.getValueIsAdjusting())
                {
                    //For single selection
                    // String s = String.valueOf(nameList.getSelectedValue());
                    // int index = nameList.getSelectedIndex();

                    // System.out.println(s);

                    //For multiple selection
                    for (String e : nameList.getSelectedValuesList()) {
                        System.out.println(String.valueOf(e));
                    }
                    //OR
                    // for(int ind = nameList.getSelectedIndex(); ind < names.length ; ind++)
                    //     System.out.println(names[ind]);
                }
            }
        });

        JFrame jf = new JFrame();

        jf.setSize(100, 250);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        
        JPanel jp = new JPanel();
        jf.add(jp);
        
        jp.add(scpName);
        jf.setVisible(true);
    }
}
