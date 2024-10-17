import java.util.*;
public class RowColsSum {
    public static void main(String[] args) {
        int mat[][] = {
                { 12, 52, 47, 15 },
                { 41, 59, 67, 32 },
                { 34, 85, 96, 21 }
        };

        int row = mat.length;
        int cols = mat[0].length;

        System.out.println("Row: " + row + "\nCols: " + cols);

        int rowSum = 0, i;
        int colsSum[];
        colsSum = new int[20];
        
        for(i = 0 ; i < row ; i++)
        {
            for(int j = 0 ; j < cols ; j++)
            {
                System.out.printf("%4d", mat[i][j]);
                rowSum += mat[i][j];
                colsSum[j] += mat[i][j];
            }
            System.out.printf("%8d\n", rowSum);
        }

        System.out.println();

        int tot = 0;
        for(int j = 0 ; j < cols ; j++)
        {
            System.out.printf("%4d", colsSum[j]);
            tot += colsSum[j];
        }
        System.out.printf("%8d", tot + rowSum);
    }
}
