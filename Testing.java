
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Testing {

     public static int removeDuplicate(int nums[])
     {
        int i = 0;
        for(int j = 0 ; j < nums.length ; j++)
            if(nums[i] != nums[j])
                nums[++i] = nums[j];
        return i+1;
     }   

     public static void reverseArr(int arr[])
     {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++; right--;
        }
    }

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
        reverseArr(nums);
        reverseNthPlace(nums, 0, k-1);
        reverseNthPlace(nums, k, nums.length - 1);
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        // int arr[] = {0, 0, 1, 1, 1, 2, 2, 2, 2};
        // int arr[] = {0,0,1,1,1,2,2,3,3,4};
        // int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int arr[] = { 1 };
        // int k = removeDuplicate(arr);
        // System.out.println(k);
        // reverseArr(arr);
        System.out.println(Arrays.toString(arr));

        rotateRight(arr, 3);

        System.out.println(Arrays.toString(arr));
    }
}