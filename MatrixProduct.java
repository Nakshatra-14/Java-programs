import java.util.*;

public class MatrixProduct {

    public static void input(int mat[][]) {
        Scanner inp = new Scanner(System.in);
        for (int i = 0; i < mat.length; i++) {
            System.out.println("For Row: " + i + 1);
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print("\t#Elements " + j + 1 + ": ");
                mat[i][j] = inp.nextInt();
            }
        }

    }

    public static void printMatrix(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++)
                System.out.printf("%4d", mat[i][j]);
            System.out.println();
        }
    }

    public static int[][] matMult(int a[][], int b[][]) {
        int sum;
        int c[][] = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b[0].length; j++) {
                sum = 0;
                for (int k = 0; k < a[0].length; k++) {
                    sum += a[i][k] * b[k][j];
                }
                c[i][j] = sum;
            }

        return c;
    }

    public static void main(String[] args) {
        // Scanner inp = new Scanner(System.in);
        // System.out.print("1 for Use input\n2 for test\nEnter: ");
        // int n = inp.nextInt();
        // if(n == 1){
        // int a[][], b[][];

        // System.out.println("Enter Matrix A row: ");
        // int row1 = inp.nextInt();
        // System.out.println("Enter Matrix B colums: ");
        // int cols1 = inp.nextInt();
        // System.out.println("Enter Matrix A row: ");
        // int row2 = inp.nextInt();
        // System.out.println("Enter Matrix B column: ");
        // int cols2 = inp.nextInt();

        // a = new int[row1][cols1];
        // b = new int[row2][cols2];

        // System.out.println("Input first Matrix:");
        // input(a);

        // System.out.println("Input second Matrix:");
        // input(b);

        int a[][] = {
                { 2, 5, 8, 4},
                { 7, 9, 1, 6},
                { 3, 6, 4, 1}
        };
        int b[][] = {
                { 1, 2, 3, 8, 5},
                { 4, 5, 6, 9, 2},
                { 7, 8, 9, 7, 6},
                { 10, 11, 12, 3, 14}
        };


        // System.out.printf("Helloo\t\t\t\t\t, Hii,Helloo\t\t\t\t\t");

        int mat[][] = matMult(a, b);

        printMatrix(mat);

        // }

        // else if(n == 2){
        // int a[][] = {
        // {2, 5, 8},
        // {7, 9, 1},
        // {3, 6, 4}
        // };
        // int b[][] = {
        // {1, 2, 3},
        // {4, 5, 6},
        // {7, 8, 9}
        // } ;
        // int mat[][] = new int[2][2];
        // mat = MatMult(a, b);

        // printMatrix(mat);
        // }
        // else
        // System.out.println("Invalid Input");
    }
}
