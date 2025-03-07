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

    public Point copy()
    {
        return new Point(x, y);
    }

    @Override
    public String toString() {
        String result = "(" + x + ", " + y + ")";
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Point p && p.x == this.x && p.y == this.y;
    }
}
