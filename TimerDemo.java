import java.util.Date;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;;

public class TimerDemo {

    public static void main(String[] args) 
    {    
        new Timer(1000, new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.out.print("\r");
                System.out.print(new Date().toString());
            }
        }).start();
        new Scanner(System.in).nextLine();
    }

}