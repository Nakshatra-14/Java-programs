import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HexViewer {

    public static void main(String[] args) throws IOException {

        Scanner inp = new Scanner(System.in);

        // File file = new File("Random.dat");
        File file = new File("E:\\code\\Java\\customers-100.csv");
        var fis = new FileInputStream(file);

        int byteCount = 0;
        int p = 0;

        System.out.print(" ".repeat(9));
        for (int i = 0; i <= 15; i++)
            System.out.printf("%02X ", i);
        System.out.println();

        byte buff[] = new byte[16];

        int n = 0;
        while (true) {

            int count = fis.read(buff);
            if (count == -1)
                break;
            System.out.printf("%08X ", byteCount);
            for (int i = 0; i < count; i++)
                System.out.printf("%02X ", buff[i]);
            while (count < 16) {
                System.out.print("   ");
                count++;
            }
            System.out.print("  ");
            for (int i = 0; i < count; i++)
                System.out.printf("%c", ((buff[i] < 32) ? '.' : buff[i]));
            System.out.println();
            byteCount += count;
            n++;
            if (n % 20 == 0)
            {
                System.out.print("Page " + ++p + ". Press enter for next page");
                inp.nextLine();
            }
        }

    }
}