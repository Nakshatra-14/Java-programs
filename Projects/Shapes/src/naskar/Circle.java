package naskar;

import java.awt.Color;

public class Circle extends Shape{

    private int radius;

    public Circle(Color fillColor, Color bordColor, int radius)
    {
        super(fillColor, bordColor);
        this.radius = radius;
    }

    public float area()
    {
        return (float)(Math.PI * radius * radius);
    }

}
