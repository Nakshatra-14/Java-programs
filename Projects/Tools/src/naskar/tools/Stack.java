package naskar.tools;
import java.util.Arrays;

public class Stack {
    
    private int top;
    private Object arr[];

    public Stack()
    {
        this(10);
    }

    public Stack(int n)
    {
        top = -1;
        arr = new Object[n];
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

    
    public void push(Object e)
    {
        if(isFull())
            System.out.println("Error! Stack is full");
        else
        {
            top ++;
            arr[top] = e;
        }    
    }
    
    public Object pop()
    {
        if(isEmpty())
        {
            System.out.println("Error! Stack is empty");
            return -1;
        }
        else
        {
            Object n = arr[top];
            top--;
            return n;
        }    
    }

    public Object peek()
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

    @Override
    public String toString() {
        String result = "(";
        for (int i = top ; i >= 0 ; i--) {
            result += arr[i];    
            if(i != 0)
                result += ", ";
        }
        result += ")";    
        // return result.substring(0, result.length() - 2);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        
        if(!(obj instanceof Stack))
        {
            return false;
        }
        else
        {
            Stack s = (Stack) obj;
            return (top == s.top && Arrays.equals(arr, s.arr));
        }
    }

    public static void reverseUsingStack(Object arr[])
    {
        Stack s = new Stack(arr.length);
        for (Object e : arr) {
            s.push(e);
        }
        int i = 0;
        while(!s.isEmpty())
        {
           arr[i] = s.pop();
           i++;
        }   
    }

    public static void reverseStringUsingStack(String arr[])
    {
        Stack s = new Stack(arr.length);
        for(String e : arr)
            s.push(e);
        int i = 0;
        while(!s.isEmpty())
        {
            arr[i] = (String) s.pop();
            i++;
        }    
    }


    public static void main(String[] args) {
        int ar[] = {25, 82, 63, 54, 39, 12};
        
        // System.out.println("Before Reverse:" + Arrays.toString(ar));

        // reverseUsingStack(ar);

        // System.out.println("After  Reverse:" + Arrays.toString(ar));

        Stack stk = new Stack(ar.length);
        for (int e : ar) {
            stk.push(e);
        }
        System.out.println(stk);

    }



}
