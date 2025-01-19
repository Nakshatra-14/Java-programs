package naskar;

import java.awt.*;

public class Rectangle extends Polygon{

    private int height, width;

    public Rectangle(Color fillColor, Color bordColor, int left, int top, int height, int width)
    {
        super(fillColor, bordColor, new int[] {left, left+width, left+width-1, (left+width-1)-width}, new int[] {top, top, top+height-1, top+height-1});
        this.height = height;
        this.width  = width;
    }

    public float area()
    {
        return height * width;
    }
}
