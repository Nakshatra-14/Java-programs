package nn.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.color.ColorSpace;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.ImageGraphicAttribute;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.imageio.stream.ImageInputStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Todo extends JFrame implements ActionListener{

    TextField input;
    JTextArea txtShow;
    String filename = "todo.info";

    public Todo()
    {
        setTitle("Todo");
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel p = new JPanel();

        p.setBackground(Color.yellow);

        p.add(new JLabel("Enter new: "));
        input = new TextField(40);
        p.add(input);

        JButton subB = new JButton("Submit");
        subB.setActionCommand("Submit");
        subB.addActionListener(this);
        p.add(subB);

        JButton showB = new JButton("Show all");
        showB.setActionCommand("Show");
        showB.addActionListener(this);
        p.add(showB);

        // p.add(new JLabel("imp"));

        txtShow = new JTextArea(20, 30);
        txtShow.setFont(new Font("Courier New", Font.PLAIN, 12));
        p.add(txtShow);

        

        add(p);
    }

    public void writeFile(String str) throws IOException
    {
        File f = new File(filename);
        // var fos = new FileOutputStream(f);
        // var dos = new DataOutputStream(fos);

        // dos.writeInt(c);
        // dos.writeUTF(str);

        FileWriter fw = new FileWriter(f, true);
        PrintWriter pw = new PrintWriter(fw);

        pw.println(str);
        pw.close();
    }

    public void showFile(JTextArea ta) throws IOException
    {
        File f = new File(filename);
        // var fis = new FileInputStream(f);
        // var dis = new DataInputStream(fis);

        // int n = dis.readInt();
        // String s = dis.readUTF();
        // return n + " : " + s; 

        Scanner sc = new Scanner(new FileInputStream(f));
        //Print all lines of the file
        ta.setText("");
        int c = 1;
        while(sc.hasNextLine())
        {
            ta.append(c + " : " + sc.nextLine());
            ta.append("\n");
            c++;
            // System.out.println(sc.nextLine());
        }
        sc.close(); 
    }

    public static void main(String[] args) {
        new Todo().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        try
        {
            if (btn.getActionCommand() == "Submit")
            {
                writeFile(input.getText());
            }
        }
        catch(IOException ex) { txtShow.setText(ex.getMessage()); }

        try
        {
            if (btn.getActionCommand() == "Show")
            {
                showFile(txtShow);
                // while(true)
                // {
                //     new JLabel(showFile());
                // }
            }
        }
        catch(IOException ex) {txtShow.setText(ex.getMessage()); }
    }
    
}
