package nn.astro;

import java.util.HashMap;

public class Planets {

    private int number;
    private String name;
    private String color;
    private String nature;
    private String element;
    private String info;

    String natureContainer[] = {"movable", "fixed", "duel", "movable", "fixed", "duel", "movable", "fixed", "duel", "movable", "fixed", "duel"};
    String elementContainer[] = {"fire", "earth", "air", "water", "fire", "earth", "air", "water", "fire", "earth", "air", "water"};

    public Planets(String name, int number) {
        this.name = name;
        this.number = number;
        String clr = switch(this.name)
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
        this.color = clr;
        this.nature = natureContainer[number-1];
        this.element = elementContainer[number-1];

        String str = switch(name)
        {
            case "Sun" -> "orange, father king, slow, \nhonesty, politician,royality, \nfire, doctor, heart, head, acidity, \neight eye";
            case "Moon" -> "white, mother, food, water, \nkindness, nurse, mind and mental, \nbroncrities, numonia, insomia, husband";
            case "Mars" -> "general, tough, adament, red,\nmachinary, enginering, fever, \ndirriodia, brother, land, property";
            case "Mercury" -> "green greenery, talkative, \ndiluted, book, writing, reading, \nschool, baby nature, baby items, \nsister, hand, ear, arm";
            case "Jupiter" -> "yellow, teacher, god, temple, higher \nstudy, growth (cancer), jandice";
            case "Venus" -> "firoji, soild, filter, purify, \nskin disease, kidney, wife";
            case "Saturn" -> "black, aged person, laubour, \nbegger, servent, delay, bone, hair, \nfarmer property, job, teeth, leg";
            case "Rahu" -> "online, gadgets, big thinking, \nfocus anything, dart board, \nwind chimes, camera, hot drinks, \nupper portion of body, dirty";
            case "Ketu" -> "pale brown, small place, narrow, \nsecret, detach, lower portion of body, \nnature, meditation, yoga, cyst, \nback pain, low pressure";
            default -> "Invalid";
        };
        this.info = str;
    }

    
    @Override
    public String toString() {
        return "Planets [number=" + number + ", name=" + name + ", color=" + color + ", nature=" + nature + ", element="
                + element + ", info = " + info +"]\n";
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getNature() {
        return nature;
    }

    public String getElement() {
        return element;
    }

    public String getInfo() {
        return info;
    }
}
