import java.util.*;

public class PrincipalDiagonal {

    public static void printArray(int arr[][]){
        for(int[] row : arr)
        {
            for(int e : row)
                System.out.printf("%4d", e); 
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5, arr[][];
        // Scanner inp = new Scanner(System.in);
        // System.out.println("Enter the element per side: ");
        // n = inp.nextInt();
        arr = new int[n][n];

        int num = 1;
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j++)
                {
                    arr[i][j] = num;
                    num++;
                }
        
        printArray(arr);    
        System.out.println();

        int f = 0, l = arr.length - 1;
        
        while (f < l) {
            //swap arr[f][f], arr[l][l]
            int t = arr[f][f];
            arr[f][f] = arr[l][l];
            arr[l][l] = t;

            //swap arr[f][l], arr[l][f]
            t = arr[f][l];
            arr[f][l] = arr[l][f];
            arr[l][f] = t;

            f++;
            l--;

        }
        printArray(arr);
    }
}
