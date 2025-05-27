import java.io.*;

public class FileMatrixReader {

    public static void main(String[] args) throws IOException {
        
        var dos = new DataInputStream(new FileInputStream(new File("Matrix.dat")));

        int row = dos.readInt();
        int col = dos.readInt();

        for( int i = 0 ; i < row ; i++)
        {
            for(int j = 0 ; j < col ; j++)
            {
                System.out.print(dos.readInt() + " ");
            }
            System.out.println();
        }
        dos.close();
        // System.out.println("Succesfully read a " + row + "X" + col + " Matrix");
    }
}