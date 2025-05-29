//Generic CSV reader

import java.io.*;
import java.util.Scanner;

public class FileGenericCSVreader {

    public static void main(String[] args) throws IOException {
        File file = new File("customers-100.csv");

        try (
                Scanner finp = new Scanner(file);
            ) 
            {
                int n = 0;
                String f = "y";
                System.out.print("Does contain header (y/n): ");

                // f = inp.nextLine();             

                String title[] = null;
                if(f.charAt(0) == 'y')
                {
                    title = finp.nextLine().split(",");
                }

                if(f.charAt(0) == 'n')
                     finp.nextLine();

            
                
            while (finp.hasNextLine()) {
                int c = 1;
                String arr[] = finp.nextLine().split(",");
                for (int i = 0; i < arr.length; i++) {

                    if(f.charAt(0) == 'n')
                    {
                        System.out.print("Field "+ c + ": ");
                        System.out.println(arr[i]);
                        c++;
                    }
                    else
                    {
                        System.out.print(title[i] + ": ");
                        System.out.println(arr[i]);
                    }
                }
                System.out.println("\n");
                n++;

                if (n == 4)
                    break;
            }
        }

    }
}



