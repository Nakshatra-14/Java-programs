package stream.nn;

import java.io.FileReader;
import java.util.Date;
import java.util.stream.Stream;

import com.opencsv.CSVReader;

public class Emp {

    private String empCode;
    private long id;
    private String fName;
    private String lName;
    private String gender;
    private Date dob;
    private Date dateOfJoining;
    private String email;
    private int phNo;
    private String dept;

    public Emp(long id, String fName, String lName, String gender, Date dob, Date dateOfJoining, String email, int phNo,
            String dept) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
        this.dob = dob;
        this.dateOfJoining = dateOfJoining;
        this.email = email;
        this.phNo = phNo;
        this.dept = dept;
    }

    static Stream streamFromCSV()
    {
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
            }
            catch(Exception ex) {ex.printStackTrace();}
    }
}
