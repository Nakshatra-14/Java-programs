package naskar;


public class Point {
    
    int x, y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public double distanceFrom(Point p)
    {
        int x1 = this.x, x2 = p.x;
        int y1 = this.y, y2 = p.y;

        return Math.sqrt((x1 - y1)*(x1 - y1) + (x2 - y2)*(x2 - y2));

    }

    public void disp()
    {
        System.out.println( x + ", " + y );
    }
}
