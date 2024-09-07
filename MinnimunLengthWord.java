//Input a string and print minimum length of its word
import java.util.*;
public class MinnimunLengthWord {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter String: ");
        String str = inp.nextLine();
        int i, min = str.length(), n;
        
        for(i = 0 ; i < str.length() ; i++)
        {
            if(str.charAt(i) == ' ')
                continue;
            
            int f = i;
            while (i < str.length() && str.charAt(i) != ' ') 
            {
                i++;    
            }

            n = i - f;
            if(min > n)
                min = n;
        }
        System.out.println("Min: " + min);
    }
}
