package naskar;

import java.awt.*;
import java.util.StringJoiner;

public abstract class Polygon extends Shape{
    
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


    // @Override
    // public String toString() {
    //     String result =  super.toString() + ", Vertices: {";
    //     for(int i = 0 ; i < verts.length ; i++)
    //     {
    //         if(i != 0)
    //             result += ", ";
    //         result += verts[i];
    //     }
    //     result += "}";
    //     return result;
    // }

    //Vertices: (...)

    @Override
    public String toString() {
        // var sb = new StringBuilder(super.toString());
        // sb.append(", Vertices: (");
        // for(int i = 0 ; i < verts.length; i++)
        // {
        //     if(i != 0)
        //         sb.append(", ");
        //     sb.append(verts[i]);
        // }
        // sb.append(')');
        
        //return sb.toString();

        var sj = new StringJoiner(", ", super.toString() + ", Vertices: (", ")");
        for(int i = 0 ; i < verts.length ; i++)
        {
            sj.add(verts[i].toString());
        }
        return sj.toString();
    }
}
