import java.util.StringJoiner;

public class CircularQueue<E> implements Queue<E> {

    private E arr[];
    private int front;
    private int rear;
    private int size;

    public CircularQueue() {
        this(10);
    }

    public CircularQueue(int n) {
        arr = (E[]) new Object[n];
        front = 0;
        rear = -1;
        size = 0;
        System.out.println("CirQueue");
    }

    public int size() {
        return size;
    }

    private void adjustCapacity() {
        if (isFull()) {

            E tmp[] = (E[]) new Object[2 * arr.length];
            // int tmp[] = new int[2 * arr.length];

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

    public void insert(E e) {
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

    public E delete() {
        if (isEmpty())
            System.out.println("Error! Queue is empty");
        else {
            E n = arr[front];
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
