import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Person {
    private int id;
    private String name;
    private int age;
    private String city;
    private float salary;
    private char gender;

    public Person(int id, String name, String city, float salary, int age, char gender) {
        this.age = age;
        this.city = city;
        this.gender = gender;
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public static List<Person> generate() throws FileNotFoundException
    {
        List<Person> alp = new ArrayList<>();
        File file = new File("emp_data.csv");
        try (
                Scanner inp = new Scanner(file);
            ) 
            {
                inp.nextLine();
                while (inp.hasNextLine()) {
                    String ar[] = inp.nextLine().split("," ); 
                    int id = Integer.parseInt(ar[0]);
                    String name = ar[1].trim();
                    String city = ar[2].trim();
                    float salary = Float.parseFloat(ar[3]);
                    int age = Integer.parseInt(ar[4]);
                    char gender = ar[5].charAt(0);
                    alp.add(new Person(id, name, city, salary, age, gender));
                }
            }
        return alp;
    }

    public char getSex()
    {
        return gender; 
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public int getAge()
    {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%-6d | %-15s | %-15s | %-10.2f | %-4d | %-6s", id, name, city, salary, age, (gender == 'M') ? "Male" : "Female");
    }
}
