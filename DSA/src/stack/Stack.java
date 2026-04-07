package stack;

import java.util.StringJoiner;

public class Stack<T> implements MyStack<T>{

    private T arr[];
    private int size;
    private int pos = 0;

    public Stack() {
        this(10);
    }

    public Stack(int n)
    {
        arr = (T[]) new Object[n];
        size = n;
    }

    @Override
    public boolean isEmpty() {
        return pos == 0;
    }

    @Override
    public boolean isFull() {
        return pos == size;
    }

    @Override
    public void push(T e) {
        if(isFull())
            throw new RuntimeException("Stack is full");
        arr[pos++] = e;
    }

    @Override
    public T pop() {
        if(isEmpty())
            throw new RuntimeException("Stack is Empty");
        T tmp = arr[pos];
        pos--;
        return tmp;
    }

    @Override
    public T peek() {
        return arr[pos];
    } 

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(",","[", "]");
        for(int i = 0 ; i < arr.length ; i++)
            sj.add("{" + i + " : " + arr[i]);
        return sj.toString();
    }
}
