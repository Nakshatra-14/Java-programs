package nn.gui;


import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test extends JFrame {

    public Test()
    {
        setTitle("Test");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new JPanel();

        
        
        add(p);
    }
    
    public static void main(String[] args) {
        new Test().setVisible(true);
    }
}
