package stack;

import java.util.LinkedList;
import java.util.StringJoiner;

public class StackWithLinkedList<T> implements MyStack<T>
{

    private class Node<T> {

        T data;
        Node<T> next;

        public Node(T d) {
            data = d;
            next = null;
        }

        public String toString() {
            return String.valueOf(data); 
        }
    }

    private Node<T> start = null ;
    private int pos = 0;

    @Override
    public boolean isEmpty() {
       return start == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    private Node<T> searchNodeByPos(int pos) // pos = 0 means first node
    {
        Node<T> tmp = start ;
        for(int i = 0 ; tmp != null ; i++)
        {
            if(i == pos)
                break;
            tmp = tmp.next ;
        }
        return tmp;
    }

    

    // creates a node with given data and insert it after the node referred to by 'prev'
    // prev == null means insert at the first
    private void insert(T data, Node<T> prev)
    {
        Node<T> node = new Node<>(data) ;

        if(prev == null) // to insert at start of the list
        {
            node.next = start ;
            start = node ;
        }
        else             // to insert after prev
        {
            node.next = prev.next ;
            prev.next = node ;
        }
    }

    @Override
    public void push(T e) {
       if(pos <= 0)
            insert(e, null) ;
        else
        {
            Node<T> prevNode =  searchNodeByPos(pos-1) ;
            // System.out.println("prev = " + prevNode);
            insert(e, prevNode) ;
        }
    }

    @Override
    public T pop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pop'");
    }

    @Override
    public T peek() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'peek'");
    }

    

        @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",","[", "]");
        Node<T> tmp = start ;
        while(tmp != null)
        {
            sj.add(String.valueOf(tmp.data));
            tmp = tmp.next ;
        }
        return sj.toString();
    }

        public static void main(String[] args) {
        StackWithLinkedList<Integer> lst = new StackWithLinkedList<>();

        lst.push(1);
        lst.push(2);
        lst.push(3);
        lst.push(4);
        // System.out.println(lst.pop());
        lst.push(5);
        lst.push(6);
        System.out.println(lst.toString());
    }


}
