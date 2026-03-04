package Matura.Hashing;

public class Node {
    private final String key;
    private int value;
    private Node next;

    public Node(String key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public boolean match(String key) {
        return this.key.equals(key);
    }

    public int getValue() {
        return value;
    }

    public void update(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void append(Node node) {
        this.next = node;
    }

    public String getKey() {
        return key;
    }
}
