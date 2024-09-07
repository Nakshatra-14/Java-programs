//Input two string and print number of occurence of thr second string in the first string
import java.util.Scanner;

public class StringOccurance {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str1 = inp.nextLine();
        System.out.print("Enter another: ");
        String str2 = inp.nextLine();
        
        int p = 0, e = 0, w = 0;
        while(true)
        {
            p = str1.indexOf(str2, p);
            if(p < 0)                   //Not found
                break;
            e++;
            if((p == 0 || str1.charAt(p-1) == ' ' ) && ((p + str2.length()) == str1.length() || str1.charAt(p + str2.length()) == ' ' ))
            {
                w++;
            }

            p += str2.length(); 
        }
        System.out.println("No. of occurance: " + e);
        System.out.println("No. of occurance as whole word: " + w);

    }
}
