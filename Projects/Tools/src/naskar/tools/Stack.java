package naskar.tools;

import java.util.Arrays;

public class Stack {
    
    private int top;
    private int arr[];

    public Stack()
    {
        this(10);
    }

    public Stack(int n)
    {
        top = -1;
        arr = new int[n];
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

    
    public void push(int e)
    {
        if(isFull())
            System.out.println("Error! Stack is full");
        else
        {
            top ++;
            arr[top] = e;
        }    
    }
    
    public int pop()
    {
        if(isEmpty())
        {
            System.out.println("Error! Stack is empty");
            return -1;
        }
        else
        {
            int n = arr[top];
            top--;
            return n;
        }    
    }

    public int peek()
    {
        if(isEmpty())
        {
            System.out.println("Error! Stack is empty");
            return -1;
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

    public static void main(String[] args) {
        int ar[] = {25, 82, 63, 54, 39, 12};
        
        System.out.println("Before Reverse:" + Arrays.toString(ar));

        reverseUsingStack(ar);

        System.out.println("After  Reverse:" + Arrays.toString(ar));

    }

    public static void reverseUsingStack(int arr[])
    {
        Stack s = new Stack(arr.length);
        for (int e : arr) {
            s.push(e);
        }
        int i = 0;
        while(!s.isEmpty())
        {
           arr[i] = s.pop();
           i++;
        }   
    }


}
