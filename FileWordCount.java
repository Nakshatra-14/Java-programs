import java.io.*;

public class FileWordCount {

    public static int countWordOld(String st) {
        String words[] = st.split(" ");
        int count = 0;
        for (String w : words)
            if (!w.isEmpty()) // if str has length zero
                count++;
        return count;
    }

    public static int countWord(String st) {
        int count = 0;
        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i) == ' ')
                continue;
            count++;
            while (i < st.length() && st.charAt(i) != ' ') {
                i++;
            }
        }

        return count;

    }

    public static void main(String[] args) throws IOException {
        
        var br = new BufferedReader(new FileReader(new File("Data.dat")));

        int toWord = 0;

        for(String line = br.readLine() ; line != null ; line = br.readLine())
        {
            toWord += countWord(line);
            // toWord += countWordOld(line);
            System.out.println(line);
        }
        
        br.close();
        System.out.println("No. of words =  " + toWord);

    }
}
