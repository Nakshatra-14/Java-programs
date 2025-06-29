
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Scanner;

import javax.swing.Timer;


public class DigitalClock {
    public static void main(String[] args) {
        
        new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                System.out.print("\r");
                System.out.print(new Date());
            }
        }).start();
        new Scanner(System.in).nextLine();
    }
}