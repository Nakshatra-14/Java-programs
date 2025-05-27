import java.io.*;
import java.util.Random;

public class FileByteMaker {
    public static void main(String[] args) throws IOException{
        
        int n = 223;

        File file = new File("Random.dat");
        try
        (
            var fos = new FileOutputStream(file);
        )
        {
            Random rnd = new Random();
            
            for(int i = 0 ; i < n ; i++)
            {
                fos.write(rnd.nextInt() % 256);
            }
        }
    }
}
