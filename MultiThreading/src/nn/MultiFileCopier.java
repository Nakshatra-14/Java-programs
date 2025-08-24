package nn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MultiFileCopier {

    public static  void copyFile(File files[]) throws IOException
    {
        for(int i = 0; i < files.length ; i++) {
            long len = files[i].length();
            File copy = getCopyFile(files[i]);
            try
            (
                var fis = new FileInputStream(files[i]); 
                // var fos = new FileOutputStream(files[i]);
                var fos = new FileOutputStream(copy);
            )
            {
                long n = 0;
                int prePerc = 0;
                for(int b = fis.read() ; b != -1 ; b = fis.read())
                {
                    fos.write(b);
                    n++;
                    int perc = (int) (n / (double) len * 100);
                    if(prePerc != perc)
                    {
                        System.out.printf("%s to %s: %d%%\n", files[i].getName(), copy.getName(), perc);
                        prePerc = perc;
                    }
                }
            }   
        }
    }

    public static File getCopyFile(File file)
    {
        String filename = file.getName();

        int p = filename.lastIndexOf('.');
        
        if(p < 0)
            p = filename.length();

        filename = filename.substring(0, p) + "Copy" + filename.substring(p);

        return new File(file.getParent(), filename);
    }
    public static void main(String[] args) throws IOException{
        
        File a = new File("resources","Readme.txt");
        File b = new File("resources","Important.dat");
        File c = new File("resources","Database.dat");

        File files[] = {a, b, c};

        copyFile(files);
    }
}
