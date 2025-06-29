import java.io.*;
import java.util.Scanner;
import java.awt.Desktop;

public class FileCSVtoHTML {
    
    public static void main(String[] args) throws IOException{
        
        File sfile = new File("E:\\code\\Java\\customers-100.csv");
        // File htmlHeader = new File("htmlHeader.txt");
        File tfile = new File("CSVtoHtml.html");

        Scanner finp = new Scanner(sfile);

        try
        (
            Scanner inp = new Scanner(System.in);
            // Scanner hd = new Scanner(htmlHeader);
            PrintWriter pw = new PrintWriter(tfile);

        )
        {
            // int n = 0;              //serial No.
            String f = "y";
            System.out.print("Does contain header (y/n): ");
            f = inp.nextLine();             

            if(f.charAt(0) == 'n')      //for testing no header
                 finp.nextLine();

            String title[] = null;
            String data[] = null;

            // while (hd.hasNextLine()) {                          //Html Header printer
            //     pw.println(hd.nextLine());
            // }

            // pw.println(
            //     "First line \\
            //     Second Line"
            // );

            pw.println(
                """
                    <!DOCTYPE html>
                    <html>
                    </head>
                        <title>Customer Information</title>
                    </head>
                    <body style="background-color: aliceblue";>
                    <center><h1 style="font-size: 40px;">Customer Information</h1></center>
                """
            );

            pw.println("                    <center><table border=\"5\" width=\"100%\" style=\"border-collapse: collapse; font-family: Arial, sans-serif; font-size: 16px; text-align: center; background-color: #f9f9f9;\">");
            pw.println("            <tr style=\"background-color: #77ff7ca8;\">"); 

            title = finp.nextLine().split(",");     //title extraction

            if(f.charAt(0) == 'n')                      //Table header maker type 1
            {
                for(int i = 0 ; i  < title.length ; i++)
                    title[i] = "Field " + (i+1);

                finp.close();
                finp = new Scanner(sfile);
            }
            

            
            for(int i = 0 ; i < title.length ; i++)
                pw.println("                <th>" + title[i] +"</td>");
            pw.println("            </tr>");
            

            pw.println("            <tr>");

            while (finp.hasNextLine()) {                    //For data input
                data = finp.nextLine().split(",");
                for(int i = 0 ; i < data.length ; i++)
                    pw.println("              <td>" + data[i] + "</td>");
                pw.println("            </tr>");
            }

            pw.println("        </table></center>");
            pw.println("    </body>");
            pw.println("</html>");

            finp.close();

            System.out.println("Succesfully completed");
            Desktop.getDesktop().open(tfile);
        }
    }
}
