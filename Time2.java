import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time2 {
    public static void main(String[] args) {
        
        // System.out.println("Time from 1 Jan 1900:");
        // System.out.println(System.currentTimeMillis() / 1000 + " milliseconds");
        // System.out.println(System.currentTimeMillis() / 1000 / 3600 / 24 + " days");
        // System.out.println(System.currentTimeMillis() / 1000 / 3600 / 24 / 7 + " weeks");
        // System.out.println(System.currentTimeMillis() / 1000 / 3600 / 24 / 30 + " months");
        // System.out.println(System.currentTimeMillis() / 1000 / 3600 / 24 / 365 + " years");


        LocalDateTime dt = LocalDateTime.now();                                         //Date
        // System.out.println(dt);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");       //Formatter
        String date = dt.format(df);                                                    //Creating Date using Date and Formatter
        System.out.println(date);

        DateTimeFormatter df2 = DateTimeFormatter.ISO_LOCAL_DATE;
        date = dt.format(df2);
        System.out.println(date);


        LocalDate today = LocalDate.now();
        LocalDate nextWeek = today.plusWeeks(1);
        LocalDate lastMonth = today.minusMonths(1);
        
        System.out.println("Today: " + today);
        System.out.println("Next week: " + nextWeek);
        System.out.println("Last month: " + lastMonth);
    }
}
