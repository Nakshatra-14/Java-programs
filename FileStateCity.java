import java.io.*;
import java.util.Scanner;
import java.util.StringJoiner;

public class FileStateCity {

    public static String showCityByState(String state) throws IOException
    {
        File file = new File("StatewiseCitiesOfIndia.txt");
        try(
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            )
            {
                boolean f = false;
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
                return sj.toString();
            }
    }
    public static void main(String[] args) throws IOException {

        File file = new File("StatewiseCitiesOfIndia.txt");
        // String state = "Andhra Pradesh";
        // System.out.println(showCityByState(state));

        String str = "";
        // boolean

            Scanner inp = new Scanner(System.in);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            // while (true) {
                System.out.print("City / State: ");
                str = inp.nextLine();
                // if(str.equals("quit"))
                    // break;

                for(String line = br.readLine() ; line != null ; line = br.readLine())
                {

                    String state = line.substring(43);
                    String city = line.substring(0, 43).trim();
                    
                    
                    if(str.equalsIgnoreCase(state))   //state to capital 
                    {
                        System.out.println("State = " + state + " City = " + city);
                        // System.out.println("Capital of " + state + " is " + city);
                        // break;
                    }                                        

                    else if(str.equals(city))   //City to state
                    {
                        System.out.println(city + " is a city of " + state + " whose capital is " );
                        break;
                    }
                    
    
                }
            // }
            System.out.println("Goodbye");
        }
    
}
