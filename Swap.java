import java.util.*;
public class Swap {
    public static void main(String args[])
    {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int  f = 0, l = arr.length - 1;
        System.out.println(Arrays.toString(arr));

        while(f < l)
        {
            int t =  arr[f];
            arr[f] = arr[l];
            arr[l] = t;
            f++;
            l--;
        }

        System.out.println(Arrays.toString(arr));
    }
}
