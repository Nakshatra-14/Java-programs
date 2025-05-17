import java.util.Scanner;

public class WordFinder {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String str = "A and an are different forms of the same word, the indefinite article that often precedes a noun. A is used before a noun that starts with a consonant sound";
        System.out.println(str);
        int l = str.length();
        System.out.println("Len: " + l);
        System.out.print("Enter search word: ");
        String word = inp.nextLine();
        int n = str.indexOf(word);
        if(n == -1)
            System.out.println("Not found: " + word);
        else
            System.out.println("The word " + word + " found at index: " + n);
        inp.close();
    }
}
