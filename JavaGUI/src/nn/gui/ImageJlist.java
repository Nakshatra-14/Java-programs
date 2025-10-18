package nn.gui;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;

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
    public static void main(String[] args) throws IOException {
        JList<Icon> jlst = new JList<>();
        File filepath = new File("picture");
        for(int i = 1 ; i < 10 ; i++)
        {
            File imgFile = new File(filepath, i + ".png");
            Image image = ImageIO.read(imgFile);
            Icon icon = new ImageIcon(image);
            jlst.add();
        }
    }
}
