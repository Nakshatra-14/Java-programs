public class Array2D {

    // Function to print a 2D array
    public static void printArray(int arr[][]){
        for(int[] row : arr)
        {
            for(int e : row)
                System.out.print(e + " ");  // Print each element of the row
            System.out.println();  // Move to the next line after each row
        }
    }

    public static void main(String[] args) {
        // 2D array
        int arr[][] = { {1, 2, 3}, 
                        {4, 5, 6}, 
                        {7, 8, 9}
                      };  

        System.out.println("Length of the rows: " + arr.length);  // Print the number of rows
        System.out.println("Length of the column: " + arr[0].length);  // Print the number of columns

        System.out.println("\nUsing Function:");
        printArray(arr);  // Print the 2D array using the printArray function

        System.out.println("\nUsing for loop: ");
        // Print the 2D array using a for loop
        for(int i = 0 ; i < arr.length ; i++)
        {
            for(int j = 0 ; j < arr[i].length ; j++)
            {
                System.out.print(arr[i][j] + " ");  // Print each element of the row
            }
            System.out.println();  // Move to the next line after each row
        }

        System.out.println("\nUsing for each loop:");
        // Print the 2D array using a for each loop
        for (int row[] : arr) {
            for (int e : row) {
                System.out.print(e + " ");  // Print each element of the row
            }
            System.out.println();  // Move to the next line after each row
        }
    }
}