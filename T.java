// class Programmer {
//     private String name;
//     private int salary;
//     private int pin;

//     // Constructor
//     Programmer(String name, int salary, int pin) {
//         this.name = name;
//         this.salary = salary;
//         this.pin = pin;
//     }

//     // Display method
//     public void disp() {
//         System.out.println(name + ", " + salary + ", " + pin);
//     }
// }

// // Main class
// class T {
//     public static void main(String[] args) {
//         Programmer p = new Programmer("Harry", 12000000, 254001);
//         p.disp();
//     }
// }

public class T
{
    public static void test(int n[])
    {
        n[0]++;
    }
    public static void main(String[] args) {

        int n = 123;

        int a = n%10;

        int b = n%100;

        int c = n%1000;


        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
