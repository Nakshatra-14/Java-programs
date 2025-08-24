package nn.EmpMgt;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchEmp {
    public static void main(String[] args) throws IOException {
        File file = new File("emp.dat");
        ArrayList<Integer> al = new ArrayList<>();
            int id;
            String name;
            String dt;
            float salary;
        
                var fis = new FileInputStream(file);
                var dis = new DataInputStream(fis);
           
           try
           {
               while (true) {
                   id = dis.readInt();
                   dis.readUTF();
                   dis.readUTF();
                   dis.readFloat();

                   // System.out.println("Emp [id=" + id + "]");
                   al.add(id);
               }
           }
            catch (IOException e) { System.out.println("reached EOF");}

            var inp = new Scanner(System.in);
            System.out.print("Enter id: ");
            int n = inp.nextInt();
            // System.out.println(al.toString());
            // System.out.println(al.contains(102));
            fis = new FileInputStream(file);
            dis = new DataInputStream(fis);
            
            if(al.contains(n))
            {
                int pos = al.indexOf(n);
                for(int i = 0 ; i < pos ; i++)
                {
                    // System.out.println(i);
                    dis.readInt();
                    dis.readUTF();
                    dis.readUTF();
                    dis.readFloat();
                    if(i+1 == pos)
                    {
                        id = dis.readInt();
                        name = dis.readUTF();
                        dt = dis.readUTF();
                        salary = dis.readFloat();

                        System.out.println("Emp [id=" + id + ", name=" + name + ", dob=" + dt + ", salary=" + salary + "]");
                    }
                    
                }
            }
            else
                System.out.println("not found");

            fis.close();
            dis.close();
            inp.close();
    }
}
