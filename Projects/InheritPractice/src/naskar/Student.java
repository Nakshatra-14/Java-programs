package naskar;

import java.util.GregorianCalendar;

public class Student extends Human{

    private int marks;

    public Student()
    {
        marks = 90;
    }

    public Student(String nm, GregorianCalendar dob, int marks)
    {
        super(nm, dob);
        this.marks = marks;
    }
    

    public float getMarks()
    {
        return marks;
    }

    @Override
    public String toString()
    {
        return super.toString() + ", " + marks;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Student e && super.equals(obj) && marks == e.marks;
    }


    public static void main(String[] args) {
        System.out.println("Testing Student: ");
        Student e = new Student();
        System.out.println(e);
    }
}
