package nn.empmgt ;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class Form {

    // public ImageIcon getImg() throws IOException
    // {
    //     return new ImageIcon(ImageIO.read(new File("picture\resize\1.png")));
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
    // private JTextField txtOccup = new JTextField();
    private JButton picChgBtn = new JButton("Change");
    private JLabel lblUsername = new JLabel("Username:");
    private JTextField txtUsername = new JTextField(15);
    private JLabel lblPassword = new JLabel("Password:");
    private JTextField txtPassword = new JTextField(10);
    private JButton chgPassBtn = new JButton("Change");
    private JButton btnFirst = new JButton("First");
    private JButton btnPrev = new JButton("Previous");
    private JButton btnNext = new JButton("Next");
    private JButton btnLast = new JButton("Last");
    private JButton btnAdd = new JButton("Add");
    private JButton btnEdit = new JButton("Edit");
    private JButton btnSave = new JButton("Save");
    private JButton btnDel = new JButton("Delete");
    private JButton btnCancel = new JButton("Cancel");

    private JComboBox<String> occupComboBox = new JComboBox<>(txtFileToArray(new File("jobs.txt")));
    
    private ArrayList<Person> people;
    private int currIndex = -1; 
    private char aen = 'n';

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
        
        btnSave.setEnabled(false);

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

                case "Save" -> {
                    if (checkData(frm)) {
                        Person p = new Person(txtName.getText(), txtDob.getText(), (radMale.isSelected()) ? "M" : "F", txtAddress.getText(), txtEmail.getText(), String.valueOf(occupComboBox.getSelectedIndex()), txtUsername.getText(), txtPassword.getText());
                        
                        if(aen == 'a')
                        {
                            people.add(p);
                            model.addElement(p.getName());
                        }
                        else if(aen == 'e')
                        {
                            people.set(currIndex, p);
                            model.set(currIndex, p.getName());
                        }

                        aen = 'n';
                        btnSave.setEnabled(false);
                        btnFirst.setEnabled(true);
                        btnPrev.setEnabled(true);
                        btnNext.setEnabled(true);
                        btnLast.setEnabled(true);
                    }
                    else
                    {
                        System.out.println("Wrong Input");
                        return;
                    }
                }
                case "Cancel" -> {
                    aen = 'n';
                    btnSave.setEnabled(false);
                    btnFirst.setEnabled(true);
                    btnPrev.setEnabled(true);
                    btnNext.setEnabled(true);
                    btnLast.setEnabled(true);
                }
            }
            showData(currIndex);
        };

        ActionListener lsnAEN = ev -> {
            JButton btn = (JButton) ev.getSource();
            switch (btn.getText()) {
                case "Add" -> 
                {
                    blankData();
                    aen = 'a';
                }
                case "Edit" -> {aen = 'e';}
            }
            btnSave.setEnabled(true);
            btnFirst.setEnabled(false);
            btnPrev.setEnabled(false);
            btnNext.setEnabled(false);
            btnLast.setEnabled(false);
            txtName.requestFocus();
        };

        ActionListener lsnDel = ev -> {
            people.remove(currIndex);
            model.remove(currIndex);
            blankData();
        };

        addControrollerBtn(controlerPanel, btnFirst, al);
        addControrollerBtn(controlerPanel, btnPrev, al);
        addControrollerBtn(controlerPanel, btnNext, al);
        addControrollerBtn(controlerPanel, btnLast, al);
        addControrollerBtn(controlerPanel, btnAdd, lsnAEN);
        addControrollerBtn(controlerPanel, btnEdit, lsnAEN);
        addControrollerBtn(controlerPanel, btnSave, al);
        addControrollerBtn(controlerPanel, btnDel, lsnDel);
        addControrollerBtn(controlerPanel, btnCancel, al);

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
        String addr[] = p.getAddress().split(", ");
        // System.out.println(Arrays.toString(addr));
        txtAddress.setText(String.join("\n", addr));
        txtDob.setText(p.getDob());
        occupComboBox.setSelectedIndex(p.getOccupationIndex());
        txtEmail.setText(p.getEmail());
        txtUsername.setText(p.getUsername());
        txtPassword.setText(p.getPassword());

        radMale.setSelected(p.getGender().equals("M"));
        radFemale.setSelected(p.getGender().equals("F"));
    }

    public void addControrollerBtn(JPanel panel, JButton btn, ActionListener alr)
    {
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
        p.add(occupComboBox, gbc);

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

    public void blankData()
    {
        txtName.setText("");
        txtAddress.setText("");
        txtDob.setText("");
        occupComboBox.setSelectedIndex(0);
        txtEmail.setText("");
        txtUsername.setText("");
        txtPassword.setText("");

        radFemale.setSelected(true);
        System.out.println("Blank");
    }

    public boolean checkData(JFrame frm)
    {
        boolean checked = true;
        if(!txtName.getText().matches("[A-Za-z ]+"))
        {
            JOptionPane.showMessageDialog(frm , "Name should be using charecters between A to Z only");
            txtName.requestFocus();
            checked = false;
        }
        if (!txtAddress.getText().matches("[A-Za-z ]+")) {
            JOptionPane.showMessageDialog(frm, "Address should contain alphanumeric characters, periods, commas, spaces, and hyphens only.");
            txtAddress.requestFocus();
            checked = false;
        }
        if (!txtDob.getText().matches("[A-Za-z ]+")) { 
            JOptionPane.showMessageDialog(frm, "Date of Birth should be in DD-MM-YYYY format.");
            txtDob.requestFocus();
            checked = false;
        }
        
        if (!txtEmail.getText().matches("[A-Za-z ]+")) {
            JOptionPane.showMessageDialog(frm, "Please enter a valid email address.");
            txtEmail.requestFocus();
            checked = false;
        }
        if (!txtUsername.getText().matches("[A-Za-z ]+")) { 
            JOptionPane.showMessageDialog(frm, "Username should be 3-15 alphanumeric characters or underscores.");
            txtUsername.requestFocus();
            checked = false;
        }
        if (!txtPassword.getText().matches("[A-Za-z ]+")) { 
            JOptionPane.showMessageDialog(frm, "Password must be at least 8 characters long and contain at least one digit, one lowercase, one uppercase, and one special character.");
            txtPassword.requestFocus();
            checked = false;
        }
        return checked;
    }

    public String[] txtFileToArray(File file) throws FileNotFoundException
    {
        ArrayList<String> al = new ArrayList<>();
        
        try
        (
            Scanner inp = new Scanner(file);
        )
        {
            while (inp.hasNextLine()) {
                al.add(inp.nextLine());
            }
        }

        String arr[] = new String[al.size()];
        return al.toArray(arr);
    }

    public static void main(String[] args) throws IOException {
        new Form();
    }

}
