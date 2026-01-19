package nn.regex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageExtractor {

    static String readAll(File file) throws FileNotFoundException
    {
        Scanner sc = new Scanner(file) ;

        StringJoiner sj = new StringJoiner("\n") ;
        while(sc.hasNextLine())
            sj.add(sc.nextLine()) ;
        sc.close(); 

        return sj.toString() ;
    }
    
    public static List<String> countImg() throws FileNotFoundException
    {
        ArrayList<String> al = new ArrayList<>();
        String regex = "img";

        Pattern pat = Pattern.compile(regex);

        Matcher matcher = pat.matcher(readAll(new File("source.txt")));

        while(matcher.find())
        {
            // System.out.println(matcher.group());
            al.add(matcher.group());
        }

        return al;
    }

    static List<String> getImgTag(File file) throws FileNotFoundException
    {
        Scanner sc = new Scanner(file) ;
        ArrayList<String> al = new ArrayList<>();
        String regex = "<img.*(src\\s*=\\s*\\\"([^\"]*)\\\").*>";
        Pattern pat = Pattern.compile(regex);
        
        while(sc.hasNextLine())
        {
            String line = sc.nextLine();
            Matcher matcher = pat.matcher(line);
            if(matcher.find()) {
                al.add(matcher.group(2));
            }
        }
        sc.close(); 

        return al;
    }

    public static void replaceLinks(File fSource, File fTarget) throws IOException
    {
        String regex = "";
        Pattern pat = Pattern.compile(regex);
        try
        (
            Scanner sc = new Scanner(fSource);
            FileWriter fw = new FileWriter(fTarget);
        )
        {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Matcher matcher = pat.matcher(line);
                if(matcher.find())
                {
                    
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        // System.out.println(countImg());
        // List<String> al = getImgTag(new File("index.html"));

        // for(String s : al)
        //     System.out.println(s);
        // System.out.println();
        // Collections.sort(al);

        // for(String s : al)
        //     System.out.println(s);


        // https://via.placeholder.com/200x150?text=Goofy
        // http://our-server.co.org/images/Goofy.jpg

        // https://www.google.com/search?q=mickey+mouse+jpg+pic&text=gallery&oq=mickey+mouse+jpg+pic&gs_lcrp=EgZjaHJvbWUyBggAEEUYOTIJCAEQABgNGIAEMggIAhAAGBYYHjIICAMQABgWGB4yCAgEEAAYFhgeMgoIBRAAGIAEGKIEMgoIBhAAGIAEGKIEMgoIBxAAGIAEGKIEMgoICBAAGIAEGKIEMgoICRAAGIAEGKIE0gEKMTUxOTNqMGoxNagCCLACAfEFiLX_dbUj8X4&sourceid=chrome&ie=UTF-8
        
        //WAP that inp a html file and copy that file to another html, with all the links in the img source, replaced as bellow
        //http://our-server.co.org/imgs/<imagefilename>.jpg
        //where img file name is txt as before
    }
}
