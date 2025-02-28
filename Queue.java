public class Queue<T> {
    private T arr[];
    private int front;
    private int rear;

    public Queue() {
        this(10);
    }

    public Queue(int n) {
        arr = (T[]) new Object[n];
        front = 0;
        rear = -1;
    }

    public boolean isEmpty() {
        if (front > rear)
            return true;
        else
            return false;
    }

    public boolean isFull() {
        if (rear == arr.length - 1)
            return true;
        else
            return false;
    }

    public void insert(T e) {
        if (isFull())
            System.out.print("Error! Queue is full");
        else {
            rear++;
            arr[rear] = e;
        }
    }

    public T remove() {
        if (isEmpty())
            System.out.println("Error! Queue is empty");
        else {
            T n = arr[front];
            front++;
            return n;

        }
        return null;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder("(");
        for (int i = front; i <= rear; i++) {
            sb.append(arr[i]);
            if (i < rear)
                sb.append(", ");
        }
        sb.append(")");
        String result = sb.toString();
        return result;
    }

    public static void main(String[] args) {

        Queue<String> q = new Queue<>();
        q.insert("Apple");
        q.insert("Ball");
        q.insert("Cat");
        q.insert("Eleplant");

        System.out.println(q.toString());

        System.out.println(q.remove());
        System.out.println(q.remove());

        System.out.println(q.toString());

    }
}
