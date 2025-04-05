package nn.interfacing;

import java.util.Comparator;

public class Point implements Comparable {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Object b) {
        if (b instanceof Point p)
            return -(this.x - p.x);
        else
            return 0; // wont execute this statement
    }

    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + "]";
    }

    static class PointComparatorByY implements Comparator {

        @Override
        public int compare(Object a, Object b) {
            if (a instanceof Point p && b instanceof Point q)
                return p.y - q.y;
            else
                return 0;
        }

    }

    static class PointComparatorByYDesc implements Comparator {

        @Override
        public int compare(Object a, Object b) {
            if(a instanceof Point p && b instanceof Point q)
                return -(p.y - q.y);
            else
                return 0;  
        }
    
    }

}
