package naskar;

public class Human {
    private String name;
    private int age;

    public Human()
    {
        name = "<no-name>";
        age = 20;
    }

    public Human(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public int getAge()
    {
        return age;
    }

    public void disp()
    {
        System.out.println(name + ", " + age);
    }

    public static void main(String[] args) {
        System.out.println("Testing Human: ");
        Human h = new Human();
        h.disp();
    }
}
