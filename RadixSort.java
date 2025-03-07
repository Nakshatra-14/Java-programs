import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringJoiner;

public class RadixSort {

    public static void radixSort(int ar[]) {
        final int RADIX = 10;
        // final int MAX_DIGIT = 9;
        
        int max = ar[0];

        for (int i = 0; i < ar.length; i++)
            if (ar[i] > max)
                max = ar[i];

        int maxDigits = String.valueOf(max).length();
        maxDigits = 5;
        CirQueueModified<Integer> qar[] = new CirQueueModified[RADIX];

        for (int i = 0; i < RADIX; i++)
            qar[i] = new CirQueueModified<>();

        int divisor = 1;
        for (int i = 0; i < maxDigits; i++) {
            for (int j = 0; j < ar.length; j++) {
                int d = (ar[j] / divisor) % 10;

                qar[d].insert(ar[j]);

            }

            int k = 0;
            for (int j = 0; j < qar.length; j++) {
                while (!qar[j].isEmpty()) {
                    ar[k] = qar[j].remove();
                    k++;
                }
            }

            divisor *= 10;
        }
    }

    public static void main(String[] args) {

        int[] arr = { 245, 678, 913, 357, 802, 431, 129, 764, 590, 386, 271, 648 };

        // System.out.println("Before Sort:");
        System.out.println(Arrays.toString(arr));

        radixSort(arr);

        System.out.println(Arrays.toString(arr));

    }
}