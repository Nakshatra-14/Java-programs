package linkedList;

import java.util.StringJoiner;

public class Linkedlist {

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
        while (temp != null) {
            sj.add(String.valueOf(temp.data));
            temp = temp.next;
        }
        return sj.toString();
    }
}
