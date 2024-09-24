import java.util.*;

public class Functions {

    public static int randInt(int lb, int ub) {
        return lb + (int) ((ub - lb + 1) * Math.random());
    }

    public static int[] genRandoms(int n, int lb, int ub) {
        int arr[], r, j;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            r = randInt(lb, ub);
            boolean f = false;
            for (j = 0; j < i; j++) {
                if (arr[j] == r) {
                    f = true;
                    break;
                }
            }

            if (f == true) {
                i--;
            } else
                arr[i] = r;
        }

        return arr;
    }

    public static void rightShift(int[] arr, int n) {
        for (int k = 1; k <= n; k++) {
            int e = arr[arr.length - 1];
            for (int i = arr.length - 1; i >= 1; i--) {
                arr[i] = arr[i - 1];
            }
            // System.arraycopy(arr, 0, arr, 1, n - 1);
            arr[0] = e;
        }
    }

    public static void leftShift(int[] arr, int n) {
        for (int k = 1; k <= n; k++) {
            int e = arr[0];
            for (int i = 1; i < arr.length; i++) {
                arr[i - 1] = arr[i];
            }
            arr[arr.length - 1] = e;
        }
    }

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
        // Testing random genrator
        // int n = 20, lb = 50, ub = 80;
        // int arr[] = genRandoms(n, lb, ub);
        // System.out.println(Arrays.toString(arr));
        // Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));

        // Testing Right Shift
        // int n = 20, lb = 50, ub = 80;
        // int arr[] = genRandoms(n, lb, ub);
        // System.out.println(Arrays.toString(arr));
        // rightShift(arr, 1);
        // System.out.println(Arrays.toString(arr));

        // Testing Left Shift
        // int n = 20, lb = 50, ub = 80;
        // int arr[] = genRandoms(n, lb, ub);
        // System.out.println(Arrays.toString(arr));
        // leftShift(arr, 4);
        // System.out.println(Arrays.toString(arr));

        printCalender(10, 2024);

    }
}
