package arrays;
import java.util.Arrays;

public class RightRotateArray {

    public static void reverseNthPlace(int[] arr, int left, int right)
    {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++; right--;
        }
    }

    public static void rotateRight(int[] nums, int k) {
        k %= nums.length;
        int n = nums.length;
        reverseNthPlace(nums, 0, n - 1);
        reverseNthPlace(nums, 0, k - 1);
        reverseNthPlace(nums, k, n - 1);
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};

        System.out.println(Arrays.toString(arr));

        rotateRight(arr, 3);

        System.out.println(Arrays.toString(arr));

    }
}
