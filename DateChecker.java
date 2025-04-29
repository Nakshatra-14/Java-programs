import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class DateChecker {

    // public static boolean areAllDigits(String str)
    // {
    //    for(int i = 0 ; i < str.length() ; i++)
    //    {
    //     if(!Character.isDigit(str.charAt(i)))
    //         return false;
    //    }

    //     return !str.isEmpty();
    // }

    // public static boolean isValidDate(String dt)
    // {
    //     boolean valid = false;

    //     if(dt.length() == 10)
    //     {
    //         if((dt.charAt(2) == '/' && dt.charAt(5) == '/') || (dt.charAt(2) == '-' && dt.charAt(5) == '-'))
    //         {
    //             String d = dt.substring(0, 2);
    //             String m = dt.substring(3, 5);
    //             String y = dt.substring(6, 10);

    //             String str = d + m + y;


    //                     // if(Character.isDigit(d.charAt(0)) == true && Character.isDigit(d.charAt(1)) == true)
    //                     //     if(Character.isDigit(m.charAt(0)) == true && Character.isDigit(m.charAt(1)) == true)
    //                     //         if(Character.isDigit(y.charAt(0)) && Character.isDigit(y.charAt(1)) && Character.isDigit(y.charAt(2)) && Character.isDigit(y.charAt(3)))
    //                         if(areAllDigits(str))
    //                                 {
    //                                     int month[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    //                                     int theMonth = Integer.parseInt(m);
    //                                     if(theMonth >= 1 && theMonth <= 12)
    //                                     {
    //                                         int totalDays = month[theMonth - 1];
    //                                         int day = Integer.parseInt(d);
    //                                         if(day >= 1 && day <= totalDays)
    //                                             valid = true;
    //                                     }
    //                                 }
                
    //         }
            

    //     }

    //     return valid;
    // } 

    public static boolean isValidDate(String str)
    {
        String pattern1 = "dd/MM/yyyy";
        String pattern2 = "dd-MM-yyyy";

        SimpleDateFormat sdf1 = new SimpleDateFormat(pattern1);
        SimpleDateFormat sdf2 = new SimpleDateFormat(pattern2);

        Date dt1 = null, dt2 = null;
            try {
                dt1 = sdf1.parse(str);
                return true;
            } catch (ParseException e) {

            }

            try {
                dt2 = sdf2.parse(str);
                return true;
            } catch (ParseException e) {

            }

            return false;

    }

    public static void main(String[] args) {
        // Scanner inp = new Scanner(System.in);
        // System.out.println("Enter date: ");
        // String dt = inp.nextLine();

        String date[] = {"03.10.1992", "03/mar/1992", "25/12/1998" , "25-12-1998"};

        // String dt = "10/25/1998";

        // System.out.println(dt);
        // System.out.println(dt.substring(0, 2));
        // System.out.println(dt.substring(3, 5));
        // System.out.println(dt.substring(6));

        for(int i = 0 ; i < date.length ; i++)
        {
            System.out.print(date[i] + ": ");
            // System.out.println(date[i].substring(6,10));
            System.out.println(isValidDate(date[i]));
        }

        // System.out.println(areAllDigits(""));

        // System.out.println(isValidDate("25-12-1998"));
    }
}