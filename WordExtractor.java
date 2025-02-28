public class WordExtractor {
    
    public static void printMinLengthWords(String str)
    {
        String arr[] = str.split("\\s");
        int min = str.length();
        for (String word : arr) {
            if(!word.isEmpty() && min > word.length())
                min = word.length();
        }
        for (String word : arr) {
            if(!word.isEmpty() && min == word.length())
                System.out.println(word);
        }
    }

    public static void printMaxLengthWords(String str)
    {
        
    }

    public static void main(String[] args) {
        printMinLengthWords("They go        to school in  morning");
    }
}
