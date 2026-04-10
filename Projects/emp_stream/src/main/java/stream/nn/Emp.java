package stream.nn;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.stream.Stream;

import com.opencsv.CSVReader;

public class Emp implements Comparable<Emp>{

    private String empCode;
    private int id;
    private String fName;
    private String lName;
    private String gender;
    private Date dob;
    private Date dateOfJoining;
    private String email;
    private String phNo;
    private String dept;
    private static SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd");
    private static SimpleDateFormat sdfOut = new SimpleDateFormat("dd-MM-yyyy");
    

    public Emp(String empCode, String id, String fName, String lName, String gender, String dob, String dateOfJoining, String email, String phone, String dept) {
        this.empCode = empCode;
        this.id = Integer.parseInt(id);
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
        try {
            this.dob = sdfIn.parse(dob);
            this.dateOfJoining = sdfIn.parse(dateOfJoining);
        } catch (ParseException e) {e.printStackTrace();}
        this.email = email;
        this.phNo = phone;
        this.dept = dept;
    }

    public static Emp readNextEmp(Iterator<String[]> it)
    {  
        String row[] = it.next();
        return new Emp(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8], row[9]);
    }

    static Stream<Emp> streamFromCSV()
    {
        try {
            CSVReader csvReader = new CSVReader(new FileReader("src/main/resources/employees.csv"));
            Iterator<String[]> it = csvReader.iterator();
            it.next();
            Stream<Emp> stm = Stream.iterate(readNextEmp(it), e -> it.hasNext() , e -> readNextEmp(it));
            stm.onClose(() -> {
                    try {
                        csvReader.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                });
                return stm;
            } 
            catch (Exception ex) {ex.printStackTrace();}
            return null;
    }

    @Override
    public String toString() {
        return String.format("%-8s %-6s %-10s %-10s %-8s %-12s %-12s %-30s %-12s %-15s", empCode, String.valueOf(id), fName, lName, gender, sdfOut.format(dob), sdfOut.format(dateOfJoining), email, phNo, dept);
    }

    public static String getHeader()
    {
        return String.format("%-8s %-6s %-10s %-10s %-8s %-12s %-12s %-30s %-12s %-15s", "empCode", "id", "fName", "lName", "gender", "DOB", "DOJ", "email", "phNo", "dept");
    }
    
    
    @Override
    public int compareTo(Emp other) {
        int r = this.lName.compareTo(other.lName);
        if(r == 0)
            r = this.fName.compareTo(other.fName);
        return r; 
    }

    public static void main(String[] args) {
        Stream<Emp> stm = Emp.streamFromCSV();
        stm = stm.limit(300);
        // stm = stm.sorted();
        stm = stm.sorted(Comparator.comparing(Emp::getlName).thenComparing(Emp::getfName).reversed());
        System.out.println(Emp.getHeader());
        stm.forEach(System.out::println);
        stm.close();
    }

    public String getEmpCode() {
        return empCode;
    }

    public int getId() {
        return id;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getGender() {
        return gender;
    }

    public Date getDob() {
        return dob;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public String getEmail() {
        return email;
    }

    public String getPhNo() {
        return phNo;
    }

    public String getDept() {
        return dept;
    }

    public static SimpleDateFormat getSdfIn() {
        return sdfIn;
    }

    public static SimpleDateFormat getSdfOut() {
        return sdfOut;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhNo(String phNo) {
        this.phNo = phNo;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public static void setSdfIn(SimpleDateFormat sdfIn) {
        Emp.sdfIn = sdfIn;
    }

    public static void setSdfOut(SimpleDateFormat sdfOut) {
        Emp.sdfOut = sdfOut;
    }

    
}
