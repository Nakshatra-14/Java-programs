//Input a string and print it in reverse order
import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter String: ");
        String str = inp.nextLine();

        for(int i = str.length() - 1 ; i >= 0 ; i--)
        {
            System.out.print(str.charAt(i));
        }
        System.out.println();
    }
}
                               