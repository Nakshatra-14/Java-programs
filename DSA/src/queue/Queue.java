package queue;

import java.util.StringJoiner;

public class Queue<T> implements MyQueue<T>{

    private class Node<T> {

        T data;
        Node<T> next;

        public Node(T d) {
            data = d;
            next = null;
        }

        public String toString() {
            return String.valueOf(data); // return data + "";
        }
    }

    private Node front;
    private Node rear; 
    
    public Queue() {
        front = null;
        rear = null;
    }

    @Override
    public void insert(T e) {
        Node<T> n = new Node<>(e);
        if(front == null)
        {
            front = n;
            rear = n;
        }
        else
        {
            // Node<T> n = new Node<>(e);
            rear.next = n;
            rear = n;
        }
    }

    @Override
    public T remove() {
        if(isEmpty())
            throw new RuntimeException("Queue is Empty");

        Node<T> n = front;
        front = front.next;
        if(front == null)
            rear = null;
        return n.data;
    }

    @Override
    public boolean isEmpty() {
        return front == null && rear == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public String toString() {

        var sj = new StringJoiner(",");
        Node<T> temp = front;
        while (temp != null) {
            sj.add(String.valueOf(temp.data));
            temp = temp.next;
        }
        return sj.toString();
    }

    public static void main(String[] args) {
        Queue<Character> q = new Queue<>();
        q.insert('A');
        q.insert('B');
        q.insert('C');
        q.insert('D');
        
        System.out.println(q);
        System.out.println(q.remove());
        System.out.println(q);
        q.insert('E');
        q.remove();
        q.remove();
        q.remove();
        q.remove();
        // q.remove();
        System.out.println(q);
    }
    
}
