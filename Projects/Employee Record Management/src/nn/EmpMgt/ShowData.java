package nn.EmpMgt;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowData {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("emp.dat");

        try (
                var fis = new FileInputStream(file);
                var dis = new DataInputStream(fis);) {

            while (true) {
                int id = dis.readInt();
                String name = dis.readUTF();
                String dt = dis.readUTF();
                float salary = dis.readFloat();

                System.out.println("Emp [id=" + id + ", name=" + name + ", dob=" + dt + ", salary=" + salary + "]");
            }
        } catch (IOException e) {
            System.out.println("reached EOF");
        }
    }
}
