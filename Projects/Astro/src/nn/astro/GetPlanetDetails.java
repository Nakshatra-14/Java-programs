package nn.astro;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GetPlanetDetails extends JFrame{

    private List<Planets> al = new ArrayList<>();
    private JTextField txtElement = new JTextField(20);
    private JTextField txtNature = new JTextField(20);
    private JLabel showColor = new JLabel("  Hello                                  ");
    private JTextArea txtArInfo = new JTextArea(4, 20);
 
    public static String getPlanetName(int n)
    {
        return switch (n) {
            case 1 -> "Sun";
            case 2 -> "Moon";
            case 3 -> "Mars";
            case 4 -> "Mercury";
            case 5 -> "Jupiter";
            case 6 -> "Venus";
            case 7 -> "Saturn";
            case 8 -> "Rahu";
            case 9 -> "Ketu";
            default -> "invalid";
        };
    }

    public static String getPlanetColorString(String name)
    {
        return switch(name)
        {
            case "Sun" -> "Orange";
            case "Moon" -> "White";
            case "Mars" -> "Red";
            case "Mercury" -> "Green";
            case "Jupiter" -> "Yellow";
            case "Venus" -> "Firoji";
            case "Saturn" -> "Black";
            case "Rahu" -> "Grey";
            case "Ketu" -> "Pale Brown";
            default -> "invalid";
        };
    }

    public void addPlanetsChartDetails()
    {
        al.add(new Planets(getPlanetName(3), 1));
        al.add(new Planets(getPlanetName(6), 2));
        al.add(new Planets(getPlanetName(4), 3));
        al.add(new Planets(getPlanetName(2), 4));
        al.add(new Planets(getPlanetName(1), 5));
        al.add(new Planets(getPlanetName(4), 6));
        al.add(new Planets(getPlanetName(6), 7));
        al.add(new Planets(getPlanetName(3), 8));
        al.add(new Planets(getPlanetName(5), 9));
        al.add(new Planets(getPlanetName(7), 10));
        al.add(new Planets(getPlanetName(7), 11));
        al.add(new Planets(getPlanetName(5), 12));
    }

    public String[] getPlanetNameArray()
    {
        ArrayList<String> l = new ArrayList<>();
        for(int i = 0 ; i < 12 ; i++)
            l.add(i+1 + ": " + al.get(i).getName());
        return l.toArray(new String[al.size()]);
    }

    GetPlanetDetails()
    {
        this.setTitle("Get Planet details");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        showColor.setBackground(Color.pink);
        showColor.setOpaque(true);
        addPlanetsChartDetails();

        // JList<String> lst = new JList<>(getPlanetNameArray());
        JComboBox<String> cmdbox= new JComboBox<>(getPlanetNameArray());
        addActionListnerToComboBox(cmdbox);

        cmdbox.setSelectedIndex(0);

        JPanel p = new JPanel();
        addComponentToPanel(p, cmdbox, new JLabel("Element:"), new JLabel("Nature:"), new JLabel("Color:"), new JLabel("Info"), txtElement, txtNature, showColor, txtArInfo);
        this.add(p);
    }

    public static void main(String[] args) {
        var app = new GetPlanetDetails();
        app.pack();
        app.setLocationRelativeTo(null);
        app.setVisible(true);
    }

    public Color getPlanetColour(String name)
    {
        return switch(name)
        {
            case "Sun" -> Color.ORANGE;
            case "Moon" -> Color.WHITE;
            case "Mars" -> Color.RED;
            case "Mercury" -> Color.GREEN;
            case "Jupiter" -> Color.YELLOW;
            case "Venus" -> new Color(0, 168, 173);
            case "Saturn" -> Color.BLACK;
            case "Rahu" -> Color.GRAY;
            case "Ketu" -> new Color(152, 118, 84);
            default -> Color.pink;
        };
    }

    public void addActionListnerToComboBox(JComboBox<String> cmdbox)
    {
        cmdbox.addActionListener( _ -> {
            int n = cmdbox.getSelectedIndex();
            System.out.println(al.get(n));
            String name = al.get(n).getName();
            txtElement.setText(al.get(n).getElement());
            txtNature.setText(al.get(n).getNature());
            showColor.setText(" ".repeat(8) + getPlanetColorString(name) + " ".repeat(8));
            showColor.setBackground(getPlanetColour(name));
            txtArInfo.setText(al.get(n).getInfo());
        });
    }



    public void addComponentToPanel(JPanel p, JComboBox<String> cmdBox, JLabel lblElement, JLabel lblNature, JLabel lblColor, JLabel lblInfo, JTextField txtElement, JTextField txtNature, JLabel txtColor, JTextArea txtInfo)
    {
        p.setLayout(new GridBagLayout());
        Insets insets = new Insets(5,5, 5, 5);

        GridBagConstraints gbc = new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0);
        p.add(cmdBox, gbc);

        gbc = new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.EAST, insets, 0, 0);
        p.add(lblElement, gbc);

        gbc = new GridBagConstraints(0, 2, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.EAST, insets, 0, 0);
        p.add(lblNature, gbc);

        gbc = new GridBagConstraints(0, 3, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.EAST, insets, 0, 0);
        p.add(lblColor, gbc);

        gbc = new GridBagConstraints(0, 4, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.NONE, insets, 0, 0);
        p.add(lblInfo, gbc);

        gbc = new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.EAST, insets, 0, 0);
        p.add(txtElement, gbc);

        gbc = new GridBagConstraints(1, 2, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.EAST, insets, 0, 0);
        p.add(txtNature, gbc);

        gbc = new GridBagConstraints(1, 3, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.EAST, insets, 0, 0);
        p.add(txtColor, gbc);

        gbc = new GridBagConstraints(1, 4, 2, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.EAST, insets, 0, 0);
        p.add(txtInfo, gbc);

    }

}
