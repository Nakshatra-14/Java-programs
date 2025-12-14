package nn.empdb;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringJoiner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InputTwoDataAndShowData {

    static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


    public static void showResults(JTextArea ta, Date initDate, Date finalDate, int initSal, int FinalSal)
    {
        String driveName = "com.mysql.cj.jdbc.Driver";
        String dbName = "companydb";
        String url = "jdbc:mysql://localhost:3306/" + dbName;
        // StringJoiner sj = new StringJoiner(", ");

        String usr = "root";
        String pwd = "4762";

        try
        {
            Class.forName(driveName);
        }
        catch(ClassNotFoundException ex)
        {
            System.out.println("Driver " + driveName + " is not found");
        }

        try 
        (
            Connection con = DriverManager.getConnection(url, usr, pwd);
        ) 
        {
            // System.out.println("Database " + dbName + " connected succesfully");
            Statement stmt1 = con.createStatement(); 
            Statement stmt2 = con.createStatement(); 

            String sql = "select e.ssn, e.name, e.bdate, e.salary\n" + //
                         "from emp e\n" + //
                         "where e.Bdate between '" + sdf.format(initDate) + "' and '" + sdf.format(finalDate) + "' and e.salary between " + initSal + " and " + FinalSal;
            
            ResultSet rs = stmt1.executeQuery(sql);
            ta.setText("");
            while(rs.next())
            {
                // sj.add(rs.getString(1));
                String str = getprojectWorked(stmt2, rs.getString(1));
                // ta.append(rs.getString(2) + " | " + rs.getString(3) + " | " + rs.getString(4) + ": " + str + "\n");
                ta.append(String.format("%-25s | %-15s | %-10s | %s%n", rs.getString(2), rs.getString(3), rs.getString(4), str));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // return sj.toString();
        
    }


    private static String getprojectWorked(Statement stmt2, String ssn) throws SQLException {
        StringJoiner sj = new StringJoiner(", ");
        String sql = "select pname\n" + 
                        "from project p, workson w \n" + 
                        "where p.pno = w.pno and ssn = " + ssn + "\n" + 
                        "order by 1";
        try (ResultSet rs = stmt2.executeQuery(sql)) {
            while(rs.next())
            {
                sj.add(rs.getString(1));
            }
        }
            return sj.toString();
    }

    public static void main(String[] args) {
        JFrame frm = new JFrame("Department Location");
        
        JTextArea taResult = new JTextArea(8, 30);
        JButton btn = new JButton("Submit");
        JLabel txtDate = new JLabel("Date:-");
        JLabel txtSal = new JLabel("Salary:-");
        JLabel txtProj = new JLabel("Projects:-");
        JLabel lblInit = new JLabel("Initial:");
        JLabel lblFinal = new JLabel("Final:");

        JTextField txtFdInitDate = new JTextField(12);
        JTextField txtFdFinalDate = new JTextField(12);
        JTextField txtFdInitSalary = new JTextField(12);
        JTextField txtFdFinalSalary = new JTextField(12);
        
                
        JPanel p = new JPanel(new GridBagLayout());
        Insets insets = new Insets(5,5, 5,5);

        GridBagConstraints gbc = new GridBagConstraints(0, 0, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
        p.add(new JPanel().add(txtDate), gbc);

        gbc = new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
        p.add(lblInit, gbc);
        
        gbc = new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
        p.add(txtFdInitDate, gbc);

        gbc = new GridBagConstraints(2, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
        p.add(lblFinal, gbc);

        gbc = new GridBagConstraints(3, 1, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
        p.add(txtFdFinalDate, gbc);

        gbc = new GridBagConstraints(0, 2, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
        p.add(txtSal, gbc);

        gbc = new GridBagConstraints(0, 3, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
        p.add(lblInit, gbc);

        gbc = new GridBagConstraints(1, 3, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
        p.add(txtFdInitSalary, gbc);

        gbc = new GridBagConstraints(2, 3, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
        p.add(lblFinal, gbc);

        gbc = new GridBagConstraints(3, 3, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
        p.add(txtFdFinalSalary, gbc);

        gbc = new GridBagConstraints(0, 4, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
        p.add(new JPanel().add(btn), gbc);

        gbc = new GridBagConstraints(0, 5, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
        p.add(new JPanel().add(txtProj), gbc);

        gbc = new GridBagConstraints(0, 6, 4, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
        p.add(new JScrollPane(taResult), gbc);

        btn.addActionListener(_ -> {
            Date initDate = null;
            Date finalDate = null;
            try {
                initDate = sdf.parse(txtFdInitDate.getText().trim());
                finalDate = sdf.parse(txtFdFinalDate.getText().trim());
            } catch (ParseException ex) { 
                System.getLogger(InputTwoDataAndShowData.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }


            int initSal = 0;
            int finalSal = 0;

            // try {
                initSal = Integer.parseInt(txtFdInitSalary.getText().trim());
                finalSal = Integer.parseInt(txtFdFinalSalary.getText().trim());
            // } catch (Exception e) {
            //     JOptionPane.showMessageDialog(frm, "Enter proper Salary format value in Date");
            //     return;
            // }

            showResults(taResult, initDate, finalDate, initSal, finalSal);
            
        });

        txtFdInitDate.setText("1960-01-01");
        txtFdFinalDate.setText("1962-01-01");
        txtFdInitSalary.setText("60000");
        txtFdFinalSalary.setText("70000");

        frm.add(p);
        // frm.pack();
        frm.setSize(1400, 400);
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setResizable(false);
        frm.setVisible(true);
    }

}
