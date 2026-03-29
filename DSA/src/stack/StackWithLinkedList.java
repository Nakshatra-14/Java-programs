package stack;

import java.util.LinkedList;

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

}