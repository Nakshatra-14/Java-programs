package nn.astro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GetPlanetChartDetails extends JPanel {

        private static List<Planets> al = new ArrayList<>();
        private JTextField txtPlace = new JTextField();
        private JTextField txtElement = new JTextField(20);
        private JTextField txtNature = new JTextField(20);
        private JLabel showColor = new JLabel();
        private JTextField txtBodyPart = new JTextField();
        private JTextField txtConstilation = new JTextField();
        private JTextArea txtArInfo = new JTextArea(4, 20);
        private JPanel p = new JPanel();

        public static String[] getPlanetNameChartStringArray() {
                ArrayList<String> l = new ArrayList<>();
                for (int i = 0; i < al.size() ; i++)
                        l.add(i + 1 + ": " + al.get(i).getName());
                return l.toArray(new String[al.size()]);
        }

        GetPlanetChartDetails() {
                showColor.setBackground(Color.pink);
                showColor.setOpaque(true);
                Planets.add9PlanetsChartDetails(al);

                showColor.setForeground(Color.DARK_GRAY);
                txtElement.setEditable(false);
                txtNature.setEditable(false);
                txtArInfo.setEditable(false);
                txtBodyPart.setEditable(false);
                txtConstilation.setEditable(false);
                txtPlace.setEditable(false);

                // JList<String> lst = new JList<>(getPlanetNameArray());
                JComboBox<String> cmdbox = new JComboBox<>(getPlanetNameChartStringArray());
                addActionListnerToComboBox(cmdbox);

                cmdbox.setSelectedIndex(0);

                
                addComponentToPlanetDetailsPanel(p, cmdbox, txtElement, txtNature, showColor, txtBodyPart,
                                txtConstilation, txtArInfo);
                this.add(p);
                setBackground(new Color(204, 250, 180));
        }

        public void addActionListnerToComboBox(JComboBox<String> cmdbox) {
                cmdbox.addActionListener(_ -> {
                        int n = cmdbox.getSelectedIndex();
                        // System.out.println(al.get(n));
                        String name = al.get(n).getName();
                        txtPlace.setText(String.valueOf(n));
                        txtElement.setText(al.get(n).getElement());
                        txtNature.setText(al.get(n).getNature());
                        showColor.setText(" ".repeat(16) + Planets.getPlanetColorString(name));
                        showColor.setBackground(Planets.getPlanetColour(name));
                        this.setBackground(Planets.getPlanetColour(name));
                        txtBodyPart.setText(Planets.getBodypartChartName(n + 1));
                        txtConstilation.setText(Planets.getConstilationChartName(n + 1));
                        txtArInfo.setText(al.get(n).getInfo());
                });
        }

        public void addComponentToPlanetDetailsPanel(JPanel p, JComboBox<String> cmdBox, JTextField txtElement,
                        JTextField txtNature,
                        JLabel txtColor, JTextField txtBodyPart, JTextField txtConst, JTextArea txtInfo) {
                p.setLayout(new GridBagLayout());
                Insets insets = new Insets(5, 5, 5, 5);

                GridBagConstraints gbc = new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
                                GridBagConstraints.BOTH, insets, 0, 0);
                p.add(cmdBox, gbc);

                gbc = new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
                                GridBagConstraints.HORIZONTAL, insets, 0, 0);
                p.add(new JLabel("Planet:"), gbc);

                gbc = new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
                                GridBagConstraints.HORIZONTAL, insets, 0, 0);
                p.add(new JLabel("Place:"), gbc);

                gbc = new GridBagConstraints(0, 2, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
                                GridBagConstraints.HORIZONTAL, insets, 0, 0);
                p.add(new JLabel("Element:"), gbc);

                gbc = new GridBagConstraints(0, 3, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
                                GridBagConstraints.HORIZONTAL,
                                insets, 0, 0);
                p.add(new JLabel("Nature:"), gbc);

                gbc = new GridBagConstraints(0, 4, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
                                GridBagConstraints.HORIZONTAL,
                                insets, 0, 0);
                p.add(new JLabel("Color:"), gbc);

                gbc = new GridBagConstraints(0, 5, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
                                GridBagConstraints.HORIZONTAL,
                                insets, 0, 0);
                p.add(new JLabel("Body parts:"), gbc);

                gbc = new GridBagConstraints(0, 6, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
                                GridBagConstraints.HORIZONTAL,
                                insets, 0, 0);
                p.add(new JLabel("Constellation:"), gbc);

                gbc = new GridBagConstraints(0, 7, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
                                GridBagConstraints.HORIZONTAL,
                                insets, 0, 0);
                p.add(new JLabel("Info:"), gbc);

                gbc = new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
                                GridBagConstraints.HORIZONTAL,
                                insets, 0, 0);
                p.add(txtPlace, gbc);

                gbc = new GridBagConstraints(1, 2, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
                                GridBagConstraints.HORIZONTAL,
                                insets, 0, 0);
                p.add(txtElement, gbc);

                gbc = new GridBagConstraints(1, 3, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
                                GridBagConstraints.HORIZONTAL,
                                insets, 0, 0);
                p.add(txtNature, gbc);

                gbc = new GridBagConstraints(1, 4, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
                                GridBagConstraints.HORIZONTAL,
                                insets, 0, 0);
                p.add(txtColor, gbc);

                gbc = new GridBagConstraints(1, 5, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
                                GridBagConstraints.HORIZONTAL,
                                insets, 0, 0);
                p.add(txtBodyPart, gbc);

                gbc = new GridBagConstraints(1, 6, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
                                GridBagConstraints.HORIZONTAL,
                                insets, 0, 0);
                p.add(txtConst, gbc);

                gbc = new GridBagConstraints(1, 7, 2, 1, 1.0, 1.0, GridBagConstraints.WEST,
                                GridBagConstraints.HORIZONTAL,
                                insets, 0, 0);
                p.add(txtInfo, gbc);
                p.setPreferredSize(new Dimension(420, 450));
        }

}
