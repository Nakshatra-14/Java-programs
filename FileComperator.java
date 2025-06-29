import java.io.*;

public class FileComperator {

    public static boolean compareFiles(File a, File b) throws IOException
    {
        if(a.length() != b.length())
            return false;
        
        int count = 0;
        try
        (
            var afns = new FileInputStream(a);
            var bfns = new FileInputStream(b);
        )
        {
            for(int v = afns.read() ; v != -1 ; v = afns.read())
            {
                int w = bfns.read();
                System.out.println("W: " + w + ", " + "V: " + v);
                if(v != w)
                {
                    System.out.println("Mismatched byte: " + count);
                    return false;
                }
                count++;
            }
            return true;
        }
    }
    
    public static void main(String[] args) throws IOException{
        
        File a = new File("SplitFile\\Signature.jpg");
        File b = new File("SplitFile\\splited\\Signature.jpg");

        System.out.println(compareFiles(a, b));
    }
}
