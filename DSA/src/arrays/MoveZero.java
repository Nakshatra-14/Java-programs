package arrays;
import java.util.Arrays;

public class MoveZero {
    public static void moveZeroes(int nums[])
    {
        int i = 0, j = 0;

        while(i < nums.length)
        {
            if(nums[i] != 0)
            {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                j++;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 0, 5, 0, 98, 25, 36, 0, 6, 74};

        System.out.println(Arrays.toString(arr));
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));

    }
}
