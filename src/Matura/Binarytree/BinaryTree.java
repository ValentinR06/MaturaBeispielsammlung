package Matura.Binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class BinaryTree<T extends Comparable<T>> implements Tree<T>{
    private Node<T> root;

    @Override
    public void insert(T value) throws DuplicateValueException{
        if (root == null) {
            root = new Node<>(value);
            return;
        }

        Node<T> node = root;
        while (node != null) {
            if(value.compareTo(node.getValue()) == 0) throw new DuplicateValueException("Duplicate value");


            if (value.compareTo(node.getValue()) < 0) {
                if (node.getLeft() == null) {
                    node.setLeft(new Node<>(value));
                    return;
                }
                node = node.getLeft();
            }
            if (value.compareTo(node.getValue()) > 0) {
                if (node.getRight() == null) {
                    node.setRight(new Node<>(value));
                    return;
                }
                node = node.getRight();
            }
        }
    }

    @Override
    public void delete(T value) throws NotInTreeException {
        root = deleteRecursive(root, value);
    }

    private Node<T> deleteRecursive(Node<T> node, T value) throws NotInTreeException {
        if (node == null) throw new NotInTreeException("Value not found in tree");

        int compare = value.compareTo(node.getValue());
        if (compare < 0) {
            node.setLeft(deleteRecursive(node.getLeft(), value));
            return node;
        }
        if (compare > 0) {
            node.setRight(deleteRecursive(node.getRight(), value));
            return node;
        }

        if (node.getLeft() == null && node.getRight() == null) {
            return null;
        }
        if (node.getLeft() == null) {
            return node.getRight();
        }
        if (node.getRight() == null) {
            return node.getLeft();
        }



        Node<T> parent = node;
        Node<T> successor = node.getRight();

        while (successor.getLeft() != null) {
            parent = successor;
            successor = successor.getLeft();
        }

        if (parent == node) {
            successor.setLeft(node.getLeft());
        }
        else {
            parent.setLeft(successor.getRight());
            successor.setLeft(node.getLeft());
            successor.setRight(node.getRight());
        }

        return successor;
    }


    @Override
    public boolean contains(T value) {
        Node<T> node = root;
        while (node != null) {
            if (value.compareTo(node.getValue()) == 0) {
                return true;
            }
            if (value.compareTo(node.getValue()) < 0) {
                node = node.getLeft();
            }
            if (value.compareTo(node.getValue()) > 0) {
                node = node.getRight();
            }
        }
        return false;
    }

    @Override
    public void balance() {
        Node<T> tail = new Node<>(null);
        tail.setRight(root);
        treeToVine(tail, root);



        vineToTree();
    }

    private void treeToVine(Node<T> tail, Node<T> rest) {
        if (rest.getLeft() == null && rest.getRight() == null) {
            return;
        }

        if (rest.getLeft() == null) {
            treeToVine(rest, rest.getRight());
            return;
        }

        tail.setRight(rest.getLeft());
        rest.setLeft(tail.getRight().getRight());
        tail.getRight().setRight(rest);
        treeToVine(tail, tail.getRight());
    }

    private void vineToTree() {
    }

    @Override
    public void traverseInOrder() {
        traverseInOrderRecursive(root);
        System.out.println();
    }

    private void traverseInOrderRecursive(Node<T> node) {
        if (node == null) return;
        if (node.getLeft() != null) traverseInOrderRecursive(node.getLeft());
        System.out.print(node.getValue() + " ");
        if (node.getRight() != null) traverseInOrderRecursive(node.getRight());
    }

    @Override
    public void traversePreOrder() {
        traversePreOrderRecursive(root);
        System.out.println();
    }

    private void traversePreOrderRecursive(Node<T> node) {
        if (node == null) return;
        System.out.print(node.getValue() + " ");
        if (node.getLeft() != null) traversePreOrderRecursive(node.getLeft());
        if (node.getRight() != null) traversePreOrderRecursive(node.getRight());
    }

    @Override
    public void traversePostOrder() {
        traversePostOrderRecursive(root);
        System.out.println();
    }

    private void traversePostOrderRecursive(Node<T> node) {
        if (node == null) return;
        if (node.getLeft() != null) traverseInOrderRecursive(node.getLeft());
        if (node.getRight() != null) traverseInOrderRecursive(node.getRight());
        System.out.print(node.getValue() + " ");
    }

    @Override
    public List<T> findPathTo(T val1, T val2) throws NotInTreeException{
        Node<T> node = root;
        while (true) {
            if(node == null) throw new NotInTreeException("Value not found in tree");
            int comp1 = node.getValue().compareTo(val1);
            int comp2 = node.getValue().compareTo(val2);

            if (comp1 < 0 && comp2 < 0) {
                node = node.getRight();
            }
            else if (comp1 > 0 && comp2 > 0) {
                node = node.getLeft();
            }
            else {
                break;
            }
        }

        List<T> list1 = findPathRecursive(node, new ArrayList<>(), val1);
        List<T> list2 = findPathRecursive(node, new ArrayList<>(), val2);
        list1.removeLast();
        Collections.reverse(list2);
        list1.addAll(list2);
        return list1;
    }

    private List<T> findPathRecursive(Node<T> node, List<T> list, T val1) throws NotInTreeException{
        if (node == null) throw new NotInTreeException("Value not found in tree");

        if (node.getValue().compareTo(val1) < 0) {
            list = findPathRecursive(node.getRight(), list, val1);
        }
        if (node.getValue().compareTo(val1) > 0) {
            list = findPathRecursive(node.getLeft(), list, val1);
        }

        list.add(node.getValue());
        return list;
    }

    @Override
    public int computeMaxDepth() {
        return computeMaxDepthRecursive(root);
    }

    private int computeMaxDepthRecursive(Node<T> node) {
        if (node == null) return 0;
        return Math.max(computeMaxDepthRecursive(node.getLeft()), computeMaxDepthRecursive(node.getRight())) + 1;
    }
}
