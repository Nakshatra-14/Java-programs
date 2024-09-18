import java.util.*;

public class CalenderPrinter {

    public static int linearSearch(String ar[], String element)
    {
        for (int i = 0 ; i < ar.length ; i++) 
        {
            if(ar[i].equalsIgnoreCase(element))
                return i;
        }
        return -1;
    }

    public static boolean isLeapYear(int n)
    {
        if((n % 4 == 0 && n % 100 != 0) || n % 400 == 0)
            return true;
        else
            return false;    
    }

    public static int daysElaspsed(int d, int m, int y)
    {
        return 0;
    }
    
    public static int daysBetween(int yearOld, int yearNew) //Returns no. of days from year old upto year new
    {
        return yearOld ;
    }

    // public static int[] date(int month, int year) { // Dates
    //     int d[] = null;
    //     if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
    //         d = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 };
    //     else if (month == 4 || month == 6 || month == 9 || month == 11)
    //         d = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 };
    //     else if (month == 2)                        // For February
    //         {
    //             if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
    //                 d = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29};
    //             else
    //                 d = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28 };
    //         }

    //         return d;
    // }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String months[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
        String weekDays[] = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
        
        System.out.print("Enter month name.: ");
        String monthName = inp.next();
        int m = linearSearch(months, monthName);
        
        System.out.print("Enter Year: ");
        int year = inp.nextInt();
        int mDays[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(isLeapYear(year))
            mDays[1] = 29;
        
        System.out.printf("Day of the week of 1st of %s, %d: ", months[m], year);
        String fWeekDay = inp.next();
        int w = linearSearch(weekDays, fWeekDay.substring(0, 3));
        System.out.println(months[m] + ", " + year);
        
        for (String e : weekDays) {
            System.out.print(e + " ");
        }
        System.out.println();

        for(int p = 0 ; p < w ; p++)
        {
            System.out.print("    ");
        }

        int n = mDays[m];
        for(int i = 1 ; i <= n ; i++)
        {
            System.out.printf("%2d  ", i);
            w++;
            if(w%7 == 0)
                System.out.println();
        }

        //System.out.println(month(month));
        
        // for (String e : w) {
        //     System.out.print(e + "\t");
        // }
        // System.out.println();

        // int d[] = date(month, year);
        // for (int e : d) {
        //     System.out.print(e + "\t");
        // }

        // calender(month, year);

    }
}