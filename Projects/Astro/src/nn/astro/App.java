package nn.astro;

import java.awt.HeadlessException;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;



public class App extends JFrame {

    public App() {
        this.setTitle("AstroApp");

        JTabbedPane jTabbedPane = new JTabbedPane();

        jTabbedPane.addTab("Chart Position", new ChartPosition());
        jTabbedPane.addTab("Planet Chart Details", new GetPlanetChartDetails());
        jTabbedPane.addTab("Planetary Friendship", new PlanetaryFriendship());

        this.add(jTabbedPane);
    }

    public static void main(String[] args) {
        var app = new App();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.pack();
        app.setLocationRelativeTo(null);
        app.setVisible(true);
    }
}
