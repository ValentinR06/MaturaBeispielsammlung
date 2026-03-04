package Matura.Stack.ArrayStack;

public interface Stack<T> {
    void push(T value);
    T pop() throws StackUnderflowException;
    T peek() throws StackUnderflowException;
    boolean isEmpty();
    int size();
}
