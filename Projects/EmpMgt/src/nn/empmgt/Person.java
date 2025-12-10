package nn.empmgt;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Person {
    private String name;
    private String address;
    private String dob;
    private String gender;
    private String email;
    private int occupationIndex;
    private String username;
    private String password;

    public Person(String name, String dob, String gender, String address, String email, String occupation, String username, String password) {
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.gender = gender;
        this.name = name;
        this.occupationIndex = Integer.parseInt(occupation) - 1;
        this.password = password;
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public int getOccupationIndex() {
        return occupationIndex;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static ArrayList<Person> generate() throws IOException
    {
        ArrayList<Person> al = new ArrayList<>();
        // al.add(new Person("Nikil", "10-11-2002", "M", "Kolkata", "abc123@mail.com", "Doctor", "nikil123", "nik123"));
        // al.add(new Person("Mukesh", "11-01-2003", "F", "Hydrabad", "def123@mail.com", "Engineer", "mukesh456", "muk456"));
        
        File file = new File("indian_1000_records.csv");
        CSV csv = new CSV();
        try
        (
            Scanner inp = new Scanner(file);            
        )
        {
            inp.nextLine();
            while (inp.hasNextLine()) {
                String arr[] = csv.extract(inp.nextLine());
                
                // arr = inp.nextLine().split(",");
                
                Person p = new Person(arr[2], arr[6], arr[3], arr[7], arr[4], arr[8], arr[0], arr[1]);
                al.add(p);
            }


        return al;
        }

    }


}
