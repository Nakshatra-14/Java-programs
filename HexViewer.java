import java.io.*;

public class HexViewer {

    public static void main(String[] args) throws IOException {

        File file = new File("data.dat");
        var fis = new FileInputStream(file);

        int n = 1;
        int b;

        for (b = fis.read(); b != -1; b = fis.read()) {
            
            System.out.printf("%02X ", b);

            if (n % 16 == 0)
                System.out.println();
            n++;
        }
        fis.close();
    }
}
