package Matura.Graph;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");

        List<Node> nodes = new ArrayList<>();
        nodes.add(nodeA);
        nodes.add(nodeB);
        nodes.add(nodeC);
        nodes.add(nodeD);
        nodes.add(nodeE);
        nodes.add(nodeF);
        nodes.add(nodeG);

        addNeighbor(nodeA, nodeB, 1);
        addNeighbor(nodeA, nodeF, 2);
        addNeighbor(nodeA, nodeG, 6);

        addNeighbor(nodeB, nodeC, 1);
        addNeighbor(nodeB, nodeD, 2);
        addNeighbor(nodeB, nodeE, 4);

        addNeighbor(nodeC, nodeE, 4);

        addNeighbor(nodeD, nodeE, 2);
        addNeighbor(nodeD, nodeF, 1);

        addNeighbor(nodeE, nodeF, 2);
        addNeighbor(nodeE, nodeG, 1);


        Graph.shortestPath2(nodeA, nodeG);
        Graph.printShortestPath(nodeG);

        Graph.resetGraph(nodes);

        Graph.minimalSpanningTree2(nodeB);
        Graph.printMinimalSpanningTree(nodes);





    }



    private static void addNeighbor(Node node1, Node node2, int weight) {
        node1.addNeighbor(node2, weight);
        node2.addNeighbor(node1, weight);
    }
}
