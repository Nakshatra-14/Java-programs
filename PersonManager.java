import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Consumer;

public class PersonManager {
    public static void printPerson(List<Person> lst)
    {
        System.out.printf("%-6s | %-15s | %-15s | %-10s | %-4s | %-6s%n", "ID", "Name", "City", "Salary", "Age", "Gender");
        System.out.println("-----------------------------------------------------------------------");
        for (Person p : lst) {
        System.out.println(p);
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        List<Person> people = Person.generate(); 
        // ArrayList<Person> people = (ArrayList<Person>) Person.generate(); 
        // System.out.println(people.toString());

        // Comparator<Person> ladiesFirst = new Comparator<Person>() {
        //     @Override
        //     public int compare(Person a, Person b) {
        //         return a.getSex() - b.getSex();
        //     }
            
        // };
        // people.sort(ladiesFirst);


         Consumer<Person> job = (Person p) -> System.out.println(p);

        // System.out.println("Namewise Sort (natural order)");
        // people.sort(Comparator.naturalOrder());

        printPerson(people);
    }
}
