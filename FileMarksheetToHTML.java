import java.io.*;
import java.util.Scanner;

public class FileMarksheetToHTML {

    public static char calcGrade(float mark)
    {
    // 85-100   S
    // 75*84    A
    // 65-74    B
    // 55-64    C
    // 50-54    D
    // 0-49     F

    char g;

        if (mark >= 85)
            g = 'S';
        else if (mark >= 75)
            g = 'A';
        else if (mark >= 65)
            g = 'B';
        else if (mark >= 55)
            g = 'C';
        else if (mark >= 50)
            g = 'D';
        else
            g = 'F';

        return g;

    }

    public static void main(String[] args) throws IOException{
        
        File sfile = new File("studentInfo.txt");
        File header = new File("htmlHeader.txt");
        File tfile = new File("marksheet.html");

        try
        (
            Scanner inp = new Scanner(sfile);
            Scanner hd = new Scanner(header);
            PrintWriter pw = new PrintWriter(tfile);
        )
        {
            while (hd.hasNextLine()) {
                pw.println(hd.nextLine());
            }
            pw.println("            <tr style=\"background-color: #77ff7ca8;\">");
            pw.println("                <th>Name</td>");
            pw.println("                <th>Roll</td>");
            pw.println("                <th>Subject 1</td>");
            pw.println("                <th>Subject 2</td>");
            pw.println("                <th>Subject 3</td>");
            pw.println("                <th>Total</td>");
            pw.println("                <th>Average</td>");
            pw.println("                <th>Grade</td>");
            pw.println("            </tr>");

            while (inp.hasNextLine()) {     
                pw.println("            <tr>");
                String arr[] = inp.nextLine().split(" ");
                pw.println("              <td>" + arr[0] + " " + arr[1] + "</td>");
                arr = inp.nextLine().split(" ");
                pw.println("              <td>" + arr[0] + "</td>");
                pw.println("              <td>" + arr[1] + "</td>");
                pw.println("              <td>" + arr[2] + "</td>");
                pw.println("              <td>" + arr[3] + "</td>");
                int t = Integer.parseInt(arr[1]) + Integer.parseInt(arr[2]) + Integer.parseInt(arr[3]);
                pw.println("              <td>" + t + "</td>");
                float avg = t/3.0f;
                pw.println("              <td>" + String.format("%.2f", avg) + "</td>");
                pw.println("              <td>" + calcGrade(avg) + "</td>");
                pw.println("            </tr>");

            }

            pw.println("        </table></center>");
            pw.println("    </body>");
            pw.println("</html>");
            System.out.println("Succesfully completed");
        }
    }
}
