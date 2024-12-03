import java.util.*;

class Length
{
    private int feet ;
    private int inch ;

    public Length()
    {
        feet = 0;
        inch = 0;
    }

    public Length(int in)
    {
        inch = in%12;
        feet = in/12;

    }

    public Length(int ft, int in)
    {
        feet = ft;

        feet += in/12;
        inch = in%12;
        
    }

    public Length add(Length other)
    {
        int f = this.feet + other.feet;
        int i = this.inch + other.inch;
        return new Length(f , i);
    }

    public Length sub(Length other)
    {
        int i1 = this.feet * 12 + this.inch;
        int i2 = other.feet * 12 + other.inch;
        // int f = this.feet - other.feet;
        // int i = this.inch - other.inch;
        // System.out.println("i1 = " + i1);
        // System.out.println("i2 = " + i2);
        return new Length(i1 - i2);
    }

    public void disp()
    {
        if(feet != 0)
            System.out.print(feet + "'");
        if(inch != 0)
            System.out.print(inch + "\"");
        System.out.println();        
    }
}

public class LengthClass {
    public static void main(String[] args) {
        Length a = new Length();
        Length b = new Length(32);
        Length c = new Length(7, 2);
        Length d = new Length(5, 16);

        a.disp();
        b.disp();
        c.disp();
        d.disp();

        Length y = c.sub(d); 
        y.disp();

        y = d.sub(b);
        y.disp();

        Length x = b.add(d);
        x.disp();
    }
}
