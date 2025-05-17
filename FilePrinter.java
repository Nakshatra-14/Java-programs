import java.io.*;

public class FilePrinter {

    public static void main(String[] args) throws IOException{
        
        // File file = new File("data.dat");
        // var file = new File("data.dat");
        var file = new File("Input.in");

        // FileInputStream fis = new FileInputStream(file);
        var fis = new FileInputStream(file);

        for(int b = fis.read() ; b != -1 ; b = fis.read())
        {
            System.out.print((char) b);
        }
        
        System.out.println();

        fis.close();
    }
}