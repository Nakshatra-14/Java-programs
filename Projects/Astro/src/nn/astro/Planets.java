package nn.astro;

import java.util.HashMap;

public class Planets {

    private int number;
    private String name;
    private String color;
    private String nature;
    private String element;
    private String bodyPart;
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
    }

    
    @Override
    public String toString() {
        return "Planets [number=" + number + ", name=" + name + ", color=" + color + ", nature=" + nature + ", element="
                + element + "]\n";
    }
}
