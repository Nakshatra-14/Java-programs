package stack;

import java.util.StringJoiner;

public class MyArrayStack<T> implements MyStackI<T>{

    private T arr[];
    private int size;
    private int pos = 0;

    public MyArrayStack() {
        this(10);
    }

    public MyArrayStack(int n)
    {
        arr = new T[n];
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
        for(int i = 0 ; i <= pos ; i++)
            sj.add("{" + i + " : " + arr[i] + "}");
        return sj.toString();
    }

    public static void main(String[] args) {
        MyArrayStack<Integer> stack = new MyArrayStack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
