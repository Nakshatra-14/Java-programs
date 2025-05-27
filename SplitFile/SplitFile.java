//Wap to sprit a file in given number of fragment. All the input for this program will be taken from command line
//java SplitFile Micky.jppg 5
//Size of Micky.jpg  (223 byte)
//Micky.jpg.001 45 bytes
//Micky.jpg.002 45 bytes
//Micky.jpg.003 45 bytes
//Micky.jpg.004 45 bytes
//Micky.jpg.005 43 bytes

package SplitFile;
import java.io.*;

public class SplitFile {

    public static void splitFileByNumber(File file, int n)
    {
        // String f[] = null;
        int v  = 0;
        int size = (int)file.length();
        int chunkSize = Math.ceilDiv(size, n);
        // int lastSize = size - chunkSize * (n - 1);
        for(int i = 1 ; i <= n ; i++)
        {
            if(i == n)
                chunkSize = size;
            String filename = file.getName() + "." + String.format("%03d", i);
            System.out.printf("%s %d bytes%n", filename, chunkSize);
            size -= chunkSize;
        }
    }


    public static void splitFileBySize(File file, int size)
    {
        
    }

    
    
    public static void main(String[] args) throws IOException{
        
        File file = new File("Random.dat");

        splitFileByNumber(file, 5);
    }
}
