package nn;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int arr[] = new int[100];
        {
            arr[4] = 5;
            arr[99] = 10;
        }
        System.out.println(Arrays.toString(arr));
    }
}
