package nn ;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
import javax.swing.ListSelectionModel;

public class Form {

    // public ImageIcon getImg() throws IOException
    // {
    //     return new ImageIcon(ImageIO.read(new File("picture\\resize\\1.png")));
    // }
    
    private JList<String> jlst = new JList<>();
    private JLabel lblName = new JLabel("Name:"); 
    private JTextField txtName = new JTextField(); 
    private JLabel pictPanel = new JLabel();
    private JLabel lblAddress = new JLabel("Address:");
    private JTextArea txtAddress = new JTextArea(4, 30);
    private JLabel lbldob = new JLabel("DOB:");
    private JTextField txtDob = new JTextField();
    private JRadioButton radMale = new JRadioButton("M");
    private JRadioButton radFemale = new JRadioButton("F");
    private JLabel lblEmail = new JLabel("Email:");
    private JTextField txtEmail = new JTextField(20);
    private JLabel lblOccupation = new JLabel("Occupation:");
    private JTextField txtOccup = new JTextField();
    private JButton picChgBtn = new JButton("Change");
    private JLabel lblUsername = new JLabel("Username:");
    private JTextField txtUsername = new JTextField(15);
    private JLabel lblPassword = new JLabel("Password:");
    private JTextField txtPassword = new JTextField(10);
    private JButton chgPassBtn = new JButton("Change");

    private ArrayList<Person> people;
    private int currIndex = -1; 

    public Form() throws IOException {
        jlst.setVisibleRowCount(20);
        JScrollPane scplst = new JScrollPane(jlst);
        DefaultListModel<String> model = new DefaultListModel<>();
        jlst.setModel(model);
        jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jlst.addListSelectionListener(_ -> {
            if(!jlst.getValueIsAdjusting())
            {
                currIndex = jlst.getSelectedIndex();
                showData(currIndex);
            }
        });

        JFrame frm = new JFrame("Form Fillup");

        ButtonGroup genderGrp = new ButtonGroup();
        genderGrp.add(radMale);
        genderGrp.add(radFemale);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        Insets insets = new Insets(5, 5, 5, 5);

        addToLayout(gbc, insets, mainPanel, scplst);

        JPanel passwordPanel = new JPanel();

        //lblPassword
        // gbc = new GridBagConstraints(3, 5, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, insets, 0, 0);
        // mainPanel.add(lblPassword, gbc);
        // passwordPanel.add(lblPassword);

        //password
        // gbc = new GridBagConstraints(4, 5, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL, insets, 0, 0);
        // mainPanel.add(password, gbc);
        passwordPanel.add(txtPassword);

        //ChgPassBtn
        // mainPanel.add(chgPassBtn, gbc);
        passwordPanel.add(chgPassBtn);
        passwordPanel.setBorder(BorderFactory.createTitledBorder("Password"));
        gbc = new GridBagConstraints(3, 5, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, insets, 0, 0);
        mainPanel.add(passwordPanel, gbc);
        frm.add(mainPanel);

        JPanel controlerPanel = new JPanel(new GridLayout(1, 7, 10, 5));

        ActionListener al = ev -> {
            JButton btn = (JButton) ev.getSource();
            switch (btn.getText()) {
                case "First" -> currIndex = 0;
                case "Previous" -> {
                    currIndex--;
                    if(currIndex < 0)
                        currIndex = 0;
                }
                case "Next" -> {
                    currIndex++;
                    if(currIndex > people.size()-1)
                        currIndex = people.size()-1;
                }
                case "Last" -> currIndex = people.size()-1;
            }
            showData(currIndex);
        };
        addControrollerBtn(controlerPanel, "First", al);
        addControrollerBtn(controlerPanel, "Previous", al);
        addControrollerBtn(controlerPanel, "Next", al);
        addControrollerBtn(controlerPanel, "Last", al);
        addControrollerBtn(controlerPanel, "Add", al);
        addControrollerBtn(controlerPanel, "New", al);
        addControrollerBtn(controlerPanel, "Cancel", al);

        frm.add(controlerPanel, BorderLayout.SOUTH);

        
        people = Person.generate();
        for(Person p : people)
            model.addElement(p.getName());
        currIndex = 0;
        showData(currIndex);

        frm.pack();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocationRelativeTo(null);
        frm.setResizable(false);
        frm.setVisible(true);
    }

    public void showData(int index)
    {
        Person p = people.get(index);
        
        txtName.setText(p.getName());
        txtAddress.setText(p.getAddress());
        txtDob.setText(p.getDob());
        txtOccup.setText(p.getOccupation());
        txtEmail.setText(p.getEmail());
        txtUsername.setText(p.getUsername());
        txtPassword.setText(p.getPassword());

        radMale.setSelected(p.getGender().equals("M"));
        radFemale.setSelected(p.getGender().equals("F"));
    }

    public void addControrollerBtn(JPanel panel, String txt, ActionListener alr)
    {
        JButton btn = new JButton(txt);
        btn.addActionListener(alr);
        panel.add(btn);
    }

    public void addToLayout(GridBagConstraints gbc, Insets insets, JPanel p, JScrollPane jsp) throws IOException
    {
                //List
        gbc = new GridBagConstraints(0, 0, 1, 6, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, insets, 0, 0);
        p.add(jsp, gbc);

        //lblName
        gbc = new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, insets, 0, 0);
        p.add(lblName, gbc);

        //txtName
        gbc = new GridBagConstraints(2, 0, 2, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0);
        p.add(txtName, gbc);

        //pictPanel
        pictPanel.setIcon(new ImageIcon(ImageIO.read(new File("E:\\code\\Java\\JavaGUI\\picture\\resize\\1.png"))));
        gbc = new GridBagConstraints(4, 0, 1, 5, 1.0, 1.0, GridBagConstraints.NORTH, GridBagConstraints.BOTH, insets, 0, 0);
        p.add(pictPanel, gbc);

        //txtAddress
        gbc = new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, insets, 0, 0);
        p.add(lblAddress, gbc);

        //genderPanel
        JPanel genderPanel = new JPanel();
        genderPanel.setBorder(BorderFactory.createTitledBorder("Gender"));
        genderPanel.add(radMale);
        genderPanel.add(radFemale);
        gbc = new GridBagConstraints(3, 2, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, insets, 0, 0);
        p.add(genderPanel, gbc);

        //lbldob
        gbc = new GridBagConstraints(1, 2, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, insets, 0, 0);
        p.add(lbldob, gbc);

        //dob
        gbc = new GridBagConstraints(2, 2, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0);
        p.add(txtDob, gbc);

        //lblemail
        gbc = new GridBagConstraints(1, 3, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, insets, 0, 0);
        p.add(lblEmail, gbc);

        //email
        gbc = new GridBagConstraints(2, 3, 2, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0);
        p.add(txtEmail, gbc);

        //lblOccupation
        gbc = new GridBagConstraints(1, 4, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, insets, 0, 0);
        p.add(lblOccupation, gbc);

        //occupation
        gbc = new GridBagConstraints(2, 4, 2, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0);
        p.add(txtOccup, gbc);

        //picChgBtn
        gbc = new GridBagConstraints(4, 3, 2, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.BOTH, insets, 0, 0);
        p.add(picChgBtn, gbc);

        //lblUsername
        gbc = new GridBagConstraints(1, 5, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, insets, 0, 0);
        p.add(lblUsername, gbc);
        
        //username
        gbc = new GridBagConstraints(2, 5, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0);
        p.add(txtUsername, gbc);

        //addressPanel
        // taAddress.setText(
        //     """
        //     Flat 3B, Sai Residency, 
        //     45 Park Road, Koregaon Park, Pune, 
        //     Maharashtra 411001, India
        //     """
        //     );
        gbc = new GridBagConstraints(2, 1, 2, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, insets, 0, 0);
        p.add(new JScrollPane(txtAddress), gbc);
    }

    public static void main(String[] args) throws IOException {
        new Form();
    }

}
