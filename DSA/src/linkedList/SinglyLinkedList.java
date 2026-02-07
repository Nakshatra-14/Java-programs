package linkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class SinglyLinkedList<T>
{
    private Node<T> start = null ;

    // creates a node with give data and add it at the end of the list
    public void append(T data) 
    {
        Node<T> node = new Node<>(data) ;

        if(start == null) // list is empty
            start = node ;
        else
        {
            // make tmp to refer the last node
            Node<T> tmp = start ;
            while(tmp.next != null)
                tmp = tmp.next ;

            tmp.next = node ;
        }
    }

    @Override
    public String toString()
    {
        StringJoiner sj = new StringJoiner(", ", "[", "]") ;

        Node<T> tmp = start ;
        while(tmp != null)
        {
            sj.add(tmp.toString()) ;
            tmp = tmp.next ;
        }

        return sj.toString() ;
    }

    private Node<T> searchNodeByData(T data)
    {
        Node<T> tmp = start ;
        while(tmp != null)
        {
            if(data.equals(tmp.data))
                break ;
            tmp = tmp.next ;
        }

        return tmp ;
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

    public void reverse()
    {
        Node<T> tmp = start ;
        while(tmp != null)
        {

            tmp = tmp.next ;
        }
    }

    
    public void eleminateDuplicates()
    {
        // Map<T, Integer> map = new HashMap<>();
        // Node<T> tmp = start ;
        // while(tmp != null)
        // {
        //     map.put(, value)
        //     tmp = tmp.next ;
        // }
        // abacdacbadbc -> abcd
        // <write your code here>
    }

    public void sort()
    {
        // <write your code here>
        Node<T> tmp = start ;
        while(tmp != null)
        {
            tmp = tmp.next ;
        }
    }

    public void insertAt(T data, int at)
    {
        if(at <= 0)
            insert(data, null) ;
        else
        {
            Node<T> prevNode =  searchNodeByPos(at-1) ;
            System.out.println("prev = " + prevNode);
            insert(data, prevNode) ;
        }
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

    // removes the node after the node referred to by 'prev'
    // prev == null means remove the first node
    // returns data of the deleted node, if successfull
    private T remove(Node<T> prev)
    {
        Node<T> del = null ;
        if(prev == null) // to remove the first node
        {
            del = start ;
            if(del != null)
                start = del.next ;
        }
        else     // to revove the node after prev
        {
            del = prev.next ;
            if(del != null)
                prev.next = del.next ;
        }

        return del == null ? null : del.data ;
    }
/*
d    
s    
A -> B -> C-> D
     s
*/
    private static class Node<T>
    {
        private T data ;
        private Node<T> next ;

        public Node(T data)
        {
            this.data = data ;
            next = null ;
        }

        @Override
        public String toString()
        {
            return data.toString() ;
        }
    }

    public static void main(String[] args) 
    {
        SinglyLinkedList<String> lst = new SinglyLinkedList<>() ;

        lst.append("zero");
        lst.append("one");
        lst.append("two");
        lst.append("three");
        lst.append("four");
        lst.append("five");
        lst.append("six");
        lst.append("seven");


        System.out.println(lst);

        // System.out.println("Searching...");
        // System.out.println(lst.searchNodeByData("three"));
        // System.out.println(lst.searchNodeByData("five"));

        // System.out.println("insering after two...");
        // Node<String> prv = lst.searchNodeByData("two") ;
        // lst.insert("INSERTED", prv);
        // System.out.println(lst);

        

        // System.out.println("removing five...");
        // prv = lst.searchNodeByData("four") ;
        // lst.remove(prv) ;
        // System.out.println(lst);

        // System.out.println("removing after seven");
        // prv = lst.searchNodeByData("seven") ;
        // lst.remove(prv) ;
        // System.out.println(lst);
        
        lst.insertAt("INSERTED", 3);
        System.out.println(lst);

        lst.insertAt("FIRST", 0);
        System.out.println(lst);

        System.out.println(lst.searchNodeByPos(0));

    }
}
