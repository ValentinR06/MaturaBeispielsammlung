package Matura.Hashing;

public class PhoneBook {
    private Node[] table;
    private int size;
    private int count;

    public PhoneBook(int size) {
        table = new Node[size];
        this.size = size;
        count = 0;
    }

    public void put(String key, int value){
        if (table[hashCodeToIndex(key)] == null) {
            table[hashCodeToIndex(key)] = new Node(key, value);
            count++;
            if (count > 0.7 * size){
                rehash(size * 2 +1);
            }
            return;
        }
        if (table[hashCodeToIndex(key)].match(key)){
            table[hashCodeToIndex(key)].update(value);
            return;
        }

        Node node = table[hashCodeToIndex(key)];
        while (node.getNext() != null) {
            if (node.getNext().match(key)) {
                node.getNext().update(value);
                return;
            }
            node = node.getNext();
        }

        node.append(new Node(key, value));
        count++;
        if (count > 0.7 * size){
            rehash(size * 2);
        }
    }

    public int get(String key){
        Node node = table[hashCodeToIndex(key)];
        while (node != null) {
            if (node.match(key)) return node.getValue();
            node = node.getNext();
        }
        return -1;
    }

    private int hashCodeToIndex(String key){
        return key.length() % table.length;
    }

    private void rehash(int newSize){
        size = newSize;
        count = 0;

        Node[] oldTable = table;
        table = new Node[newSize];
        for (Node node : oldTable) {
            while (node != null) {
                put(node.getKey(), node.getValue());
                node = node.getNext();            }
        }
    }
}
