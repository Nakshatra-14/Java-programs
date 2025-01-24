package naskar;

import java.util.GregorianCalendar;

public class Manager extends Emp{
    
    private String dept;

    public Manager()
    {
        dept = "Sales";
    }

    public Manager(String nm, GregorianCalendar dob, float sal, String dept)
    {
        super(nm, dob, sal);
        this.dept = dept;
    }

    public String getdept()
    {
        return dept;
    }

    @Override
    public String toString()
    {
        return super.toString() + ", " + dept;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Manager m && super.equals(obj) && dept == m.dept;
    }

    public static void main(String[] args) {
        System.out.println("Testing Manager: ");
        Manager m = new Manager();
        System.out.println(m);;
    }
}
