import java.util.Scanner;

public class InWords {

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
            // if(num >= 10000000) //1 crore
            // {
            //     int m = num/10000000;
            //     word += oneTo99(m) + "crore ";
            //     num %= 10000000;
            // }
            
            // if(num >= 100000) //1 lakh
            // {
            //     int m = num/100000;
            //     System.out.println(m);
            //     word += oneTo99(m) + "lakh ";
            //     num %= 100000;
            // }

            // if(num >= 1000) //1 thousand
            // {
            //     int m = num/1000;
            //     word += oneTo99(m) + "thousand ";
            //     num %= 1000;
            // }

            // if(num >= 100) //1 hundread
            // {
            //     int m = num/100;
            //     word += oneTo99(m) + "hundread ";
            //     num %= 100;
            // }

            // if(num >= 1) //1 to 99
            // {
            //     int m = num/1;
            //     word += oneTo99(m) + "";
            //     num %= 1;
            // }
        } 
        
        return word;
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter the no. : ");
        int n = inp.nextInt();
        System.out.println(numberInWords(n));
    }
}
