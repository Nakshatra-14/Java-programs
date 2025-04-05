import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Emp e = new Emp("Emily", 28, 20000);

        Property props[] = new Property[4];

        props[0] = e.getNameProperty();
        props[1] = e.getAgeProperty();
        props[2] = e.getSalProperty();
        props[3] = e.getSalProperty();

        for(int i = 0 ; i < props.length ; i++)
        {
            System.out.printf("%-30s : %s%n", props[i].getName(), props[i].getVal());
            System.out.print("Enter new : " + props[i].getName() + " : ");
            String val = input.nextLine();
            props[i].setVal(val);
            System.out.println(e);
            System.out.println("-------------------------------------------");
        }
    }
}
