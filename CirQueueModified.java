import java.util.StringJoiner;

public class CirQueueModified<T> {
    private T arr[];
    private int front;
    private int rear;
    private int size;

    public CirQueueModified() {
        this(10);
    }

    public CirQueueModified(int n) {
        arr = (T[]) new Object[n];
        front = 0;
        rear = -1;
        size = 0;
    }

    public int size() {
        return size;
    }

    private void adjustCapacity()
    {
        if(isFull())
        {
            
            T tmp[] = (T[]) new Object[2 * arr.length];
            
            if (front <= rear) {
                for (int i = front ; i <= rear ; i++) {
                    tmp[i] = arr[i];
                }
            }
            
            else {
                int n = 0;
                for(int i = front ; i < arr.length ; i++)
                {
                     tmp[n] = arr[i];
                     n++;
                }
    
                for(int i = 0 ; i <= rear ; i++)
                {
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
            //     rear = 0;
            //OR
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

    public static void main(String[] args) {

        CirQueueModified<String> q = new CirQueueModified<>(4);
        q.insert("Apple");
        q.insert("Ball");
        q.insert("Cat");
        q.insert("Eleplant");
        // System.out.println("added");
        System.out.println(q);

        System.out.println(q.remove());
        System.out.println(q.remove());

        System.out.println(q);

        q.insert("Fox");
        q.insert("Goat");
        q.insert("Hen");
        q.insert("Ink");
        q.insert("Jelly");
        q.insert("Kite");

        System.out.println(q);

        q.remove();
        q.remove();
        q.remove();

        System.out.println(q);

    }
}