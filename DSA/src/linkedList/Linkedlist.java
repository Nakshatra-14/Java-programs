package linkedlist;

import java.util.StringJoiner;

public class Linkedlist<T> {

    private static class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
            next = null;
        }

        public String toString() {
            return String.valueOf(data); // return data + "";
        }
    }

    private Node first;

    public Linkedlist() {
        first = null;
    }

    public String toString() {

        var sj = new StringJoiner(",");
        Node temp = first;
        sj.add("[");
        while (temp != null) {
            sj.add(String.valueOf(temp.data));
            temp = temp.next;
        }
        sj.add("]");
        return sj.toString();
    }

    public boolean isEmpty()
    {
        return first == null ;
    }

    public boolean isFull()
    {
        return false;
    }

    public void insertAtPos(int pos, Node node)
    {
        if (pos <= 0 || first == null) {
            node.next = first;
            first = node;
        } else {
            Node temp = first;
            for (int i = 0; i < pos - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }
        
    }

    public void insert(Node node)
    {
        if (first == null) {
            first = node;
        } else {
            Node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public T remove()
    {
        if (first == null) {
            throw new RuntimeException("List is empty");
        }
        T data = (T) first.data;
        first = first.next;
        return data;
    }



}
