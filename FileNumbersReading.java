import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FileNumbersReading {
    public static void main(String[] args) throws IOException{
        File file = new File("number.txt");

        Scanner inp = new Scanner(file);

        int n = inp.nextInt();

        float arr[] = new float[n];

        for(int i = 0 ; i < n ; i++)
            arr[i] = inp.nextFloat();

        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}


