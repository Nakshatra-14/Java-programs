import java.util.*;

public class RandomNumberToWord {

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

    public static String oneTo99(int n)
    {
        String teens[] = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirtheen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String ties[] = {"twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        String w = "";  
        
        if(n > 19)
        {
            w += ties[n/10 - 2] + " ";
            n %= 10;
        }

        if(n != 0)
            w += teens[n - 1] + " ";

        return w;  
    }

    public static String numberInWords(int num)
    {
        String word = "";

        if(num >= 1000000000) //100 crore
            word = "too large number";
        else if(num == 0)
            word = "zero";
        else
        {
            String hunds[] = {"crore ", "lakh ", "thousand ", "hundread ", ""};
            int i = 0;
            int h = 10000000; // 1 crore
            while(num != 0)
            {
                if(num >= h) 
                {
                    int m = num/h;
                    word += oneTo99(m) + hunds[i];
                    num %= h;
                }
                i++;
                if(h == 1000)
                    h /= 10;
                else
                    h /=100;
            }
        }

        return word;
    }


    public static void main(String[] args) {
        
        int n = 90, lb = 0, ub = 1000000000;
        int arr[] = genRandoms(n, lb, ub);
        //System.out.println(Arrays.toString(arr));

        for(int i = 0; i < n; i++)
        {
            // System.out.print(i+1 + ") " + arr[i] + ": ");
            // System.out.println(numberInWords(arr[i]));
            System.out.printf("%2d) %10d: %s\n", i + 1, arr[i], numberInWords(arr[i]));
        }

    }
}
