import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Particle {
    private float x, y;       // Position
    private float vx, vy;     // Velocity
    private final int size = 5;

    public Particle() {
        x = (float) (Math.random() * 800); // Random initial position
        y = (float) (Math.random() * 600);
        vx = (float) (Math.random() * 4 - 2); // Random velocity
        vy = (float) (Math.random() * 4 - 2);
    }

    public void update() {
        x += vx;
        y += vy;

        // Bounce off edges
        if (x < 0 || x > 800 - size) vx = -vx;
        if (y < 0 || y > 600 - size) vy = -vy;
    }

    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillOval((int) x, (int) y, size, size);
    }
}

public class Test extends JPanel {

    private final ArrayList<Particle> particles = new ArrayList<>();

    public Test() {
        // Add some particles to start with
        for (int i = 0; i < 100; i++) {
            particles.add(new Particle());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Particle particle : particles) {
            particle.update(); // Update position
            particle.draw(g); // Draw particle
        }
        repaint(); // Schedule repaint for animation
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Particle Simulation");
        Test simulation = new Test();
        frame.add(simulation);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
