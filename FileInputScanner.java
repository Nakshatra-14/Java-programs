//Using Scanner class to input formatted text

import java.io.*;
import java.util.*;

public class FileInputScanner {
    public static void main(String[] args) throws IOException{
        File file  = new File("Poem.txt");

        Scanner sc = new Scanner(new FileInputStream(file));

        //Print all lines of the file
        while(sc.hasNextLine())
            System.out.println(sc.nextLine());

        sc.close();    
    }
}
