public class Calender {
    public static boolean isLeapYear(int n) {
        if ((n % 4 == 0 && n % 100 != 0) || n % 400 == 0)
            return true;
        else
            return false;
    }

    public static int daysBetween(int yearFrom, int yearTo) {
        int n = 0;
        for (int y = yearFrom; y <= yearTo; y++) {
            if (isLeapYear(y) == true)
                n++;
        }
        int day = (yearTo - yearFrom + 1) * 365 + n;
        return day;
    }

    public static void printCalender(int month, int year) {
        final int epochYear = 1900;
        final int epochDOW = 1; // Jan 1, 1900 was Monday
        String months[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
        String weekDays[] = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };

        int n = daysBetween(epochYear, year - 1);
        // Adding no. of days elapsed in the given year until given month
        int mDays[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (isLeapYear(year) == true)
            mDays[1] = 29;
        for (int i = 0; i < month - 1; i++)
            n += mDays[i];

        // Calculate DOW for first of given month
        int w = (epochDOW + n % 7) % 7;

        System.out.println(months[month - 1] + ", " + year);

        for (String e : weekDays) {
            System.out.print(e + " ");
        }
        System.out.println();

        for (int p = 0; p < w; p++) {
            System.out.print("    ");
        }

        n = mDays[month - 1];
        for (int i = 1; i <= n; i++) {
            System.out.printf("%2d  ", i);
            w++;
            if (w % 7 == 0)
                System.out.println();
        }
    }

    public static void main(String[] args) {
        // printCalender(10, 2024);
        int year = 2024;
        System.out.println("Calender of year " + year);

        for(int i = 1 ; i <= 12 ; i++)
        {
            printCalender(i, year);
            System.out.println("\n\n");
        }
    }
}
