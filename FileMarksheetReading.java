import java.io.*;
import java.util.Scanner;;

public class FileMarksheetReading {
    
    public static void main(String[] args) throws IOException{
        File sfile = new File("studentInfo.txt");
        File tfile = new File("marksheet.txt");

        Scanner inp = new Scanner(sfile);

        PrintWriter pw = new PrintWriter(tfile);

        String name = inp.nextLine();
        int roll = inp.nextInt();
        int m1 = inp.nextInt();
        int m2 = inp.nextInt();
        int m3 = inp.nextInt();

        pw.printf("Name = %s, Roll = %d, Total = %d%n", name, roll, m1+m2+m3);
        System.out.println("File Saved");
        inp.close();
        pw.close();
    }
}
