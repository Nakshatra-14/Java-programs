//Input and sort some names in alphabetical order
import java.util.*;

public class NameSort {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter no. of name: ");
        int n = inp.nextInt();
        String names[] = new String[n];
        inp.nextLine();                 //To Clear input Buffer
        for(int i = 0 ; i < n ; i++)
        {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = inp.nextLine();
        }
        
        for(int i = 0 ; i < n - 1 ; i++)
        {
            for(int j = i + 1 ; j < n ; j++)
            {
                if(names[i].compareTo(names[j]) > 0)
                {
                    //swap names[i], names[j]
                    String temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }
            }
        }

        for (String e : names) {
            System.out.println(e);
        }
    }
}
