package stream.nn;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;

public class DataGen {
    
    public static void main(String[] args) {
        DatabaseConnection dc = new DatabaseConnection();
        dc.setDbName("empdb");
         try 
        (
            Connection con = dc.getConnection();
        ) 
        { 
            Statement stmt = con.createStatement();
            stmt.executeUpdate("truncate table employee");
            System.out.println("Deleted old data");
            String sql = "insert into Employee(code, id, FirstName, LastName, Gender, dob, doj, email, phNumber, dept) " +
                        "values (?, ?, ?, ?, ? ,?, ?, ?, ?, ?)";
                                
            PreparedStatement pstmt = con.prepareStatement(sql);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            
            Stream<Emp> stm = Emp.streamFromCSV();
            stm.forEach(e -> {
                try
                {
                    int c = 1;
                    pstmt.setString(c++, e.getEmpCode());
                    pstmt.setInt(c++, e.getId());
                    pstmt.setString(c++, e.getfName());
                    pstmt.setString(c++, e.getlName());
                    pstmt.setString(c++, e.getGender().substring(0, 1));
                    pstmt.setDate(c++, new Date(e.getDob().getTime()));
                    pstmt.setDate(c++, new Date(e.getDateOfJoining().getTime()));
                    pstmt.setString(c++, e.getEmail());
                    pstmt.setString(c++, e.getPhNo());
                    pstmt.setString(c++, e.getDept());
                    
                    
                    
                    pstmt.executeUpdate();
                }
                catch(SQLException ex)
                {
                    System.getLogger(DataGen.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
            });
            
            System.out.println("Executed");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
}
