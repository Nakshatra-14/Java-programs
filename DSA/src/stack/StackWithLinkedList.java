package stack;

public class StackWithLinkedList<T> implements MyStack<T>
{
    private static class Node<T> {
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

    private Node<T> top;

    public StackWithLinkedList(){
        top = null;
    }

    public boolean isEmpty()
    {
        return top == null;
    }

    public boolean isFull()
    {
        return false;
    }

    public void push(T e)
    {
        Node<T> n = new Node<>(e);
        n.next = top;
        top = n;
    }

    public T pop()
    {
        if(isEmpty())
            throw new RuntimeException("Stack is Empty");
        else
        {
            T data = top.data;
            top = top.next;
            return data;
        }
    }

    public T peek()
    {
        if(isEmpty())
            throw new RuntimeException("Stack is Empty");
        return top.data;
    }
}