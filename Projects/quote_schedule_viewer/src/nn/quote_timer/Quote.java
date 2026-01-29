package nn.quote_timer;

import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

import javax.swing.Timer;

public class Quote {

    private ArrayList<String> al = new ArrayList<>();

    public String getRandomQuote() {
        try (
                Scanner sc = new Scanner(new File("Quote.txt"));) {
            while (sc.hasNextLine())
                al.add(sc.nextLine());
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return al.get(new Random().nextInt(30));
    }

    public static void getQuoteArraylist(ArrayList<String> l)
    {
        try (
                Scanner sc = new Scanner(new File("Quote.txt"));
            ) {
            while (sc.hasNextLine())
                l.add(sc.nextLine());
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }


    // private static int i = 0;

    // public static void main(String[] args) {

    //     new Timer(86400000, _ -> {
    //         System.out.println(new QuoteTimer().getRandomQuote());
    //     }).start();

    //     new Scanner(System.in).next();
    // }
}
