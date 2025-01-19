package naskar;

import java.awt.Color;

public class Square extends Rectangle{

    private float side;

    public Square(Color fillColor, Color bordColor, int top, int left, int side)
    {
        super(fillColor, bordColor, top, left, side, side);
        this.side = side;
    }

    public float area()
    {
        return side * side;
    }
}
