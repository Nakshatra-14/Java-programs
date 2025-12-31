package nn.empmgt;

import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PasswordManagerDiaglog extends JDialog {
    
    private JTextField txtOldPass = new JTextField(30);
    private JTextField txtNewPass = new JTextField(30);
    private JTextField txtReTypePass = new JTextField(30);
    private JButton btnOk = new JButton("Ok");
    private JButton btnCancel = new JButton("Cancel");
    private  boolean isItOk = false;

    public PasswordManagerDiaglog(JFrame owner, String title, boolean modal, String oldPass) {
        super(owner, title, modal);
        //  this.setTitle("");

        setLayout(new FlowLayout());

        if(oldPass != null)
        {
            this.add(new JLabel("Old Pass"));
            this.add(txtOldPass);
        }
        this.add(new JLabel("New Pass"));
        this.add(txtNewPass);
        this.add(new JLabel("ReType Pass"));
        this.add(txtReTypePass);
        this.add(btnOk);
        this.add(btnCancel);


        ActionListener alBtn = ev -> {
            JButton btn = (JButton) ev.getSource();

            if(btn == btnOk)
                isItOk = true;
            else
                isItOk = false;

            this.setVisible(false);
        };

        btnOk.addActionListener(alBtn);
        btnCancel.addActionListener(alBtn);



        //Citera for password 
        // min len = 8
        // must contain ateast 1 uppercase, 1 digit and 1 other charecter

        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setVisible(true);
    }

    public String getPass()
    {
        if(isItOk)
            return txtNewPass.getText();
        else
            return null;
    }

    public boolean isItOk() {
       return isItOk;
    }

}
