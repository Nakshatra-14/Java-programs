package naskar;

import java.awt.Color;

public abstract class Shape {

    private Color fillColor;
    private Color bordColor;

    // public Shape()
    // {
    //     fillColor = Color.red;
    //     bordColor = Color.green;
    // }

    private static String colorString(Color color)
    {
         return "(" + "r:" + color.getRed() + ", g:" + color.getGreen() + ", b:" + color.getBlue() + ")";
    }

    public Shape(Color fillColor, Color bordColor)
    {
        this.fillColor = fillColor ;
        this.bordColor = bordColor ;
    }

    public abstract float area();

   @Override
   public String toString() {
       String result = "Fill Color: " + colorString(fillColor) + ", Border Color: " + colorString(bordColor);
       return result;
   }

}
