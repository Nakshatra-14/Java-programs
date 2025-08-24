package nn.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

// Auto file creator not done

public class Note extends JFrame implements ActionListener {

    JTextArea jta;
    JButton saveBtn;

    File file = new File("save.nt");

    public void writeNote(String str) throws IOException
    {
        try(
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);
            )
            {   
                pw.println(str);
            }
    }

    public void showNote() throws IOException
    {
        try(
            Scanner sc = new Scanner(file);
        )
        {
            while (sc.hasNextLine()) {
                jta.append(sc.nextLine());
                jta.append("\n");
            }
        }
    }

    public Note() throws IOException
    {
        setTitle("Note");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel main = new JPanel(new BorderLayout());
        JPanel txtarea = new JPanel();
        JPanel menu = new JPanel(new FlowLayout(FlowLayout.LEFT));

        jta = new JTextArea(25, 45);
        txtarea.add(jta);

        saveBtn = new JButton("Save");
        saveBtn.addActionListener(this);
        menu.add(saveBtn);

        main.add(menu, BorderLayout.NORTH);
        main.add(txtarea, BorderLayout.CENTER);

        add(main);

        showNote();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        try
        {
            if(btn.getText().equals("Save"))
                writeNote(jta.getText());
        }
        catch (Exception ex) {}
    }
    
    public static void main(String[] args) throws IOException{
        new Note().setVisible(true);
    }
    
}
