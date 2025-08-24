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

    public Emp(int id, String name, Date dob, float salary)
    {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.salary = salary;
    }

    public Emp(int id, String name, String dob, float salary) throws ParseException
    {
        String pattern = "dd/MM/yyyy";
        var sdf = new SimpleDateFormat(pattern);

        this.id = id;
        this.name = name;
        this.dob = sdf.parse(dob);
        this.salary = salary;
    }

    public void save(DataOutputStream os) throws IOException
    {
        String pattern = "dd/MM/yyyy";
        var sdf = new SimpleDateFormat(pattern);

        os.writeInt(id);
        os.writeUTF(name);
        os.writeUTF(sdf.format(dob));
        os.writeFloat(salary);
    }

    
    public Emp load(DataInputStream in) throws IOException, ParseException
    {
        return new Emp(in.readInt(), in.readUTF(), in.readUTF(), in.readFloat());
    }

    @Override
    public String toString() {
        return "Emp [id=" + id + ", name=" + name + ", dob=" + dob + ", salary=" + salary + "]";
    }
}
