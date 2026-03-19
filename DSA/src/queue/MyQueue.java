package queue;

public interface MyQueue<T> {
    void insert(T e);
    T remove();
    boolean isEmpty();
    boolean isFull();
}
