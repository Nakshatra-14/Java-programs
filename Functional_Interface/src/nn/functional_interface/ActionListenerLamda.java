package nn.functional_interface;

import java.awt.Color;
import javax.swing.JButton;

public class ActionListenerLamda {
    public static void main(String[] args) {
        JButton btnColour = new JButton("Change Color");
        
        // btnColour.addActionListener(new ActionListener()
        // {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         JButton btn = (JButton) e.getSource();
        //         btn.setBackground(Color.orange);
        //     }
        // }
        // );

        //OR

        // ActionListener lsn = (e) -> btnColour.setBackground(Color.orange);
        
        btnColour.addActionListener((e) -> btnColour.setBackground(Color.orange));
    }
}
