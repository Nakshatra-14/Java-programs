package stack;

public class MyStackWithLinkedList<T> implements MyStackI<T>
{

    private class Node {
        T data;
        Node next;

        public Node(T d) {
            data = d;
            next = null;
        }

        public String toString() {
            return String.valueOf(data); // return data + "";
        }
    }

    private Node top;

    public MyStackWithLinkedList() {
        top = null;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void push(T e) {
        Node n = new Node(e);

        // if(top == null)
        //     top = n;
        // else
        // {
        //     Node tmp = new Node(e);
        //     while (tmp.next != null) {
        //         tmp = tmp.next;
        //     }
        //     tmp.next = n;
        // }

        n.next = top;
        top = n;
    }


    @Override
    public T pop() {
        if(isEmpty())
            throw new RuntimeException("Stack is Empty");
        Node n = top;
        top = top.next;
        return n.data;
    }

    @Override
    public T peek() {
        if(isEmpty())
            throw new RuntimeException("Stack is Empty");
        return top.data;
    }
}
