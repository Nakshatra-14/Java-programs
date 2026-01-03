package nn.regex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateOrder {

    public static String getStringFrmFile(File file) throws FileNotFoundException
    {
        StringJoiner sj = new StringJoiner(" ");

        try
        (
            Scanner inp = new Scanner(file);
        )
        {
            while (inp.hasNextLine()) {
                 sj.add(inp.next());
                
            }
        } 
        return sj.toString();
    }
    //(\d\d)([\/-])(\d\d)\2(\d\d\d\d)
    public static void main(String[] args) throws FileNotFoundException {
        String txt = getStringFrmFile(new File("Text.txt"));
        String regex = "(\\d\\d)([\\/-])(\\d\\d)\\2(\\d\\d\\d\\d)";
        Pattern pat = Pattern.compile(regex);
        Matcher matcher = pat.matcher(txt);

        while(matcher.find())
        {
            System.out.println(matcher.group());
        }
    }
}
