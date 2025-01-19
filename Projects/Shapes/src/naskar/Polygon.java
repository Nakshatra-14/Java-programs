package naskar;

import java.awt.*;

public class Polygon extends Shape{

    protected Point verts[];

    public Polygon(Color fillColor, Color bordColor, int xArr[], int yArr[])
    {
        super(fillColor, bordColor);
        verts = new Point[xArr.length];

        for(int i = 0 ; i < xArr.length ; i++)
        {
            verts[i] = new Point(xArr[i], yArr[i]);
        }
    }

    public float area()
    {
        return -2;
    }

    public void disp() 
    {
        super.disp();
        
        for (Point point : verts) {
            point.disp();
        }
    }
}
