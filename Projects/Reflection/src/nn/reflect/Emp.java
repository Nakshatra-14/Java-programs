package nn.reflect;

public class Emp {
    
    private String name;
    private int age;
    private double sal;

    public Emp(String name, int age, double sal) {
        this.name = name;
        this.age = age;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSal() {
        return sal;
    }
}

