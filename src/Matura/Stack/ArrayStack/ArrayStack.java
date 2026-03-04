package Matura.Stack.ArrayStack;

import java.util.Arrays;

public class ArrayStack<T> implements Stack<T>{
    private T[] array;
    private int top;

    public ArrayStack(int size) {
        array = (T[]) new Object[size];
        top = -1;
    }

    @Override
    public void push(T value) {
        if (top + 1 >= array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }

        array[++top] = value;
    }

    @Override
    public T pop() throws StackUnderflowException {
        if (top < 0) {
            throw new StackUnderflowException("Stack is empty");
        }

        return array[top--];

    }

    @Override
    public T peek() throws StackUnderflowException {
        if (top < 0) {
            throw new StackUnderflowException("Stack is empty");
        }

        return array[top];
    }

    @Override
    public boolean isEmpty() {
        return top < 0;
    }

    @Override
    public int size() {
        return top + 1;
    }
}
