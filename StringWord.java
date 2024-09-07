import java.util.*;
public class StringWord {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter String: ");
        String str = inp.nextLine();
        // int w = 0;
        int i;
        // int w; 
        //String word;
        
        for(i = 0 ; i < str.length() ; i++)
        {
            if(str.charAt(i) == ' ')
                continue;
            //Here i point to the first charecter of the word
            
            int f = i;
            while (i < str.length() && str.charAt(i) != ' ') 
            {
                //w++ //count no. of word
                // word += str.charAt(i);  //takes string word
                //i point to each charecter of the words
                i++;    
            }
            //Here i point to the charecter immiediatly after the word
            System.out.println(str.substring(f, i));

        }
        // System.out.println("Words: " + w);
    }
}
