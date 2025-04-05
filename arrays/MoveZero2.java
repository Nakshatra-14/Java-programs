import java.util.Arrays;

public class MoveZero2 {

    public static void moveZero(int ar[])
    {
        int p = 0;
        for(int i = 0 ; i < ar.length ; i++)
            if(ar[i] != 0)
            {
                if(i != p)
                {
                    ar[p] = ar[i];
                    ar[i] = 0;
                }
                p++;
            }
    }

    public static void main(String[] args) {
        // int arr[] = {25, 36, 0, 28, 81, 56, 0, 0, 16, 0, 0, 29};
        int arr[] = {2, 1};

        System.out.println(Arrays.toString(arr));
        moveZero(arr);
        System.out.println(Arrays.toString(arr));
    }
}