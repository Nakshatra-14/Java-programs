package nn.gui;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class JListUsingMVC {

    public static void main(String[] args) {

        // String days[] = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        ListModel<String> model = new ListModel<String>() {

            @Override
            public int getSize() {
                return 10000;
            }

            @Override
            public String getElementAt(int index) {
               return String.valueOf(index + 1);
            }

            @Override
            public void addListDataListener(ListDataListener l) {
                
            }

            @Override
            public void removeListDataListener(ListDataListener l) {
                
            }
        };

        JList<String> lst = new JList<>();
        lst.setModel(model);
        lst.setPrototypeCellValue("w".repeat(4));
        JScrollPane scpName = new JScrollPane(lst);
        


        JFrame jf = new JFrame();

        jf.setSize(200, 250);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
        
        JPanel jp = new JPanel();
        jf.add(jp);

        jp.add(scpName);
        jf.setVisible(true);
    }
}
