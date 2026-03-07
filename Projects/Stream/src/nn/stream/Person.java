package nn.stream;

import java.time.LocalDate;
import java.util.stream.Stream;

public class Person {
    private String name;
    private String profession;
    private LocalDate birthday;
    private String hobby;

    public Person(String name, String profession, LocalDate birthday, String hobby) {
        this.name = name;
        this.profession = profession;
        this.birthday = birthday;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", profession='" + profession + '\'' +
                ", birthday=" + birthday +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}