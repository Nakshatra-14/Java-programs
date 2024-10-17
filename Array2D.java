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

        System.out.println("Length of the rows: " + arr.length);
        System.out.println("Length of the column: " + arr[0].length);

        System.out.println("Using Function:");
        printArray(arr);    

        System.out.println("\nUsing for loop: ");
        for(int i = 0 ; i < arr.length ; i++)
        {
            for(int j = 0 ; j < arr[i].length ; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\nUsing for each loop:");
        //using for each loop
        for (int row[] : arr) {
            for (int e : row) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
