import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Solution {

    public static int removeDuplicates(int[] nums) {
        // int k = 0;
        // Arrays.sort(nums);
        // for (int i = 0; i < nums.length; i++) {
        //     // for(int j = i+1 ; j < nums.length ; j++)
        //     // {

        //     // }
        //     if (nums[i] > Integer.MIN_VALUE && nums[i] < Integer.MAX_VALUE) {
        //         int n = nums[i];

        //         if (nums.equals(n)) {
        //             k++;
        //         }
                
        //     }
        // }
        // return k;

        if (nums.length == 0) return 0;
        int k = 1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        // int ar[] = {23, 54, 12, 76, 45, 63};
        // int arr[] = {10, 5, 10};
        // int arrr[] = {12, 35, 1, 10, 34, 1};
        int arr[] = { 0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4 };
        System.out.println(removeDuplicates(arr));
    }
}
