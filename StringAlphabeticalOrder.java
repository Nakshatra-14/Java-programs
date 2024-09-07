import java.util.Scanner;

public class StringAlphabeticalOrder {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter String 1: ");
        String str1 = inp.nextLine();
        System.out.print("Enter String 2: ");
        String str2 = inp.nextLine();

        int n = str1.compareTo(str2);

        if(n > 0)
        {
            //swap str1 with str2
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        
        System.out.println(str1);
        System.out.println(str2);
        
    }
}
