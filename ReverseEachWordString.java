import java.util.*;

public class ReverseEachWordString {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter String: ");
        String str = inp.nextLine();

        for(int i = 0 ; i < str.length() ; i++)
        {
            if(str.charAt(i) == ' ')
                continue;
            
            int f = i;
            while (i < str.length() && str.charAt(i) != ' ') 
            {
                i++;    
            }

            //System.out.println(str.substring(f, i));    

            for(int j = i - 1 ; j >= f ; j--)
            {
                System.out.print(str.charAt(j));
            }
            System.out.print(" ");
        }       
    }
}
