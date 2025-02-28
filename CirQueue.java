import java.util.StringJoiner;

public class CirQueue<T> {
    private T arr[];
    private int front;
    private int rear;

    public CirQueue() {
        this(10);
    }

    public CirQueue(int n) {
        arr = (T[]) new Object[n];
        front = -1;
        rear = -1;
    }

   

    public boolean isEmpty() {
        if (front == -1)
            return true;
        else
            return false;
    }

    

    public boolean isFull() {
        // if(front == rear) // if this is the only element left in the queue, then
        // front = rear = -1; // reset the queue
        if ((rear + 1) % arr.length == front)
            return true;
        else
            return false;
    }

    public void insert(T e) {
        if (isFull())
            System.out.println("Error! Queue is full");
        else {
            if (front == -1)
                front = 0;
            rear++;
            if (rear == arr.length)
                rear = 0;
            arr[rear] = e;
        }
    }

    public T remove() {
        if (isEmpty())
            System.out.println("Error! Queue is empty");
        else {
            T n = arr[front];
            if (front == rear) // if this is the only element left in the queue, then
                front = rear = -1; // reset the queue
            else
                front = (front + 1) % arr.length;    
            return n;
        }
        return null;
    }

    @Override
    public String toString() {

        if (isEmpty())
            return "()";

        // var sb = new StringBuilder("(");
        var sj = new StringJoiner(", ", "(", ")");

        if (front <= rear) {
            for (int i = front; i <= rear; i++) {
                // sb.append(arr[i]);
                // if (i < rear)
                // sb.append(", ");
                sj.add(arr[i].toString());
            }
            // sb.append(")");
            String result = sj.toString();
            return result;
        }

        else {
            for (int i = front; i < arr.length; i++) {
                // sb.append(arr[i]);
                // sb.append(", ");
                sj.add(arr[i].toString());
            }

            for (int i = 0; i <= rear; i++) {
                // sb.append(arr[i]);
                // if(i < rear)
                // sb.append(", ");
                sj.add(arr[i].toString());
            }
            // sj.add(")");
            String result = sj.toString();
            return result;
        }

    }

    public static void main(String[] args) {

        CirQueue<String> q = new CirQueue<>(4);
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

        System.out.println(q);

    }
}