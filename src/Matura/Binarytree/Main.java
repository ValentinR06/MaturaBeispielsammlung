package Matura.Binarytree;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(10);
        tree.insert(15);
        tree.insert(5);
        tree.insert(7);
        tree.insert(12);
        tree.insert(1);

        tree.traversePreOrder();
        tree.balance();
        tree.traversePreOrder();
    }
}
