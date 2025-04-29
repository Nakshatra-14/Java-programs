package naskar.exceptions.stack;
import java.util.Arrays;

public class Stack <T>{
    
    private int top;
    private T arr[];

    public Stack()
    {
        this(10);
    }

    public Stack(int n)
    {
        top = -1;
        arr = (T[])new Object[n];
    }

    public int capacity()
    {
        return arr.length;
    }

    public boolean isEmpty()
    {
        if(top == -1)
            return true;
        else
            return false;    
    }

    public boolean isFull()
    {
        if(top == arr.length - 1)
            return true;
        else
            return false;    
    }

    
    public void push(T e) throws StackOverflowException
    {
        if(isFull())
            throw new StackOverflowException("Stack is full !");
            // System.out.println("Error! Stack is full");
        else
        {
            top ++;
            arr[top] = e;
        }    
    }
    
    public T pop() throws StackUnderflowException
    {
        if(isEmpty())
        {
            throw new StackUnderflowException("Stack is empty !");
            // System.out.println("Error! Stack is empty");
            // return null;
        }
        else
        {
            T n = arr[top];
            top--;
            return n;
        }    
    }

    public T peek()
    {
        if(isEmpty())
        {
            System.out.println("Error! Stack is empty");
            return null;
        }
        else
        {
            return arr[top];
        }
    }
    
    public void disp()
    {
        for (int i = top ; i >= 0 ; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

