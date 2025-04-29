package naskar.exceptions.stack;

import java.util.Arrays;

public class StackTest {

    public static void reverseArray(int arr[]) throws ArrayReversalException
    // public static void reverseArray(int arr[]) throws Throwable
    {
        Stack<Integer> s = new Stack<>(arr.length);
        int i = 0;
       try{ 
        for (int e : arr) {
            s.push(e);
        }
        s.push(5000);
        i = 0;
        while(!s.isEmpty())
            arr[i++] = s.pop();
        }
        catch(StackOverflowException | StackUnderflowException ex) {
            var r = new ArrayReversalException("Problem in reversing array", ex);
            throw r;
        }    
       
    }

    // public static void main(String args[])
    // {
    // Stack s = new Stack();
    // System.out.println(s.capacity()); //10

    // s = new Stack(5);
    // System.out.println(s.capacity()); //5

    // System.out.println(s.isEmpty()); //True
    // System.out.println(s.isFull()); //False

    // s.disp(); //<nothing prints>

    // s.push(26);
    // s.push(39);
    // s.push(82);

    // System.out.println(s.isEmpty()); //False
    // System.out.println(s.isFull()); //False

    // s.push(56);
    // s.push(47);
    // s.push(78); //Error! Stack is full

    // System.out.println(s.isEmpty()); //False
    // System.out.println(s.isFull()); //True

    // s.disp(); //47 56 82 39 26

    // System.out.println(s.peek()); //47

    // while(!s.isEmpty())
    // System.out.println(s.pop());

    // System.out.println(s.isEmpty()); //True
    // System.out.println(s.isFull()); //False

    // System.out.println(s.peek()); //Error! Stack is empty
    // }
}
