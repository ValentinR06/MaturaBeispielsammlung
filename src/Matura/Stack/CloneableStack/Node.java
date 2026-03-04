package Matura.Stack.CloneableStack;

public class Node implements Cloneable{
    private final String value;
    private Node next;

    public Node(String value) {
        this.value = value;
        this.next = null;
    }

    public Node(String value, Node next) {
        this.value = value;
        this.next = next;
    }

    public String getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public Node clone() {
        try {
            Node clone = (Node) super.clone();
            clone.next = next != null ? next.clone() : null;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
