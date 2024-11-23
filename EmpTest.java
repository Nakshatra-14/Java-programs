class Emp
{
    private String name ;
    private int age ;
    private float sal ;

    // no-argument constructor (default constructor)
    public Emp()
    {
        this("<noname>", 18, 10000) ;
    }

    // parameterized constructor
    public Emp(String nm, int ag, float sl)
    {
        name = nm ;
        age = ag ;
        if(age < 18)
           age = 18 ;
        sal = sl ;
    }

    // Copy constructor
    public Emp(Emp x)
    {
        this(x.name, x.age, x.sal) ;
    }

    public void set(String nm, int ag, float sal)
    {
        name = nm ;
        age = ag ;
        this.sal = sal ;
    }

    public void disp()
    {
        System.out.println(name + ", " + age + ", " + sal) ;
    }

    // getter method
    public int getAge()
    {
        return age ;
    }

    // setter method
    public void setAge(int ag)
    {
        if(ag >= 18)
            age = ag ;
    }

    public float getSal() { return sal ;}

}

public class EmpTest
{
    public static void main(String args[])
    {
        Emp g ; // g is a reference variable that can store reference of an object of type Emp

        g = new Emp() ;
        g.disp(); // <noname>, 18, 10000

        g.set("Girish", 29, 30000) ;
        g.disp(); // Girish, 29, 30000.0

        Emp a = new Emp("Ravish", 32, 45000) ;
        a.disp(); // Ravish, 32, 45000.0

        Emp b = new Emp(g) ;
        b.disp(); // Girish, 29, 30000.0

        // Emp ar[] = new Emp[5] ;

        // ar[0] = new Emp("Kumaresh", 23, 890000) ;
        // ar[1] = new Emp("Ramadhir", 28, 70000) ;
        // ar[2] = new Emp("Chandrakant", 32, 6000) ;
        // ar[3] = new Emp("Naveen", 27, 45000) ;
        // ar[4] = new Emp("Alok", 21, 81000) ;

        // System.out.println("Before sorting : ");
        // for(Emp e : ar)
        //     e.display();

        // Emp.sort(ar) ;
        

        // System.out.println("After sorting : ");
        // for(Emp e : ar)
        //     e.display();


        

        //     int i ;
    //     Emp e ; // e is declared as a reference variable to an instance of Emp

    //     System.out.println(i) ; // error!
    //     System.out.println(e) ; // error!

    //     e = new Emp() ; // new instance (object) of Emp class is created and its referebce is stored to e
    //     e.display();  // null, 0, 0.0

    //     e.set("Emily", 23, 40000) ;
    //     e.display();  // Emily, 23, 40000

    //     Emp g = new Emp() ;
    //     g.display(); // null, 0, 0.0

    //     g.set("Gautam", 40, 63000) ;
    //     g.display();  // Gautam 40, 63000

    //     System.out.println(g.age) ; // COMPILER ERROR! age cannot be accessed from outside of Emp class.

    //     System.out.println(g.getAge()) ; // 40
    //     g.age = 54 ; // Error!

    //     g.setAge(54) ;
    //     g.display();  // Gautam 54, 63000

    //     // Increase age of g by 16 years
    //     g.setAge(g.getAge() + 16) ;  // increase age by 16 years.

    //    g.setSal(g.getSal() * 1.1) ; // increase salary by 10% assuming Emp contains setSal() method



    //     Emp p = new Emp() ; // new instance (object) of Emp class is created by calling no-arg constructor and its referebce is stored to e
    //     p.display(); // <noname>, 18, 10000

    //     Emp q = new Emp("Tushar", 35, 90000) ;
    //     q.display(); // Tushar, 35, 90000

    //     Emp r = new Emp() ;
    //     r.display();  // <noname>, 18, 10000
    //     r.set("Rahul", 27, 80000) ;
    //     r.display() ; // Rahul, 27, 80000

    //     Emp s = new Emp(r) ;
    //     s.display(); // Rahul, 27, 80000

    //     r.setAge(30) ;
    //     s.setAge(40) ;

    //     r.display(); // Rahul, 30, 80000
    //     s.display(); // Rahul, 40, 80000


    //     Scanner inp = new Scanner(System.in) ;

    //     // Create two employees by taking inputs from the user and then print them in descending order of their salaries
    //     System.out.print("Enter name : ") ;
    //     String name1 = inp.nextLine() ;

    //     System.out.print("Enter age : ") ;
    //     int age1 = inp.nextInt() ;

    //     System.out.print("Enter salary : ") ;
    //     float sal1 = inp.nextFloat() ;

    //     Emp k = new Emp(name1, age1, sal1) ;

    //     System.out.print("Enter name : ") ;
    //     String name2 = inp.nextLine() ;

    //     System.out.print("Enter age : ") ;
    //     int age2 = inp.nextInt() ;

    //     System.out.print("Enter salary : ") ;
    //     float sal2 = inp.nextFloat() ;

    //     Emp l = new Emp(name2, age2, sal2) ;

    //     if(k.getSal() > l.getSal()) // If salary of k is more than salary of l then
    //     {
    //         k.display();
    //         l.display();
    //     }
    //     else
    //     {
    //         l.display();
    //         k.display();
    //     }

     }

}


/*
    A constructor is a special type of method of a class that has got the same name as that of the class and no retrun type.
    Such a method cannot be called explicitly immediately after only once an object of the class is created. A consctructor
    is generally used initialize an object of the class or to do any start-up job.
*/

/*
class Emp
{
    ...

}

In Java it is possible to create more that one method with the same name but different signatures. By signature of a method
we mean the number and/or type of parameters of the method but not the return type. This feature is one type of stattic polymorphism.


int add(int a, int b)
int add(int a, int b, int b)
int add(float a, float b)



calling
========
int p = add(2, 6) ;  // calls the first method
float g = add(5.8, 7.3) ; // calls the third method
p = add(2, 6, 9) ; // calles the second method

Polymorphism
------------
One interface, multipile uses.


*/
