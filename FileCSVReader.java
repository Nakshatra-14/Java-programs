import java.io.*;
import java.util.Scanner;

public class FileCSVReader {

    public static void main(String[] args) throws IOException {
        
        File file = new File("weekday.csv");

        Scanner inp = new Scanner(file);

        // String title[] = inp.nextLine().split(" ");

        inp.nextLine();     //Skip first line

        while(inp.hasNextLine())
        {
            String arr[] = inp.nextLine().split(",");

            System.out.println("Name: " + arr[0]);
            System.out.println("Abbreviation: " + arr[1]);
            System.out.println();
        }
        inp.close();
    }
}
