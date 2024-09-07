import java.util.*;;

public class Calender {

    public static String month(int n) // Months
    {
        String m[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
        return m[n - 1];
    }

    // public static String day(int n) // Days
    // {
    //     String w[] = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
    //     return w[n - 1];
    // }

    public static int[] date(int month, int year) { // Dates
        int d[] = null;
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            d = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 };
        else if (month == 4 || month == 6 || month == 9 || month == 11)
            d = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 };
        else if (month == 2)                        // For February
            {
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
                    d = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29};
                else
                    d = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28 };
            }

            return d;
    }

    public static void calender(int month, int year) {
        int cal
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        String w[] = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
        System.out.print("Enter month no.: ");
        int month = inp.nextInt();
        System.out.print("Enter Year: ");
        int year = inp.nextInt();
        System.out.println(month(month));
        int d[] = date(month, year);
        for (String e : w) {
            System.out.print(e + "\t");
        }
        System.out.println();
        // for (int e : d) {
        //     System.out.print(e + "\t");
        // }

        calender(month, year);

    }
}