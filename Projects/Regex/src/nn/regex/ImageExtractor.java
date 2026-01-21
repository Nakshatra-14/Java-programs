package nn.regex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageExtractor {

    static String readAll(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);

        StringJoiner sj = new StringJoiner("\n");
        while (sc.hasNextLine())
            sj.add(sc.nextLine());
        sc.close();

        return sj.toString();
    }

    public static List<String> countImg() throws FileNotFoundException {
        ArrayList<String> al = new ArrayList<>();
        String regex = "img";

        Pattern pat = Pattern.compile(regex);

        Matcher matcher = pat.matcher(readAll(new File("source.txt")));

        while (matcher.find()) {
            // System.out.println(matcher.group());
            al.add(matcher.group());
        }

        return al;
    }

    static List<String> getImgTag(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        ArrayList<String> al = new ArrayList<>();
        String regex = "<img.*(src\\s*=\\s*\\\"([^\"]*)\\\").*>";
        Pattern pat = Pattern.compile(regex);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            Matcher matcher = pat.matcher(line);
            if (matcher.find()) {
                al.add(matcher.group(2));
            }
        }
        sc.close();

        return al;
    }

    // public static void replaceLinks(File fSource, String tSource) throws
    // IOException {
    // String regex = ".*^(https|http)[:]//.*[?](text=(.*))";
    // Pattern pat = Pattern.compile(regex);
    // String str = "";
    // try (
    // Scanner sc = new Scanner(fSource);) {
    // while (sc.hasNextLine()) {
    // String line = sc.nextLine();
    // Matcher matcher = pat.matcher(line);
    // if (matcher.find()) {
    // // System.out.println("http://our-server.co.org/imgs/" + matcher.group(3));
    // String l = "http://our-server.co.org/imgs/" + matcher.group(3) + "\n";
    // str += l;
    // } else
    // str += line;
    // }
    // // System.out.println(str);
    // }
    // File fTarget = new File(tSource);
    // if (!fTarget.exists()) {
    // FileOutputStream fos = new FileOutputStream(fTarget);
    // fos.close();
    // }

    // try (
    // FileWriter fw = new FileWriter(fTarget);) {
    // fw.write(str);
    // }
    // }

    public static void replaceLinks(File fSource, File fTarget) throws IOException {
        String regexForGetImgTag = "(<img.*)(src\\s*=\\s*\\\"([^\\\"]*)\\\")(.*>)";
        String regexForGetLink = ".*(https|http)[:]...*[?](text=(.*))";
        Pattern patImgTag = Pattern.compile(regexForGetImgTag);
        Pattern patForLink = Pattern.compile(regexForGetLink);
        String str = "";
        try (
                Scanner sc = new Scanner(fSource);) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                Matcher matcherForImgTag = patImgTag.matcher(line);
                if (matcherForImgTag.find()) {
                    Matcher matcherForLink = patForLink.matcher(line);
                    // System.out.println(line);
                    if (matcherForLink.find()) {
                        String s = matcherForImgTag.group(1) + "src=" + "\"" +
                                "http://our-server.co.org/imgs/" + matcherForLink.group(3) + "\"" +
                                matcherForImgTag.group(4) + "\n";
                        System.out.println(s);
                        str += s;
                    }
                } else
                    str += line + "\n";
            }
            // System.out.println(str);
        }
        // File fTarget = new File(tSource);
        // if (!fTarget.exists()) {
        // FileOutputStream fos = new FileOutputStream(fTarget);
        // fos.close();
        // }

        try (
        FileWriter fw = new FileWriter(fTarget);) {
        fw.write(str);
        }
    }

    public static void main(String[] args) throws IOException {
        // System.out.println(countImg());
        // List<String> al = getImgTag(new File("index.html"));

        // for(String s : al)
        // System.out.println(s);
        // System.out.println();
        // Collections.sort(al);

        // for(String s : al)
        // System.out.println(s);

        // https://via.placeholder.com/200x150?text=Goofy
        // http://our-server.co.org/images/Goofy.jpg

        // https://www.google.com/search?q=mickey+mouse+jpg+pic&text=gallery&oq=mickey+mouse+jpg+pic&gs_lcrp=EgZjaHJvbWUyBggAEEUYOTIJCAEQABgNGIAEMggIAhAAGBYYHjIICAMQABgWGB4yCAgEEAAYFhgeMgoIBRAAGIAEGKIEMgoIBhAAGIAEGKIEMgoIBxAAGIAEGKIEMgoICBAAGIAEGKIEMgoICRAAGIAEGKIE0gEKMTUxOTNqMGoxNagCCLACAfEFiLX_dbUj8X4&sourceid=chrome&ie=UTF-8

        // WAP that inp a html file and copy that file to another html, with all the
        // links in the img source, replaced as bellow
        // http://our-server.co.org/imgs/<imagefilename>.jpg
        // where img file name is txt as before

        // replaceLinks(new File("T.txt"), "new.txt");
        replaceLinks(new File("index.html"), new File("new.html"));
    }
}
