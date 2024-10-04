public class Array2D {

    public static void printArray(int arr[][]){
        for(int[] row : arr)
        {
            for(int e : row)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int arr[][] = { {1, 2, 3}, 
                        {4, 5, 6}, 
                        {7, 8, 9}
                      };  
        printArray(arr);                  
    }
}
