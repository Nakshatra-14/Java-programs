package linkedList;

import java.util.StringJoiner;

public class Linkedlist2<T> {

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

    private Node first;

    public Linkedlist2() {
        first = null;
    }

    public String toString() {

        var sj = new StringJoiner(",");
        Node temp = first;
        while (temp != null) {
            sj.add(String.valueOf(temp.data));
            temp = temp.next;
        }
        return sj.toString();
    }

    public Node searchByData(T data) {
        Node temp = first;
        while (temp != null)
            if (temp.data.equals(data))
                break;
        return temp;
    }

    public void reverse()
    {
        
    }

    public String reverseToString() {

       var sj = new StringJoiner(",");
        Node last = null;
        while(first != last)
            {
                Node temp = first;
                while (temp.next != last) {
                    temp = temp.next;
                }
                last = temp;
                sj.add(String.valueOf(last.data));
            }
        return sj.toString();
    }

    public Node searchByPosn(int p) {

        int i = 0;
        Node temp = first;
        while (temp.next != null) {
            if(i == p)
                break;
                
            temp = temp.next;
            i++;
        }
        return temp;
    }

    // public void remove() {

    // }

    public void removeAfter(Node prev) {

        if(first == null)
            return;
        else if(prev == null)
            first = first.next;
        else
        {
            if(prev.next == null)
                prev.next = prev.next.next;
        }
    }

    public void AddAfterLast(T data) {
        Node node = new Node(data);

        if (first == null)
            first = node;

        else {
            Node temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void insertAfter(Node prev, T data) {
        Node node = new Node(data);

        if (first == null)
            first = node;

        else if(prev == null)
        {
            node.next = first;
            first = node;
        }

        else {
            node.next = prev.next;
            prev.next = node;
        }
    }

    public static void main(String[] args) {

        Linkedlist2<String> lst = new Linkedlist2<>();

        lst.AddAfterLast("Mar");
        lst.AddAfterLast("Apr");
        lst.AddAfterLast("May");
        lst.AddAfterLast("Jun");

        System.out.println(lst);

        System.out.println(lst.reverseToString());
    }
}
