import java.util.Arrays;

class Stack <T>{
    
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

    
    public void push(T e)
    {
        if(isFull())
            System.out.println("Error! Stack is full");
        else
        {
            top ++;
            arr[top] = e;
        }    
    }
    
    public T pop()
    {
        if(isEmpty())
        {
            System.out.println("Error! Stack is empty");
            return null;
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

public class StackTest {

    public static void reverseUsingStack(int arr[])
    {
        Stack<Integer> s = new Stack<>(arr.length);
        int i = 0;
        for (int e : arr) {
            s.push(e);
        }
        i = 0;
        while(!s.isEmpty())
            arr[i++] = s.pop();    
    }

    // public static void main(String args[])
    // {
    //     Stack s = new Stack();
    //     System.out.println(s.capacity());   //10

    //     s = new Stack(5);
    //     System.out.println(s.capacity());   //5

    //     System.out.println(s.isEmpty());    //True
    //     System.out.println(s.isFull());     //False

    //     s.disp();                           //<nothing prints>

    //     s.push(26);
    //     s.push(39);
    //     s.push(82);

    //     System.out.println(s.isEmpty());    //False
    //     System.out.println(s.isFull());     //False

    //     s.push(56);
    //     s.push(47);
    //     s.push(78);                       //Error! Stack is full

    //     System.out.println(s.isEmpty());    //False
    //     System.out.println(s.isFull());     //True

    //     s.disp();                           //47 56 82 39 26

    //     System.out.println(s.peek());       //47

    //     while(!s.isEmpty())
    //         System.out.println(s.pop());    

    //      System.out.println(s.isEmpty());   //True
    //      System.out.println(s.isFull());    //False
         
                         
    //         System.out.println(s.peek());   //Error! Stack is empty 
    // }

    public static void main(String[] args) {
        int ar[] = {25, 82, 63, 54, 39, 12};
        
        System.out.println("Before Reverse:" + Arrays.toString(ar));

        reverseUsingStack(ar);

        System.out.println("After  Reverse:" + Arrays.toString(ar));

    }
}