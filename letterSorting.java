
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;


public class letterSorting {

    // public static void printLettersSorted(String str)
    // {
    //     ArrayList<Character> lst = new ArrayList<>();
    
    //     for(int i = 0 ; i < str.length() ; i++)
    //         lst.add(str.charAt(i));

    //     System.out.println(lst.toString());

    //     Comparator<Character> cmp = new Comparator<>() {
    //         @Override
    //         public int compare(Character o1, Character o2) {
    //             return o1 - o2;
    //         }
    //     };

    //     lst.sort(cmp);

    //     // Collections.sort(lst);
        
    //     System.out.println(lst.toString());
    // }

    public static int[] letterCount(String str)
    {
        int letterFreq[] = new int[26];
        for(int i = 0 ; i < str.length() ; i++)
        {
            letterFreq[str.charAt(i) - 'a']++;
        }
        return letterFreq;
    }

    public static void printLettersSorted(String str)
    {
        str = str.toLowerCase();
        int freq[] = letterCount(str);
        for(int i = 0 ; i < freq.length ; i++)
            for (int j = 0 ; j < freq[i] ; j++)
                System.out.print((char)(i + 'a'));
    
    }

    public static void main(String[] args) {
        printLettersSorted("allomorrorrissississandandororrullullomomississandrarallorrorrimimmissississundundararrullullomomississandra");
    }
}
