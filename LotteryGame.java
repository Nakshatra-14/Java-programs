import java.util.*;

public class LotteryGame {

    public static int randInt(int lb, int ub) {
        return lb + (int) ((ub - lb + 1) * Math.random());
    }

    public static int[][] genTable() {
        int table[][] = new int[5][10];
        boolean hash[] = new boolean[100];

        for(int i = 0 ; i < table.length ; i++)
        {
            for(int j = 0 ; j < table[i].length ; j++)
                while (true) 
                {
                    int r = randInt(10, 99);
                    if(hash[r] == false)
                    {
                        table[i][j] = r;
                        hash[r] = true;
                        break;
                    }
                }
        }

        return table;
    }

    public static void print2DArray(int arr[][]){
        for(int[] row : arr)
        {
            for(int e : row)
                System.out.printf("%4d", e); 
            System.out.println();
        }
    }


    public static void main(String[] args) {
        int arr[][] = genTable();
        int inputs[] = {20, 49, 67, 38, 16};
        // Scanner inp = new Scanner(System.in);
        Arrays.sort(inputs);
        int max = 0;
        int matchRow = 0;
        for(int i = 0 ; i < arr.length ; i++)
        {
            int matches = 0;
            for(int j = 0 ; j < arr[i].length ; j++)
            {
                if(Arrays.binarySearch(inputs, arr[i][j]) >= 0)
                    matches++;
            }
            // System.out.println("Matches = " + matches);
            if(max < matches)
            {
                max = matches;
                matchRow = i;
            }
        }

        print2DArray(arr);
        System.out.println(Arrays.toString(inputs));
        System.out.println("Your score: " + max * 10);
        System.out.println("On row: " + matchRow);

    }
}
