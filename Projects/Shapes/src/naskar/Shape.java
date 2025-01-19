package naskar;

import java.awt.Color;

public class Shape {

    private Color fillColor;
    private Color bordColor;

    // public Shape()
    // {
    //     fillColor = Color.red;
    //     bordColor = Color.green;
    // }

    public Shape(Color fillColor, Color bordColor)
    {
        this.fillColor = fillColor ;
        this.bordColor = bordColor ;
    }

    public float area()
    {
        return -1;
    }

    public void disp()
    {
       System.out.println(fillColor + ", " + bordColor) ;
    }
}
