
public class Testing {

     public static int removeDuplicate(int nums[])
     {
        int i = 0;
        for(int j = 0 ; j < nums.length ; j++)
            if(nums[i] != nums[j])
                nums[++i] = nums[j];
        return i+1;
     }   

     public static void main(String[] args) {
        // int arr[] = {0, 0, 1, 1, 1, 2, 2, 2, 2};
        int arr[] = {0,0,1,1,1,2,2,3,3,4};
        int k = removeDuplicate(arr);
        System.out.println(k);
        for (int i = 0; i < k ; i++) 
            System.out.print(arr[i]);
        // System.out.println(arr.length);
        // System.out.println(arr.length-1);
     }
}