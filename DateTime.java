import java.util.*;

public class DateTime {

    public static void printDate(GregorianCalendar dt) {
        int d = dt.get(Calendar.DAY_OF_MONTH);
        int m = dt.get(Calendar.MONTH) + 1;
        int y = dt.get(Calendar.YEAR);

        System.out.printf("%02d/%02d/%04d\n", d, m, y);
    }

    public static void printTime(GregorianCalendar dt) {
        int h = dt.get(Calendar.HOUR);
        int m = dt.get(Calendar.MINUTE);
        int s = dt.get(Calendar.SECOND);
        int meridian = dt.get(Calendar.AM_PM);
        String amPm;

        if (meridian == Calendar.AM)
            amPm = "am";
        else
            amPm = "pm";

        System.out.printf("%02d:%02d:%02d %s\n", h, m, s, amPm);

    }

    public static void printLongDate(GregorianCalendar dt) {
        int dow = dt.get(Calendar.DAY_OF_MONTH);
        String month[] = { "January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October",
                "November", "December" };
        String m = month[dt.get(Calendar.MONTH)];
        int y = dt.get(Calendar.YEAR);
        String[] daysOfWeek = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        String day = daysOfWeek[dt.get(Calendar.DAY_OF_WEEK)];
        String suffix = "th";
        int w = dow%10;

        if(dow >= 4 && dow <= 20)
            suffix = "th";
        else if(w == 1)
            suffix = "st";
        else if(w == 2)
            suffix = "nd";
        else if(w == 3)
            suffix = "rd";

        System.out.printf("%02d%s %s, %04d, %s", dow, suffix, m, y, day);    
    }

    public static int daysInMonth(int month, int year) {
        GregorianCalendar dt = new GregorianCalendar(year, month - 1, 1); //1st of given month
        dt.add(Calendar.MONTH, 1);  //Goto 1st of next month by adding 1 month
        dt.add(Calendar.DAY_OF_MONTH, -1); //Goto previous day, which is the last day of given month
        
        return dt.get(Calendar.DAY_OF_MONTH);
    }

    public static void main(String[] args) {
        GregorianCalendar dt = new GregorianCalendar(2024, Calendar.MARCH, 21);

        printDate(dt);
        printTime(dt);
        printLongDate(dt);
        System.out.println(daysInMonth(2, 2024));
    }
}
