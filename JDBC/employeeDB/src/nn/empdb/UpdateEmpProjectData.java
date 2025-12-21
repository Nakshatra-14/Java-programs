package nn.empdb;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class UpdateEmpProjectData {
    
    private static final String dbName = "companydb";
    private static JComboBox<String> comboEmp;
    private static JComboBox<String> comboProjects;
    private static JTextField txtFdHours = new JTextField(10);
    private static JLabel lblProjStatus = new JLabel();
    private static JButton subBtn = new JButton("Submit");
    private static JButton findBtn = new JButton("Find Project");
    private static JButton addProjBtn = new JButton("Add Project");
    private static JButton cancelBtn = new JButton("Cancel"); 
    private static JFrame frm = new JFrame("Update Emp Project Data");
    
    public static void main(String[] args) throws SQLException {
        
        comboEmp = new JComboBox<>(getNoProjEmp());
        comboProjects = new JComboBox<>(getProjects());


        JPanel p1 = new JPanel(new BorderLayout());
        JPanel flowP = new JPanel();
        flowP.add(comboEmp);
        flowP.add(findBtn);
        p1.add(flowP, BorderLayout.NORTH);
        lblProjStatus.setVisible(false);
        lblProjStatus.setHorizontalAlignment(SwingConstants.CENTER);
        p1.add(lblProjStatus, BorderLayout.CENTER); 
        addProjBtn.setVisible(false);
        p1.add(new JPanel(new FlowLayout()).add(addProjBtn), BorderLayout.SOUTH);
        
        
        JPanel p2 = new JPanel();
        p2.add(new JLabel(comboEmp.getItemAt(comboEmp.getSelectedIndex())));
        p2.add(comboProjects);
        p2.add(txtFdHours);


        frm.add(p1);
        findBtn.addActionListener( _ -> {
            // System.out.println("Finding");
            String str = comboEmp.getItemAt(comboEmp.getSelectedIndex());
            boolean check = false;
            try {
                check = hasProject(str);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(check)
            {
                lblProjStatus.setText("Project Found");
                addProjBtn.setVisible(false);
            }
            else
            {
                lblProjStatus.setText("No Projects Found");
                addProjBtn.setVisible(true);
            }
            lblProjStatus.setVisible(true);
            frm.revalidate();
            frm.pack();
        });

        

        addProjBtn.addActionListener( _ -> {
            frm.add(p2);
            frm.remove(p1);
            // frm.pack();
            frm.revalidate();
        });

        subBtn.addActionListener( _ -> {

        });

        cancelBtn.addActionListener( _ -> {
            frm.remove(p2);
            frm.add(p1);
        });

        frm.pack();
        // frm.setResizable(false);
        frm.setLocationRelativeTo(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);

    }

    public static boolean hasProject(String name) throws SQLException
    {
        try
        (
            Connection conn = MySQL_Connector.getConnection(dbName);
            Statement stmt = conn.createStatement();
        )
        {
            ResultSet rs;
            //name of the emp who do not work on any projects
            String sql = "select name \n" + //
                                "from emp e\n" + //
                                "where e.name = '" + name + "' and exists (select * from workson w where e.ssn = w.ssn)";
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            System.out.println("checking " + name + " status");
            return rs.next();
        }
    }

    public static String[] getNoProjEmp() throws SQLException 
    {
        ArrayList<String> al = new ArrayList<>();
        try
        (
            Connection conn = MySQL_Connector.getConnection(dbName);
            Statement stmt = conn.createStatement();
        )
        {
            ResultSet rs = stmt.executeQuery("select name from emp order by 1");

            while(rs.next())
                al.add(rs.getString(1));
        }
        String arr[] = new String[al.size()];
        return al.toArray(arr);
    } 

    public static String[] getProjects() throws SQLException
    {
        ArrayList<String> al = new ArrayList<>();
        try
        (
            Connection conn = MySQL_Connector.getConnection(dbName);
            Statement stmt = conn.createStatement();
        )
        {
            ResultSet rs = stmt.executeQuery("select pname from project");

            while(rs.next())
                al.add(rs.getString(1));
        }
        String arr[] = new String[al.size()];
        return al.toArray(arr);
    }

}