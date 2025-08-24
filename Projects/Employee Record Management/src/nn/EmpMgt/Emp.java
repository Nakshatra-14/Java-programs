package nn.EmpMgt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Emp {
    private int id;
    private String name;
    private Date dob;
    private float salary;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    static
    {
        sdf.setLenient(false);
    }

    public Emp(int id, String name, Date dob, float salary)
    {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.salary = salary;
    }

    public Emp(int id, String name, String dob, float salary) throws ParseException
    {
        this(id, name, sdf.parse(dob), salary);
    }

    public void save(DataOutputStream os) throws IOException
    {
        os.writeInt(id);
        os.writeUTF(name);
        os.writeUTF(sdf.format(dob));
        os.writeFloat(salary);
    }

    public static Emp load(DataInputStream in) throws IOException
    {
        Emp e = null;
    
        try {
            e = new Emp(in.readInt(), in.readUTF(), in.readUTF(), in.readFloat());
        } catch (ParseException ex) 
        {
            
        }
        return e;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Emp [id=" + id + ", name=" + name + ", dob=" + sdf.format(dob) + ", salary=" + salary + "]";
    }
}
