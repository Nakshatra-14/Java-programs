package nn.gui;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Testing {

    public static void main(String[] args) {
        GregorianCalendar gc = new GregorianCalendar();
        // GregorianCalendar gc = new GregorianCalendar(Calendar.YEAR, Calendar.MONTH, 1);
        System.out.println(gc.get(Calendar.DATE));
        System.out.println(gc.get(Calendar.DAY_OF_MONTH));
        System.out.println(gc.getMaximum(Calendar.DAY_OF_MONTH));
        // System.out.println(gc.get(Calendar.DAY_OF_WEEK));
        // System.out.println(gc.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        // System.out.println(gc.get(Calendar.DAY_OF_YEAR));
        // System.out.println("\n");
        // System.out.println(gc.get(Calendar.MONTH));
        // System.out.println(gc.get(Calendar.WEEK_OF_MONTH));
        // System.out.println("\n");
        // System.out.println(gc.get(Calendar.YEAR));
        // System.out.println(gc.get(Calendar.WEEK_OF_YEAR));
        // System.out.println("\n");
        // System.out.println(gc.get(Calendar.HOUR));
        // System.out.println(gc.get(Calendar.HOUR_OF_DAY));
        // System.out.println("\n");
        // System.out.println(gc.get(Calendar.MINUTE));
        // System.out.println("\n");
        // System.out.println(gc.get(Calendar.SECOND));
        // System.out.println("\n");
        // System.out.println(gc.get(Calendar));
    }
}
