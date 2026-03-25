package stack;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Stack<Integer> implements MyStack<Integer>{

    int n = 0;
    int arr[];

    public Stack() {
        arr = new int[n];
    }

    void updateArray(int value, int n)
    {
        int tmp[] = new int[arr.length+1];
        for(int i = 0 ; i < arr.length ; i++)
            tmp[i] = arr[i];
        arr = tmp;
        n++;
        arr[n] = value;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }
    @Override
    public boolean isFull() {
        return false;
    }
    @Override
    public void push(int e) {
        updateArray(e, n);
    }
    @Override
    public Integer pop() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pop'");
    }
    @Override
    public Integer peek() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'peek'");
    }

   

}
