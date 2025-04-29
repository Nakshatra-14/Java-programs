package naskar.exceptions.stack;

import java.util.Arrays;

public class Main {

     public static void main(String[] args) {
        int ar[] = {25, 82, 63, 54, 39, 12};
        
        System.out.println("Before Reverse:" + Arrays.toString(ar));

        try {
            StackTest.reverseArray(ar);
        } catch (ArrayReversalException e) {
            System.out.println("Error occured in reversing array: " + e.getMessage() + " (" + e.getCause().getMessage() + ")");
            e.printStackTrace();
        }

        System.out.println("After  Reverse:" + Arrays.toString(ar));

    }

}
