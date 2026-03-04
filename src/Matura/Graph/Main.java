package Matura.Graph;

public class Main {
    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");

        addNeighbour(nodeA, nodeB, 1);
        addNeighbour(nodeA, nodeF, 2);
        addNeighbour(nodeA, nodeG, 6);

        addNeighbour(nodeB, nodeC, 1);
        addNeighbour(nodeB, nodeD, 2);
        addNeighbour(nodeB, nodeE, 4);

        addNeighbour(nodeC, nodeE, 4);

        addNeighbour(nodeD, nodeE, 2);
        addNeighbour(nodeD, nodeF, 1);

        addNeighbour(nodeE, nodeF, 2);
        addNeighbour(nodeE, nodeG, 1);


        Graph.minimalSpanningTree(nodeB);
    }

    private static void addNeighbour(Node node1, Node node2, int weight) {
        node1.addNeighbour(node2, weight);
        node2.addNeighbour(node1, weight);
    }
}
