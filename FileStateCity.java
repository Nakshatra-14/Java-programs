import java.io.*;
import java.util.Scanner;
import java.util.StringJoiner;

public class FileStateCity {



    public static void main(String[] args) throws IOException {

        File file = new File("StatewiseCitiesOfIndia.txt");
        String state = "Andhra Pradesh";
        
        
        try (
                Scanner inp = new Scanner(System.in);
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr)
                ) 
                {
                boolean f = false;
                // System.out.println("Enter state: ");
                // String state = inp.nextLine();
                br.readLine();          //Skip the header line
                var sj = new StringJoiner(", ", "[", "]");
                for(String line = br.readLine() ; line != null ; line = br.readLine())
                {
                    String sta = line.substring(43);
                    String city = line.substring(0, 43).trim();
                    if(state.equals(sta))
                    {
                        sj.add(city);
                        f = true;
                    }
                    if(f && !state.equals(sta))
                        break;
                }
                System.out.println(sj.toString());
        }
    }
}
