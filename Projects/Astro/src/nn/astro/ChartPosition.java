package nn.astro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JPanel;

public class ChartPosition extends JPanel{

    private ArrayList<Planets> al = new ArrayList<>();

    public ChartPosition() {
        Planets.addPlanetsChartDetails(al);

        JPanel p = new MyPanel();
        p.setPreferredSize(new Dimension(500, 500));
        add(p);
    }

    class MyPanel extends JPanel
    {
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            int height = getHeight();
            int width = getWidth();
            // g.setColor(Color.BLUE);
            Chart.makeChart(g, height, width);
            addPlanetInChart(g, height, width);
        }

        public void addPlanetInChart(Graphics g, int height, int width)
        {
            int ymid = (height / 2);
            int xmid = (width / 2);

            g.drawString(al.get(0).getName(), xmid-15, ymid-180);
            g.drawString(al.get(1).getName(), 100, 75);
            g.drawString(al.get(2).getName(), 50, 130);
            g.drawString(al.get(11).getName(), 360, 75);
            g.drawString(al.get(10).getName(), 430, 130);

            g.drawString(al.get(4).getName(), 50, 380);
            g.drawString(al.get(5).getName(), 100, 440);
            g.drawString(al.get(7).getName(), 362, 430);
            g.drawString(al.get(8).getName(), 430, 380);

            g.drawString(al.get(3).getName(), xmid-180, ymid);
            g.drawString(al.get(9).getName(), xmid+160, ymid);
            g.drawString(al.get(6).getName(), xmid-15, ymid+180);

        }
    }

    
}
