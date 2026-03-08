
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Random;
import java.util.function.Function;

public class RadixSort<T> {

    public void radixSort(int data[])
    {
        if(data.length == 0)
            return;

        final int maxDigits = 9;
        final int radix = 10;
        // for(int n : data)
        //     if(max < n)
        //         max = n;

        // int n = 0;
        // while(max != 0)
        // {
        //     max /= 10;
        //     n++;
        // }

        Queue<Integer> queueAr[] = new Queue[radix];
        for(int i = 0 ; i < radix; i ++)
            queueAr[i] = new ArrayDeque<Integer>();
        
        for(int i = 0 ; i < maxDigits ; i++)
        {
            for(int j = 0 ; j < data.length ; j++)
            {
                int num = data[j];
                //ith right digit of num
                //d = (num / 10^i) % 10
                int d = (num / Math.powExact(10, i)) % 10;

                //put d into the d'th queue
                queueAr[d].add(num);
            }

            //take back all the elements from the queue, one by one
            int k = 0;
            for(Queue<Integer> q : queueAr)
            {
                while(!q.isEmpty())
                {
                    data[k] = q.remove();
                    k++;
                }
            }

        }
    }
    
    void main()
    {
        // int arr[] = {222, 487, 105, 536, 965, 265};
        Random rnd = new Random();
        int n = 100;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rnd.nextInt(10000, 99999);
        }
        System.out.println(Arrays.toString(arr));
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
