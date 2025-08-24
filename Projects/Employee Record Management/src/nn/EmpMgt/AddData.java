package nn.EmpMgt;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public class AddData {
    public static void main(String[] args) throws IOException, ParseException {
        
        File file = new File("emp.dat");
        try
        (
            
            var fos = new FileOutputStream(file);
            var dos = new DataOutputStream(fos);
            
            var fis = new FileInputStream(file);
            var dis = new DataInputStream(fis);
        )
        {
            Emp a = new Emp(101, "test 1", new Date(), 10000);
            Emp b = new Emp(102, "test 2", new Date(), 10000);
            Emp c = new Emp(103, "test 3", new Date(), 10000);
            Emp d = new Emp(104, "test 4", new Date(), 10000);
            Emp e = new Emp(105, "test 5", new Date(), 10000);
            a.save(dos);
            b.save(dos);
            c.save(dos);
            d.save(dos);
            e.save(dos);

            Emp l = Emp.load(dis);
            Emp m = Emp.load(dis);
    
            // System.out.println(c.toString());
            System.out.println(l.toString());
            System.out.println(m);
            
            System.out.println("saved");
        }


    }
}
