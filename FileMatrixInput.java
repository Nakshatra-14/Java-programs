import java.io.*;
import java.util.Scanner;
public class FileMatrixInput {
    
    public static void main(String[] args) throws IOException{
        
        Scanner inp = new Scanner(System.in);
        int row, col;
        System.out.print("Enter rows: ");
        row = inp.nextInt();
        System.out.print("Enter cols: ");
        col = inp.nextInt();

        File file = new File("Matrix.dat");
        var fos = new FileOutputStream(file);
        var dos = new DataOutputStream(fos);
        // int arr[][] = new int[row][col];

        //write row and col
        dos.writeInt(row);
        dos.writeInt(col);

        //write matrix
        for(int i = 0 ; i < row ; i++)
            for(int j = 0 ; j < col ; j++)
            {
                System.out.print("Enter row " + i + ", col " + j + " value: ");
                int n = inp.nextInt();
                // arr[i][j] = n;
                dos.writeInt(n);
            }

        // for (int i = 0; i < arr.length; i++) {
        //     for (int j = 0; j < arr[i].length; j++)
        //         System.out.printf("%4d", arr[i][j]);
        //     System.out.println();
        // }
        inp.close();
    }
}
