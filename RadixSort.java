import java.util.StringJoiner;

public class RadixSort {

    public static void radixSort(int ar[]) {
        final int RADIX = 10;
        final int MAX_DIGIT = 9;

        int max = ar[0];

        for (int i = 0; i < ar.length; i++)
            if (ar[i] > max)
                max = ar[i];

        int digit = String.valueOf(max).length();

        CirQueue<Integer> qar[] = new CirQueue[RADIX];

        for (int i = 0; i < RADIX; i++)
            qar[i] = new CirQueue<>();

        int mod = 10;
        for (int i = 0; i < digit; i++) {
            for (int j = 0; j < ar.length; j++) {
                int num = ar[i] % mod;

                if (num == 0)
                    qar[0].insert(num);

                else if (num == 1)
                    qar[1].insert(num);

                else if (num == 2)
                    qar[2].insert(num);

                else if (num == 3)
                    qar[3].insert(num);

                else if (num == 4)
                    qar[4].insert(num);

                else if (num == 5)
                    qar[5].insert(num);

                else if (num == 6)
                    qar[6].insert(num);

                else if (num == 7)
                    qar[7].insert(num);

                else if (num == 8)
                    qar[8].insert(num);

                else
                    qar[9].insert(num);

            }
            
            for(int j = 0 ; j < qar.length ; j++)
            {
                for(int k = 0 ; k < 10 ; k++)
                {
                    ar[k] = qar[j].remove();
                    if(qar[j].isEmpty())
                        break;
                }
            }

            mod *= 10;
        }
        for(int i = 0 ; i < ar.length ; i++)
            System.out.println(ar[i] + ", ");
    }

    public static void main(String[] args) {

        int[] arr = {245, 678, 913, 357, 802, 431, 129, 764, 590, 386, 271, 648};

        radixSort(arr);

    }
}

class CirQueue<T> {
    private T arr[];
    private int front;
    private int rear;
    private int size;

    public CirQueue() {
        this(10);
    }

    public CirQueue(int n) {
        arr = (T[]) new Object[n];
        front = 0;
        rear = -1;
        size = 0;
    }

    public int size() {
        return size;
    }

    private void adjustCapacity() {
        if (isFull()) {

            T tmp[] = (T[]) new Object[2 * arr.length];

            if (front <= rear) {
                for (int i = front; i <= rear; i++) {
                    tmp[i] = arr[i];
                }
            }

            else {
                int n = 0;
                for (int i = front; i < arr.length; i++) {
                    tmp[n] = arr[i];
                    n++;
                }

                for (int i = 0; i <= rear; i++) {
                    tmp[n] = arr[i];
                    n++;
                }

            }

            arr = tmp;
            front = 0;
            rear = size - 1;
        }

    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return arr.length == size;
    }

    public void insert(T e) {
        adjustCapacity();
        if (isFull())
            System.out.println("Error! Queue is full");
        else {
            // rear++;
            // if (rear == arr.length)
            // rear = 0;
            // OR
            rear = (rear + 1) % arr.length;

            arr[rear] = e;
            size++;
        }
    }

    public T remove() {
        if (isEmpty())
            System.out.println("Error! Queue is empty");
        else {
            T n = arr[front];
            front = (front + 1) % arr.length;
            size--;
            return n;
        }
        return null;
    }

    @Override
    public String toString() {

        if (isEmpty())
            return "()";

        var sj = new StringJoiner(", ", "(", ")");

        if (front <= rear) {
            for (int i = front; i <= rear; i++) {
                sj.add(arr[i].toString());
            }
            String result = sj.toString();
            return result;
        }

        else {
            for (int i = front; i < arr.length; i++) {
                sj.add(arr[i].toString());
            }

            for (int i = 0; i <= rear; i++) {
                sj.add(arr[i].toString());
            }
            String result = sj.toString();
            return result;
        }

    }
}
