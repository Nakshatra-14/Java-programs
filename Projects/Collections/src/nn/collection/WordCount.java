package nn.collection;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;

public class WordCount {

    public static String[] getwordsInArrayFromFile(String filename) throws FileNotFoundException
    {
        File file = new File(filename);
        Map<String, Integer> map = new HashMap<>();
        List<String> uniqueWords = new ArrayList<>();
        try
        (
            Scanner inp = new Scanner(file);
        )
        {
            while(inp.hasNextLine())
            {
                String str[] = inp.nextLine().split("\\W+");
                for(String s : str)
                {
                    if(!map.containsKey(s))
                    {
                        uniqueWords.add(s);
                        map.put(s, 1);
                    }
                    else
                        map.put(s, map.get(s)+1);
                    // map.put(s, map.getOrDefault(s, 0) + 1);
                }
                    // System.out.println(s);
            }
            
        }

        
    
        // // return sj.toString().split("\\W+");
        // System.out.println("Frequencies in the order of the apperance of the words");
        // for(String s : uniqueWords)
        //     System.out.println(s + " == " + map.get(s));

        // System.out.println("Frequencies in the alphabetical order of the words");
        // // Collections.sort(uniqueWords);
        // uniqueWords.sort(Comparator.naturalOrder());
        // for(String s : uniqueWords)
        //     System.out.println(s + " == " + map.get(s));

        // System.out.println("Words in decending order of Frequencies");
        // // uniqueWords.sort(Comparator.comparing(map::get).reversed());

        // Comparator<String> comp = new Comparator<String>() {
        //     @Override
        //     public int compare(String o1, String o2) {
        //         return - (map.get(o1) - map.get(o2));
        //     }
            
        // };
        // uniqueWords.sort(comp);


        System.out.println("Frequencies in the alphabetical order of the words");
        record WordFreq(String word, int freq) {
            @Override
            public final String toString() {
                return word + " == " + freq;
            }
        }
        List<WordFreq> lst = new ArrayList<>();
        for(var w : map.keySet())
            lst.add(new WordFreq(w, map.get(w)));
        lst.sort(Comparator.comparing(WordFreq::word));
        // lst.sort(Comparator.comparing(e -> e.word()));
        // if(ar[i].word().compareTo(ar[j].word()));
        // for(var e : lst)
        // {
        //     System.out.println(e);
        // }
        // lst.forEach(e -> System.out.println(e));
        //OR
        lst.forEach(System.out::println);

        System.out.println("Words in decending order of Frequencies");
        lst.sort(Comparator.comparing(WordFreq::freq).reversed());
        lst.forEach(System.out::println);

        //================================================ Can also be done using map.entryset()
        // for(String s : uniqueWords)
        //     System.out.println(s + " == " + map.get(s));
        return null;

    }

    public static void main(String[] args) throws FileNotFoundException{
        
       String str[] = getwordsInArrayFromFile("Text.txt");
        // for(String s : str)
        //     System.out.println("=" + s + "=");
    }
}
