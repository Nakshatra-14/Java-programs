package nn.regex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws FileNotFoundException {
        try
        (
            Scanner sc = new Scanner(new File("T.txt"));
        )
        {
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        }
    }
}
