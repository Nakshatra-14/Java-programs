package nn.gui;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageAndIcon {
    public static void main(String[] args) throws IOException {
        JFrame frm = new JFrame();
        File imgPath = new File("picture\\resize");
        File file = new File(imgPath, "1.png");
        
        // BufferedImage bf = ImageIO.read(file);
        // Image img = ImageIO.write(file, "png", bf);
        
        Image image = ImageIO.read(file);
        Icon icon = new ImageIcon(image); 
        
        JPanel panel = new JPanel();
        panel.add(new JButton(icon));
        panel.add(new JLabel(icon));
        frm.add(panel);
        frm.setSize(200, 200);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}
