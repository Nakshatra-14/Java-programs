package arrays;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] arr) {
        boolean complete = false;
        int i = 0;
        int l = arr.length;
        int index = 0;
        // String 
        String ChkPrefix = String.valueOf(arr[i].charAt(index));
        String prefix = "";
        while(complete == false)
        {
            if(arr[i].startsWith(prefix))
            {
                if(i == l - 1)
                {
                    i = 0;
                    index++; 
                    prefix = prefix + String.valueOf(arr[i].charAt(index));

                }
                i++;
            }
            else
                if(prefix.isEmpty())
                    return prefix;
      
            // if()
        }
    }

    public static void main(String[] args) {
        String arr[] = {"flower", "flow", "flight", "flew", "floor", "flame", "floss", "flung", "flint", "flair"};
        
    }
}
