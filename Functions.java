import java.util.*;

public class Functions {

    public static int randInt(int lb, int ub) {
        return lb + (int) ((ub - lb + 1) * Math.random());
    }

    public static int[] genRandoms(int n, int lb, int ub) {
        int arr[], r, j;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            r = randInt(lb, ub);
            boolean f = false;
            for (j = 0; j < i; j++) {
                if (arr[j] == r) {
                    f = true;
                    break;
                }
            }

            if (f == true) {
                i--;
            } else
                arr[i] = r;
        }

        return arr;
    }

    public static void rightShift(int[] arr, int n) {
        for (int k = 1; k <= n; k++) {
            int e = arr[arr.length - 1];
            for (int i = arr.length - 1; i >= 1; i--) {
                arr[i] = arr[i - 1];
            }
            // System.arraycopy(arr, 0, arr, 1, n - 1);
            arr[0] = e;
        }
    }

    public static void leftShift(int[] arr, int n)
    {
        for(int k = 1 ; k <= n ; k++)
        {
            int e = arr[0];
            for(int i = 1 ; i < arr.length ; i++)
            {
                arr[i - 1] = arr[i];
            }
            arr[arr.length - 1] = e;
        }
    }

    public static void main(String[] args) {
        // Testing random genrator
        // int n = 20, lb = 50, ub = 80;
        // int arr[] = genRandoms(n, lb, ub);
        // System.out.println(Arrays.toString(arr));
        // Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));

        // Testing Right Shift
        // int n = 20, lb = 50, ub = 80;
        // int arr[] = genRandoms(n, lb, ub);
        // System.out.println(Arrays.toString(arr));
        // rightShift(arr, 1);
        // System.out.println(Arrays.toString(arr));

        // Testing Left Shift
        int n = 20, lb = 50, ub = 80;
        int arr[] = genRandoms(n, lb, ub);
        System.out.println(Arrays.toString(arr));
        leftShift(arr, 4);
        System.out.println(Arrays.toString(arr));
    }
}
