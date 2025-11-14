
import java.util.Arrays;
import java.util.Scanner;

public class Anagram {

    public static boolean areAnagrams(String str1, String str2)
    {
        if(str1.length() != str2.length())
            return false;
        
        int freq[] = new int[26];
        for(int i = 0 ; i < str1.length() ; i++)
        {
            freq[str1.charAt(i) - 'a']++;
            freq[str2.charAt(i) - 'a']--;
        }
        boolean allZeros = true;
        for(int i = 0 ; i < freq.length ; i++)
        {
            if(freq[i] != 0) 
            {
                allZeros = false;
                break;
            }
        }
        return allZeros;    
    }
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String str1  = inp.nextLine();
        String str2  = inp.nextLine();
        inp.close();
        System.out.println(areAnagrams(str1, str2));
    }
}
