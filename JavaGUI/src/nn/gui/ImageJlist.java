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
    public static Icon getBigIcon(int index) throws IOException
    {
        File imgPath = new File("picture");
        File file = new File(imgPath, index + ".png");
        Image img = ImageIO.read(file);
        return new ImageIcon(img);
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
        JLabel showImg = new JLabel("click");
        int curImgIndex = jlst.getSelectedIndex();
        if(curImgIndex != -1)
            showImg = new JLabel(getBigIcon(curImgIndex));

        JFrame frm = new JFrame();
        JPanel p = new JPanel(new GridLayout(2, 1));
        p.add(scpIconList);
        p.add(showImg);
        frm.add(p);
        frm.pack();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}
