package Matura.Binarytree;

import java.util.List;

public interface Tree<T extends Comparable<T>> {
    void insert(T value) throws DuplicateValueException;
    void delete(T value) throws NotInTreeException;
    boolean contains(T value);
    void balance();
    void traverseInOrder();
    void traversePreOrder();
    void traversePostOrder();
    List<T> findPathTo(T val1, T val2) throws NotInTreeException;
}
