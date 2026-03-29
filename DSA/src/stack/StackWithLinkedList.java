package stack;

import java.util.LinkedList;
import java.util.StringJoiner;

public class StackWithLinkedList<T> implements MyStack<T>
{
    LinkedList<T> lst = new LinkedList<>();

    @Override
    public boolean isEmpty() {
        return lst.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void push(T e) {
        lst.add(e);
    }

    @Override
    public T pop() {
        if(lst.isEmpty())
            throw new RuntimeException("Cannot remove item from stack as it is Empty");
        return  lst.removeLast();
    }

    @Override
    public T peek() {
        return lst.peek();
    }

    @Override
    public String toString()
    {
        StringJoiner sj = new StringJoiner(", ", "[", "]") ;

        for(T e : lst)
        {
            sj.add(e.toString()) ;
        }

        return sj.toString() ;
    }


    public static void main(String[] args) {
        StackWithLinkedList<Integer> lst = new StackWithLinkedList<>();

        lst.push(1);
        lst.push(2);
        lst.push(3);
        lst.push(4);
        System.out.println(lst.pop());
        lst.push(5);
        lst.push(6);
        System.out.println(lst.toString());
    }

}
