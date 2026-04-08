package stream.nn.emp_stream;

import java.io.FileReader;

import com.opencsv.CSVReader;

public class Test {
    public static void main(String[] args) {
        try (
            CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/employees.csv"))
            ) 
            {

            String[] row;
            while ((row = csvReader.readNext()) != null) 
                System.out.printf(
                    "%-8s %-6s %-10s %-10s %-8s %-12s %-12s %-30s %-12s %-15s%n",
                    row[0], row[1], row[2], row[3], row[4],
                    row[5], row[6], row[7], row[8], row[9]
                );
            
            // List<String[]> allData = csvReader.readAll(); 
            // String s[] = new String[allData.size()];
            // for(int i = 0 ; i < allData.size() ; i++)
            // {
            //     s = allData.get(i);
            //     System.out.println(Arrays.toString(s));
            // }

        } 
        catch(Exception ex) {ex.printStackTrace();}
    }
}
