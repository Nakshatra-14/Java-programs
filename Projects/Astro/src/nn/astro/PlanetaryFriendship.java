package nn.astro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class PlanetaryFriendship extends JPanel{

    private String colName[] = {"Planet Name", "Friend", "Neutral", "Enemies"};

    Object mat[][] = {
    {"Sun", "Moon, Mars, Jupiter", "Mercury", "Venus, Saturn"},
    {"Moon", "Sun, Mercury", "Mars, Jupiter, Venus, Saturn", "None"},
    {"Mars", "Sun, Moon, Jupiter", "Venus, Saturn", "Mercury"},
    {"Mercury", "Sun, Venus", "Mars, Jupiter, Saturn", "Moon"},
    {"Jupiter", "Sun, Moon, Mars", "Saturn", "Mercury, Venus"},
    {"Venus", "Mercury, Saturn", "Mars, Jupiter", "Sun, Moon"},
    {"Saturn", "Mercury, Venus", "Jupiter", "Sun, Moon, Mars"},
    {"Rahu", "Venus, Saturn", "Mercury, Jupiter", "Sun, Moon, Mars"}, 
    {"Ketu", "Mars, Venus", "Mercury, Jupiter, Saturn", "Sun, Moon"}  
};

    public PlanetaryFriendship() {
        JTable jt = new JTable(mat, colName);
    
        jt.getColumnModel().getColumn(0).setPreferredWidth(90);
        jt.getColumnModel().getColumn(1).setPreferredWidth(140);
        jt.getColumnModel().getColumn(2).setPreferredWidth(200);
        jt.getColumnModel().getColumn(3).setPreferredWidth(120);

        jt.setFillsViewportHeight(true);
        jt.setAutoCreateRowSorter(true);

        // jt.setPreferredSize(new Dimension(500, 200));

        JPanel p = new JPanel(new BorderLayout());
        p.add(new JScrollPane(jt), BorderLayout.NORTH);
        add(p);
        setBackground(Color.pink);
    }
    
}
