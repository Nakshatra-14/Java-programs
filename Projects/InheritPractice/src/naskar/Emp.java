package naskar;

public class Emp extends Human{

    private float salary;

    public Emp()
    {
        salary = 10000;
    }

    public Emp(String nm, int ag, float sal)
    {
        super(nm, ag);
        salary = sal;
    }
    

    public float getSal()
    {
        return salary;
    }

    public void disp()
    {
        super.disp();
        System.out.println("\t\t" + salary);
    }

    public static void main(String[] args) {
        System.out.println("Testing Emp: ");
        Emp e = new Emp();
        e.disp();
    }
}
