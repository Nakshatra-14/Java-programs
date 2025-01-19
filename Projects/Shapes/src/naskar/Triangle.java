package naskar;

import java.awt.*;

public class Triangle extends Polygon{

    public Triangle(Color fillColor, Color bordColor, int x1, int y1, int x2, int y2, int x3, int y3)
    {
        super(fillColor, bordColor, new int[] {x1, x2, x3}, new int[] {y1, y2, y3});
    }

    public float area()
    {
        double a = verts[0].distanceFrom(verts[1]);
        double b = verts[1].distanceFrom(verts[2]);
        double c = verts[2].distanceFrom(verts[0]);

        double s = (a+b+c)/2;
        return (float)(Math.sqrt(s * (s - a) * (s - b) * (s - c)));
    }

    // no disp() is requried becz the disp() of polygon is sufficient, which prints all the vertices
}
