package nn;

import java.util.ArrayList;

public class Person {
    private String name;
    private String address;
    private String dob;
    private String gender;
    private String email;
    private String occupation;
    private String username;
    private String password;

    public Person(String name, String dob, String gender, String address, String email, String occupation, String username, String password) {
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.gender = gender;
        this.name = name;
        this.occupation = occupation;
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

    public String getOccupation() {
        return occupation;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static ArrayList<Person> generate()
    {
        ArrayList<Person> al = new ArrayList<>();
        al.add(new Person("Nikil", "10-11-2002", "M", "Kolkata", "abc123@mail.com", "Doctor", "nikil123", "nik123"));
        al.add(new Person("Mukesh", "11-01-2003", "F", "Hydrabad", "def123@mail.com", "Engineer", "mukesh456", "muk456"));
        return al;
    }
}
