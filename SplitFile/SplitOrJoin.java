//Wap to sprit a file in given number of fragment. All the input for this program will be taken from command line
//java SplitFile Micky.jppg 5
//Size of Micky.jpg  (223 byte)
//Micky.jpg.001 45 bytes
//Micky.jpg.002 45 bytes
//Micky.jpg.003 45 bytes
//Micky.jpg.004 45 bytes
//Micky.jpg.005 43 bytes

// java SplitOrJoin Random.dat sn 5
// java SplitOrJoin Random.dat ss 45
// java SplitOrJoin Random.dat j                    joins the files Random.dat.001, Random.dat.002, ... to Random.dat
// java SplitOrJoin Random.dat                      Same as j option

package SplitFile;
import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class SplitOrJoin {

    private static void copyStreamWithBuffer(InputStream is, OutputStream os) throws IOException
    {
        byte buff[] = new byte[1024];   //1 KB
        for(int n = is.read(buff) ; n != -1 ; n = is.read(buff))
        {
            os.write(buff, 0, n);
        }
    }

    //Copies sz no. of bytes from is to os using a buffer
    private static void copyStreamWithBuffer(InputStream is, OutputStream os, int sz) throws IOException    
    {
        byte buff[] = new byte[1024];   // 1 KB
    }

    public static void splitFileByNumber(File sfile, int n) throws IOException
    {
        File spltFolder = new File(sfile.getParentFile(), "splited");
        if(!spltFolder.exists())
            spltFolder.mkdir();
        // String f[] = null;
        // int v  = 0;
        int size = (int)sfile.length();
        int chunkSize = Math.ceilDiv(size, n);
        // int lastSize = size - chunkSize * (n - 1);
        var fis = new FileInputStream(sfile);
        // byte buff[] = null;
        for(int i = 1 ; i <= n ; i++)
        {
            if(i == n)
                chunkSize = size;
            String filename = sfile.getName() + "." + String.format("%03d", i);
            // System.out.printf("%s %d bytes%n", filename, chunkSize);
            File cf = new File(spltFolder, filename);
            var fos = new FileOutputStream(cf);
            
            System.out.printf("%s of %d byte is Created%n", cf.getName(), chunkSize);
            size -= chunkSize;
            fos.close();
        }
    }

    // private void fileMaker(File)

    public static void splitFileBySize(File file, int size)
    {
        
    }

    public static void joinsFiles(File tgtFile, File ... srcFiles) throws IOException
    {
        var fos = new FileOutputStream(tgtFile);

        for (File file : srcFiles) {
            var fis = new FileInputStream(file);
            for(int b = fis.read() ; b != -1 ; b = fis.read())
            {
                fos.write(b);
            }
            fis.close();
        }
        fos.flush();
        fos.close();
    }

    
    
    public static void main(String[] args) throws IOException{
        
        // File file = new File("E:\\code\\Java\\Random.dat");
        // File file = new File("SplitFile\\sign.pdf");

        // splitFileByNumber(file, 5);

        File file = new File("SplitFile\\splited\\sign.pdf");

        int n = 5;
        File files[] = new File[n];

        for(int i = 1 ; i <= n ; i++)
        {
            files[i - 1] = new File(file.getParentFile(), String.format("%s.%03d", file.getName(), i));
            System.out.println(files[i - 1].getAbsolutePath());
            if(!files[i - 1].exists())
                System.out.println("Not Found");
        }
        // System.out.println(Arrays.toString(files));
        joinsFiles(file, files);
        
    }
}
