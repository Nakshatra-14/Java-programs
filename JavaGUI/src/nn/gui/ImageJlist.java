package nn.gui;

import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

public class ImageJlist {

    // public void inputImgInJlist(JList<Icon> jlst) throws IOException
    // {
    //     File filepath = new File("picture");
    //     for(int i = 1 ; i < 10 ; i++)
    //     {
    //         File imgFile = new File(filepath, i + ".png");
    //         Image image = ImageIO.read(imgFile);
    //         Icon icon = new ImageIcon(image);
    //         jlst.add(icon, i);
    //     }
    // }
    public static Icon getBigIcon(int index)
    {
        File imgPath = new File("picture");
        File file = new File(imgPath, index + ".png");
        try {
            Image img = ImageIO.read(file);
            return new ImageIcon(img);
        } catch (IOException e) {
            return null; 
        }
    }

    public static void main(String[] args) throws IOException {
        JList<Icon> jlst = new JList<>();
        jlst.setVisibleRowCount(4);
        JScrollPane scpIconList = new JScrollPane(jlst);
        DefaultListModel<Icon> model = new DefaultListModel<>(); 
        jlst.setModel(model);
        jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        File filepath = new File("picture\\resize");
        for(int i = 1 ; i <= 8 ; i++)
        {
            File imgFile = new File(filepath, i + ".png");
            System.out.println(imgFile.getName());
            Image image = ImageIO.read(imgFile);
            Icon icon = new ImageIcon(image);
            model.addElement(icon);
        }

        JLabel imgLbl = new JLabel();
        
        jlst.addListSelectionListener(_ -> 
        {

            if(!jlst.getValueIsAdjusting())
            {
                int curImgIndex = jlst.getSelectedIndex();

                if(curImgIndex != -1)
                    imgLbl.setIcon(getBigIcon(curImgIndex));

            }
        });

        JFrame frm = new JFrame();
        JPanel p = new JPanel(new GridLayout(2, 1));
        p.add(scpIconList);
        p.add(imgLbl);
        frm.add(p);
        frm.pack();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}
