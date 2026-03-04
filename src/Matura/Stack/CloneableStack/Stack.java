package Matura.Stack.CloneableStack;

import java.util.Iterator;

public class Stack implements Cloneable, Iterable<String>{
    private Node head = null;

    public void push(String value) {
        head = new Node(value, head);
    }

    public String pop() {
        String value = head.getValue();
        head = head.getNext();
        return value;
    }

    public String peek() {
        return head.getValue();
    }


    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public String next() {
                String value = current.getValue();
                current = current.getNext();
                return value;
            }
        };
    }

    @Override
    public Stack clone() {
        try {
            Stack clone = (Stack) super.clone();
            clone.head = head != null ? head.clone() : null;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
