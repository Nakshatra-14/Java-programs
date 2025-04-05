package nn.interfacing;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Point points[] = new Point[5];

        points[0] = new Point(5, 9);
        points[1] = new Point(8, 3);
        points[2] = new Point(3, 7);
        points[3] = new Point(4, 2);
        points[4] = new Point(7, 5);

        System.out.println(Arrays.toString(points));

        Arrays.sort(points);

        System.out.println(Arrays.toString(points));

        Comparator comp = new Point.PointComparatorByY();
        Arrays.sort(points, comp);

        System.out.println(Arrays.toString(points));

        comp = new Point.PointComparatorByYDesc();
        Arrays.sort(points, comp);
        
        System.out.println(Arrays.toString(points));

        // Arrays.sort(points, new Comparator() {
        //     public int compare(Object a, Object b)
        //     {
        //         if(a instanceof Point p && b instanceof Point q)
        //             return p.x * p.y - q.x * q.y;
        //     }
        // });
        
        String months[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        Arrays.sort(months);
        System.out.println(Arrays.toString(months));

        // comp = new StringComparatorByLen();
        // Arrays.sort(months, comp);
        // Arrays.sort(months, new StringComparatorByLen());
        Arrays.sort(months, new Comparator() {
            @Override
            public int compare(Object a, Object b) {
                if (a instanceof String p && b instanceof String q)
                    return (p.length() - q.length());
                else
                    return 0;
            }
        });
        System.out.println(Arrays.toString(months));
        // for(int i = 0 ; i < 5 ; i++)
        // System.out.print(points[i]+ ", ");

    }
}
