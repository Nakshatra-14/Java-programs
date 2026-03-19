package stack;

public interface MyStack<T> {

    boolean isEmpty();
    boolean isFull();
    void push(T e);
    T pop();
    T peek();
}
