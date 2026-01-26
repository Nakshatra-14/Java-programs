package nn.astro;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

public class GetPlanetDetails extends JFrame{

    private static List<Planets> al = new ArrayList<>();

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

    public static String getPlanetColor(String name)
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

    public String getInfo(String name)
    {
        return switch(name)
        {
            case "Sun" -> "orange, father king, slow, honesty, politician, royality, fire, doctor, heart, head, acidity, eight eye";
            case "Moon" -> "white, mother, food, water, kindness, nurse, mind and mental, broncrities, numonia, insomia, husband";
            case "Mars" -> "general, tough, adament, red, machinary, enginering, fever, dirriodia, brother, land, property";
            case "Mercury" -> "green greenery, talkative, diluted, book, writing, reading, school, baby nature, baby items, sister, hand, ear, arm";
            case "Jupiter" -> "yellow, teacher, god, temple, higher study, growth (cancer), jandice";
            case "Venus" -> "firoji, soild, filter, purify, skin disease, kidney, wife";
            case "Saturn" -> "black, aged person, laubour, begger, servent, delay, bone, hair, farmer property, job, teeth, leg";
            case "Rahu" -> "online, gadgets, big thinking, focus anything, dart board, wind chimes, camera, hot drinks, upper portion of body, dirty";
            case "Ketu" -> "pale brown, small place, narrow, secret, detach, lower portion of body, nature, meditation, yoga, cyst, back pain, low pressure";
            default -> "Invalid";
        };
    }

    public static void addPlanetsDetails()
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

    // GetPlanetDetails()
    // {
    //     this.setTitle("Get Planet details");
    //     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //     this.add(new JButton("Helloo"));
    // }

    // public static void main(String[] args) {
    //     var app = new GetPlanetDetails();
    //     app.pack();
    //     app.setLocationRelativeTo(null);
    //     app.setVisible(true);
    // }

    public static void main(String[] args) {
        addPlanetsDetails();
        System.out.println(al);
    }
}
