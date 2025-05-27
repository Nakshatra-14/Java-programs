import java.io.*;

public class FileCopyWithoutLoop {


    public static void copyFile(String srcFilename, String tgtFilename) throws IOException
    {
        File sfile = new File(srcFilename);
        byte b[] = new byte[(int)(sfile.length())];
        var fis = new FileInputStream(sfile);
        fis.read(b);

        var fos = new FileOutputStream(tgtFilename);
        fos.write(b);

        fis.close();
        fos.close();
    }

    
    public static void main(String[] args) throws IOException{
        
        copyFile("Matrix.dat", "MatrixCopy.dat");
    }
}
