package naskar;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

    public static void printSpecial(Object b)
    {
        //if b is string then print its first char
        // but if b is a human, then print its age
        //otherwise print "Dont Know"

        // if(b instanceof Human h && !(b instanceof Emp))
        if(b.getClass() == Human.class)
            System.out.println(((Human) b).getAge());

        else if (b instanceof String s) 
            System.out.println(s.charAt(0));

        else
            System.out.println("Dont Know");

    }

    public static void main(String[] args) {
        
    //     Human h1 = new Human();
    //     h1.disp();

    //     Human h2 = new Human("Himesh", 23);
    //     h2.disp();

    //     Emp e1 = new Emp();
    //     e1.disp();

    //     Emp e2 = new Emp("Emily", 27, 40000);
    //     e2.disp();

    //     //Manager m1 = new Manager();

    //     //e1 = h1;  //Compile time ERROR

    //     // but h1 actually contain a instance of Emp

    //     //e1 = (Emp) h1;  //type broadening

    //     e1.disp();  // "Emily", 27, 400000

    //     // e1 = h2;    //Compile time ERROR

    //     //e1 = (Emp) h2;  //Compile time ERROR

    //     if(h2 instanceof Emp)   //false
    //         e1 = (Emp) h2;      //so, does not execute

    //     if(h1 instanceof Emp)   //true
    //         e1 = (Emp) h1;      //executes

    //     Human all[] = new Human[5];

    //     all[0] = new Emp("Esha", 23, 40000);
    //     all[1] = new Human("Hemant", 17);
    //     all[2] = new Manager("Manas", 45, 800000, "Accounts");
    //     all[3] = new Emp("Elizabeth", 35, 25000);
    //     all[4] = new Human("Hashim", 30);

    //     for(Human h : all)
    //     {
    //         h.disp();

    //         if(h instanceof Manager m) //New Syantax (MAnager m stores values of h)
    //             System.out.println("Department = " + m.getdept());
    //         else if(h instanceof Emp)
    //         {   
    //             Emp e = (Emp) h;
    //             System.out.println("Salary = " + e.getSal());  
    //         }  
    //         else    // if(h instanceof Human)
    //             System.out.println("Age = " + h.getAge());
    //     }
    //     System.out.println(h1);

        Emp e = new Emp("Amitabh", new GregorianCalendar(1933, 4, 23), 800000);
        Emp g = new Emp("Amitabh", new GregorianCalendar(1933, 4, 23), 800000);
        Emp k = new Emp("Amitabh", new GregorianCalendar(1933, 5, 23), 800000);

        System.out.println(e);
        System.out.println(e.equals(g));
        System.out.println(e.equals(k));

        Human h = new Human();
        printSpecial("Nakshatra"); //N
        printSpecial(k); //92
        printSpecial(h);
    }
}
