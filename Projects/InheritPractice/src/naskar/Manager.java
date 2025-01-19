package naskar;

public class Manager extends Emp{
    
    private String dept;

    public Manager()
    {
        dept = "Sales";
    }

    public Manager(String nm, int ag, float sal, String dept)
    {
        super(nm, ag, sal);
        this.dept = dept;
    }

    public String getdept()
    {
        return dept;
    }

    public void disp()
    {
        super.disp();
        System.out.println("\t\t\t" + dept);
    }

    public static void main(String[] args) {
        System.out.println("Testing Manager: ");
        Manager m = new Manager();
        m.disp();
    }
}
