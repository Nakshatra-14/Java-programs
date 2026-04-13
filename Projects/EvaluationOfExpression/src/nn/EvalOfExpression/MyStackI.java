package nn.EvalOfExpression;

public interface MyStackI<T> {

    boolean isEmpty();
    boolean isFull();
    void push(T e);
    T pop();
    T peek();
}
