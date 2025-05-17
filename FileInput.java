import java.io.*;
import java.util.Scanner;

public class FileInput {

    public static void main(String[] args) throws IOException{

        Scanner inp = new Scanner(System.in);
        boolean overwite = true;
        System.out.print("Enter Filname: ");
        String fname = inp.nextLine();
        File file = new File(fname);

        if(file.exists())
        {
            System.out.println("File existed\nWant to overwrite ?\n 1 for yes and 0 for no");
            int n = inp.nextInt();
            if(n == 0)
                overwite = false;  
        
        }

        if(overwite)
        {
            System.out.print("Enter how many no.: ");
            int n = inp.nextInt();

            var fos = new FileOutputStream(file);
            var dos = new DataOutputStream(fos);

            // ArrayList<Float> al = new ArrayList<>();
            System.out.print("Enter the value to input: ");
            for(int i = 0 ; i < n ; i++)
            {
                float num = inp.nextFloat();
                dos.writeFloat(num);
            }
            
            System.out.println("Succesfully save to " + file.getAbsolutePath());
            dos.close();
            inp.close();
        }


    }
}