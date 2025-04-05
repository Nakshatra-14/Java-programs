public class LinearQueue<E> implements Queue<E> {

    private E arr[];
    private int front;
    private int rear;

    public LinearQueue() {
        this(10);
    }

    public LinearQueue(int n) {
        arr = (E[]) new Object[n];
        front = 0;
        rear = -1;
        System.out.println("LinQueue");
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

    public void insert(E e) {
        if (isFull())
            System.out.print("Error! Queue is full");
        else {
            rear++;
            arr[rear] = e;
        }
    }

    public E delete() {
        if (isEmpty())
            System.out.println("Error! Queue is empty");
        else {
            E n = arr[front];
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

}
