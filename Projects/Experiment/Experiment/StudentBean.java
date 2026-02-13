import java.beans.JavaBean;

@JavaBean
public class StudentBean {

    private static final System.Logger LOG = System.getLogger(StudentBean.class.getName());
    private String name;
    private int age;

    public StudentBean(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

   
}
