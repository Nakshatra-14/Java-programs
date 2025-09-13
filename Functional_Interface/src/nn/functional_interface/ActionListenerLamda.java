package nn.functional_interface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class ActionListenerLamda {
    public static void main(String[] args) {
        JButton btnColour = new JButton("Change Color");

        btnColour.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton btn = (JButton) e.getSource();
                btn.setBackground(Color.orange);
            }
        }
        );

        //OR

        btnColour.addActionListener(() -> this.setBackground(Color.orange));
    }
}
