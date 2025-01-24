
import java.awt.Color;
import naskar.Circle;
import naskar.Rectangle;
import naskar.Shape;
import naskar.Square;
import naskar.Triangle;

public class Main {
    public static void main(String[] args) {

        Shape sar[] = new Shape[4];

        sar[0] = new Circle(Color.yellow, Color.gray, 20); // set fill color, border color and radius

        sar[1] = new Triangle(Color.white, Color.cyan, 23, 55, 74, 12, 36, 93); // set fill color, border color, x1, y1,
                                                                                // x2, y2, x3, y3
        sar[2] = new Rectangle(Color.green, Color.red, 62, 76, 30, 16); // set fill color, border color, left, top,
                                                                        // width, height
        sar[3] = new Square(Color.green, Color.red, 62, 76, 40); // set fill color, border color, left, top, side

        for (Shape s : sar) {
            // s.disp();
            System.out.println(s);
            //System.out.println("Area = " + s.area());
        }
    }
}
