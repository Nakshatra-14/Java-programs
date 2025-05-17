import java.io.*;

public class FileCopier {
    private static void copyStream(InputStream is, OutputStream os) throws IOException
    {
        for(int b = is.read() ; b != -1 ; b = is.read())
            os.write(b);
    }

    public static void main(String[] args) throws IOException{
        File srcFile = new File("data.dat");
        File tgtFile = new File("dataCopy.dat");

        var fis = new FileInputStream(srcFile);
        var fos = new FileOutputStream(tgtFile);

        copyStream(fis, fos);

        fos.close();

        System.out.println("File copied succesfully");
    }
}
