package nn.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Form {

    // public ImageIcon getImg() throws IOException
    // {
    //     return new ImageIcon(ImageIO.read(new File("picture\\resize\\1.png")));
    // }

    JList<String> jlst = new JList<>();
    JLabel lblName = new JLabel("Name:"); 
    JTextField txtName = new JTextField(); 
    JLabel pictPanel = new JLabel();
    JLabel lblAddress = new JLabel("Address:");
    JTextArea addressPanel = new JTextArea();
    JLabel lbldob = new JLabel("DOB:");
    JTextField dob = new JTextField();
    JRadioButton radMale = new JRadioButton("M");
    JRadioButton radFemale = new JRadioButton("F");
    JLabel lblEmail = new JLabel("Email:");
    JTextField email = new JTextField();
    JLabel lblOccupation = new JLabel("Occupation:");
    JTextField occupation = new JTextField();
    JButton picChgBtn = new JButton("Change");
    JLabel lblUsername = new JLabel("Username:");
    JTextField username = new JTextField();
    JLabel lblPassword = new JLabel("Password:");
    JTextField password = new JTextField();
    JButton chgPassBtn = new JButton("Change");

    public Form() throws IOException {
        jlst.setVisibleRowCount(20);
        JScrollPane scplst = new JScrollPane(jlst);
        DefaultListModel<String> model = new DefaultListModel<>();
        jlst.setModel(model);
        JFrame frm = new JFrame("Form Fillup");

        ButtonGroup genderGrp = new ButtonGroup();
        genderGrp.add(radMale);
        genderGrp.add(radFemale);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc;
        Insets insets = new Insets(5, 5, 5, 5);
        
        //List
        gbc = new GridBagConstraints(0, 0, 1, 6, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, insets, 0, 0);
        mainPanel.add(scplst, gbc);

        //lblName
        gbc = new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, insets, 0, 0);
        mainPanel.add(lblName, gbc);

        //txtName
        gbc = new GridBagConstraints(2, 0, 2, 1, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, insets, 0, 0);
        mainPanel.add(txtName, gbc);

        //pictPanel
        pictPanel.setIcon(new ImageIcon(ImageIO.read(new File("E:\\code\\Java\\JavaGUI\\picture\\resize\\1.png"))));
        gbc = new GridBagConstraints(4, 0, 1, 5, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, insets, 0, 0);
        mainPanel.add(pictPanel, gbc);

        //txtAddress
        gbc = new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, insets, 0, 0);
        mainPanel.add(lblAddress, gbc);

        //addressPanel
        addressPanel.setText(
            """
            Flat 3B, Sai Residency, 
            45 Park Road, Koregaon Park, Pune, 
            Maharashtra 411001, India
            """
            );
        gbc = new GridBagConstraints(2, 1, 1, 5, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, insets, 0, 0);
        mainPanel.add(addressPanel, gbc);

        //genderPanel
        JPanel genderPanel = new JPanel();
        genderPanel.setBorder(BorderFactory.createTitledBorder("Gender"));
        genderPanel.add(radMale);
        genderPanel.add(radFemale);
        gbc = new GridBagConstraints(3, 2, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, insets, 0, 0);
        mainPanel.add(genderPanel, gbc);

        //lbldob
        gbc = new GridBagConstraints(1, 2, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, insets, 0, 0);
        mainPanel.add(lbldob, gbc);

        //dob
        gbc = new GridBagConstraints(2, 2, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, insets, 0, 0);
        mainPanel.add(dob, gbc);

        //lblemail
        gbc = new GridBagConstraints(1, 3, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, insets, 0, 0);
        mainPanel.add(lblEmail, gbc);

        //email
        gbc = new GridBagConstraints(2, 3, 2, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, insets, 0, 0);
        mainPanel.add(email, gbc);

        //lblOccupation
        gbc = new GridBagConstraints(1, 4, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, insets, 0, 0);
        mainPanel.add(lblOccupation, gbc);

        //occupation
        gbc = new GridBagConstraints(2, 4, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, insets, 0, 0);
        mainPanel.add(occupation, gbc);

        //picChgBtn
        gbc = new GridBagConstraints(4, 3, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, insets, 0, 0);
        mainPanel.add(picChgBtn, gbc);

        //lblUsername
        gbc = new GridBagConstraints(1, 5, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, insets, 0, 0);
        mainPanel.add(lblUsername, gbc);
        
        //username
        gbc = new GridBagConstraints(2, 5, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, insets, 0, 0);
        mainPanel.add(username, gbc);

        //lblPassword
        gbc = new GridBagConstraints(3, 5, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, insets, 0, 0);
        mainPanel.add(lblPassword, gbc);

        //password
        gbc = new GridBagConstraints(4, 5, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, insets, 0, 0);
        mainPanel.add(password, gbc);

        //ChgPassBtn
        gbc = new GridBagConstraints(5, 5, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, insets, 0, 0);
        mainPanel.add(chgPassBtn, gbc);

        frm.add(mainPanel);
        frm.pack();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        new Form();
    }

}
