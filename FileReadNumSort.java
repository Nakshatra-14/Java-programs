import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class FileReadNumSort {
    
    public static void main(String[] args) throws IOException{
        Scanner inp = new Scanner(System.in);
        // System.out.print("Enter Filname: ");
        // String fname = inp.nextLine();
        File file = new File("numbers.dat");

        var fis = new FileInputStream(file);

        var dis = new DataInputStream(fis);

        ArrayList<Float> al = new ArrayList<>();
        try {
            for(float b = dis.readFloat() ;  ; b = dis.readFloat())
            al.add(b);
        }
        catch(EOFException e)
        {

        }

        Comparator<Float> comp = new Comparator<Float>() {

            @Override
            public int compare(Float o1, Float o2) {
                return Float.compare(o1, o2);
            }
            
        };
        al.sort(comp);
        System.out.println(al);
        System.out.println("Succesfull");
        dis.close();  
        inp.close(); 
    }
}
