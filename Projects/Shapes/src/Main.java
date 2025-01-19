
import java.awt.Color;
import naskar.Circle;
import naskar.Polygon;
import naskar.Rectangle;
import naskar.Shape;
import naskar.Square;
import naskar.Triangle;

public class Main {
    public static void main(String[] args) {

        Shape sar[] = new Shape[6];

        sar[0] = new Shape(Color.blue, Color.red); // set fill color, borderr color and radius

        sar[1] = new Circle(Color.yellow, Color.gray, 20); // set fill color, border color and radius

        sar[2] = new Polygon(Color.black, Color.white, new int[] { 23, 64, 75, 35, 43 }, new int[] { 95, 35, 46, 78, 60 }); // set fill color, border color, x-ordinates, y-ordinates

        sar[3] = new Triangle(Color.white, Color.cyan, 23, 55, 74, 12, 36, 93); // set fill color, border color, x1, y1,
                                                                                // x2, y2, x3, y3
        sar[4] = new Rectangle(Color.green, Color.red, 62, 76, 30, 16); // set fill color, border color, left, top,
                                                                        // width, height
        sar[5] = new Square(Color.green, Color.red, 62, 76, 40); // set fill color, border color, left, top, side

        for (Shape s : sar) {
            s.disp();
            System.out.println("Area = " + s.area());
        }
    }
}
