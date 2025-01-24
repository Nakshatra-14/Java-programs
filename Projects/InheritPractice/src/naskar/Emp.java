package naskar;

import java.util.GregorianCalendar;

public class Emp extends Human{

    private float salary;

    public Emp()
    {
        salary = 10000;
    }

    public Emp(String nm, GregorianCalendar dob, float sal)
    {
        super(nm, dob);
        salary = sal;
    }
    

    public float getSal()
    {
        return salary;
    }

    @Override
    public String toString()
    {
        return super.toString() + ", " + salary;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Emp e && super.equals(obj) && salary == e.salary;
    }


    public static void main(String[] args) {
        System.out.println("Testing Emp: ");
        Emp e = new Emp();
        System.out.println(e);
    }
}
