package nn.gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;

public class CellRendererJlist {
    public static void main(String[] args) {
        Color colors[] = {
                Color.RED,
                Color.BLUE,
                Color.GREEN,
                Color.YELLOW,
                Color.ORANGE,
                Color.PINK,
                Color.CYAN,
                Color.MAGENTA,
                Color.GRAY,
                Color.DARK_GRAY,
                Color.LIGHT_GRAY,
                new Color(128, 0, 0), // Maroon
                new Color(0, 128, 0), // Dark Green
                new Color(128, 0, 128), // Purple
                new Color(0, 128, 128), // Teal
                new Color(255, 165, 0), // Orange
                new Color(255, 192, 203), // Pink
                new Color(0, 255, 255), // Aqua
                new Color(128, 128, 0), // Olive
                new Color(139, 69, 19) // Saddle Brown
        };
        JList<Color> c = new JList<>(colors);
        c.setVisibleRowCount(5);
        c.setCellRenderer(new ColourCellRenderer());
        JScrollPane scpColor = new JScrollPane(c);
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(scpColor);
        jf.pack();
        jf.setVisible(true);
    }

    private static class ColourCellRenderer extends JLabel implements ListCellRenderer<Color> {
        private static Border setBorder = BorderFactory.createLineBorder(Color.BLACK);
        private static Border empBorder = BorderFactory.createLineBorder(Color.WHITE);

        public ColourCellRenderer() {
            super(" ".repeat(20));
            this.setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Color> list, Color value, int index,
                boolean isSelected, boolean cellHasFocus) {

            this.setBackground(value);
            this.setBorder(isSelected ? setBorder : empBorder);
            return this;
        }
    }
}
