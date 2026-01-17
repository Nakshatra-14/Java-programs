package nn.regex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExDemo 
{

    static String readAll(File file) throws FileNotFoundException
    {
        Scanner sc = new Scanner(file) ;

        StringJoiner sj = new StringJoiner("\n") ;
        while(sc.hasNextLine())
            sj.add(sc.nextLine()) ;
        sc.close(); 

        return sj.toString() ;
    }


    public static void main(String[] args) throws FileNotFoundException 
    {
        // File folder = new File("resources") ;
        // File file = new File(folder, "Paragraphs with Dates.txt") ;

        String str = readAll(new File("Text.txt")) ;

        // Splitting a string using regex
        String words[] = str.split("\\W+") ; // Split into the words by using delimeters as one or more non-word characters.
        System.out.println("All the words: " + Arrays.toString(words));
        System.out.println();

        // Regex for dates in the format dd/mm/yyyy or dd-mm-yyyy
        // String regex = "\\d\\d-\\d\\d-\\d\\d\\d\\d|\\d\\d/\\d\\d/\\d\\d\\d\\d" ;
        String regex = "(\\d\\d)([-/])(\\d\\d)\\2(\\d\\d\\d\\d)" ;
        // String regex = "\\d\\d-\\d\\d-\\d\\d\\d\\d|\\d\\d/\\d\\d/\\d\\d\\d\\d" ; // \d\d-\d\d-\d\d\d\d|\d\d/\d\d/\d\d\d\d -> dd-mm-yyyy|dd/mm/yyyy
        String dt1 = "27-12-2025" ;
        String dt2 = "27/12/2025" ;
        String dt3 = "27.12.2025" ;

        // Matching entire string
        System.out.println("Using string.matches():");
        System.out.printf("%s is %s date string%n", dt1, dt1.matches(regex) ? "valid" : "INVALID");
        System.out.printf("%s is %s date string%n", dt2, dt2.matches(regex) ? "valid" : "INVALID");
        System.out.printf("%s is %s date string%n", dt3, dt3.matches(regex) ? "valid" : "INVALID");
        // OR
        System.out.println("Using Pattern.matches():");
        System.out.printf("%s is %s date string%n", dt1, Pattern.matches(regex, dt1) ? "valid" : "INVALID");
        System.out.printf("%s is %s date string%n", dt2, Pattern.matches(regex, dt2) ? "valid" : "INVALID");
        System.out.printf("%s is %s date string%n", dt3, Pattern.matches(regex, dt3) ? "valid" : "INVALID");
        // OR
        System.out.println("After compiling a pattern:");
        Pattern pat = Pattern.compile(regex) ;
        Matcher matcher ;
        matcher = pat.matcher(dt1) ;
        System.out.printf("%s is %s date string%n", dt1, matcher.matches() ? "valid" : "INVALID");
        matcher = pat.matcher(dt2) ;
        System.out.printf("%s is %s date string%n", dt2, matcher.matches() ? "valid" : "INVALID");
        matcher = pat.matcher(dt3) ;
        System.out.printf("%s is %s date string%n", dt3, matcher.matches() ? "valid" : "INVALID");

        // Mathing all the occurances
        System.out.println("Mathing all the occurances:");
        matcher = pat.matcher(str) ;

        // // All valid date substrings
        // while(matcher.find()) // as long as there is a match
        //     System.out.printf("%s | %s%n", matcher.group(), str.substring(matcher.start(), matcher.end())); // next matched substring

        System.out.println("that's it");

        matcher = pat.matcher(str) ;
        while(matcher.find())
        {
            System.out.println(matcher.group()); // next matched substring
            System.out.printf("%s, %s, %s, day=%s|%s, month=%s, year=%s", matcher.group(), matcher.group(0), str.substring(matcher.start(), matcher.end()), matcher.group(1), str.substring(matcher.start(1), matcher.end(1)), matcher.group(3), matcher.group(4));
            System.out.print(" -> All the groups: ");
            for(int i = 0 ; i <= matcher.groupCount() ; i ++)
                System.out.printf("group #%d:%s|", i, matcher.group(i));
            System.out.println();
        }
    }    


    
}
