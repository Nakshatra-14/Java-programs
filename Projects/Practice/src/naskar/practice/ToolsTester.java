package naskar.practice;

import java.util.Calendar;
import java.util.GregorianCalendar;

import naskar.tools.DateTime;
import naskar.tools.Stack;

public class ToolsTester {
    public static void main(String[] args) {
        Stack s = new Stack();

        s.push(20);
        s.push(65);
        s.disp();

        GregorianCalendar dt = new GregorianCalendar(1920, Calendar.MARCH, 25);
        DateTimeTest.printLongDate(dt);
    }
}
