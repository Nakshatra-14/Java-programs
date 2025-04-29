package naskar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Human {
    private String name;
    private GregorianCalendar dob;
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    
    public Human()
    {
        name = "<no-name>";
        dob = new GregorianCalendar(1968,Calendar.JUNE,23);
    }
    
    public Human(String name, GregorianCalendar dob)
    {
        this.name = name;
        this.dob = dob;
    }
    
    public GregorianCalendar getDob()
    {
        return dob;
    }

    public int getAge()
    {
        GregorianCalendar t = new GregorianCalendar();
        int today = t.get(Calendar.YEAR);
        int n = dob.get(Calendar.YEAR);
        return today - n;
    }
    
    @Override
    public String toString()
    {   
        
        return name + ", " + sdf.format(dob.getTime());
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Human h && name.equals(h.name) && dob.equals(h.dob);
    }

    public static void main(String[] args) {
        System.out.println("Testing Human: ");
        Human h = new Human();
        System.out.println(h);;
    }
}
