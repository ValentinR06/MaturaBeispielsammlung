package Matura.Graph;

import java.sql.SQLOutput;
import java.util.*;

public class Graph {


    public static void shortestPath1(Node node1, Node node2) {
        List<Node> saum = new LinkedList<>(node1.getNeighbors());
        HashMap<Node, Integer> distances = new HashMap<>();
        for (int i = 0; i < saum.size(); i++) distances.put(saum.get(i), node2.getWeights().get(i));


        while (!node2.isVisited()) {
            int min = Integer.MAX_VALUE;
            Node minNode = null;
            for (Node n : saum) {
                if (distances.get(n) < min) {
                    min = distances.get(n);
                    minNode = n;
                }
            }
            if (minNode == null) throw new RuntimeException("No path found");
            minNode.setVisited(true);
            for (int i = 0; i < minNode.getNeighbors().size(); i++) {

                Node n = minNode.getNeighbors().get(i);
                int weight = minNode.getWeights().get(i);

                if (n.isVisited()) continue;
                if (!saum.contains(n)) saum.add(n);
                distances.put(n, distances.get(minNode) + weight);
            }
        }
    }


    public static void minimalSpanningTree1(Node root) {
        List<Node> baum = new LinkedList<>();
        baum.add(root);

        List<Node> saum = new LinkedList<>(root.getNeighbors());
        List<Integer> weightsToSaum = new LinkedList<>(root.getWeights());
        List<Node> minimalParents = new LinkedList<>();
        for (Node n :saum) minimalParents.add(root);


        while (!saum.isEmpty()) {
            int minimalIndex = weightsToSaum.indexOf(weightsToSaum.stream().min(Integer::compareTo).get());
            Node nextNode = saum.get(minimalIndex);
            int nextWeight = weightsToSaum.get(minimalIndex);
            Node parent = minimalParents.get(minimalIndex);

            saum.remove(minimalIndex);
            weightsToSaum.remove(minimalIndex);
            minimalParents.remove(minimalIndex);

            System.out.println(parent.getName() + " -(" + nextWeight + ")> " + nextNode.getName());

            baum.add(nextNode);

            for (int i = 0; i < nextNode.getNeighbors().size(); i++) {
                if (!baum.contains(nextNode.getNeighbors().get(i))) {
                    if(!saum.contains(nextNode.getNeighbors().get(i))) {
                        saum.add(nextNode.getNeighbors().get(i));
                        weightsToSaum.add(nextNode.getWeights().get(i));
                        minimalParents.add(nextNode);
                    }
                    else {
                        for (int j = 0; j < saum.size(); j++) {
                            if (saum.get(j).equals(nextNode.getNeighbors().get(i))) {
                                minimalParents.set(j, nextNode);
                                weightsToSaum.set(j, nextNode.getWeights().get(i));
                            }
                        }
                    }
                }
            }
        }
    }



    public static void shortestPath2(Node p, Node q) {
        List<Node> heap = new LinkedList<>();
        p.setMinWeight(0);
        while (p != null && p != q) {
            p.setVisited(true);
            for (int i = 0; i < p.getNeighbors().size(); i++) {
                Node son = p.getNeighbors().get(i);
                if (!son.isVisited()) {
                    int distance = p.getMinWeight() + p.getWeights().get(i);
                    if (!heap.contains(son)) {
                        son.setParent(p);
                        son.setMinWeight(distance);
                        heap.add(son);
                    } else if (distance < son.getMinWeight()) {
                        son.setParent(p);
                        son.setMinWeight(distance);
                    }
                }
            }
            heap.sort(Comparator.comparingInt(Node::getMinWeight));
            p = heap.removeFirst();
        }
    }

    public static void minimalSpanningTree2(Node node) {
        List<Node> heap = new LinkedList<>();
        node.setMinWeight(0);
        while (node != null) {
            node.setVisited(true);
            for (int i = 0; i < node.getNeighbors().size(); i++) {
                Node son = node.getNeighbors().get(i);
                if (!son.isVisited()) {
                    int distance = node.getWeights().get(i);
                    if (!heap.contains(son)) {
                        son.setParent(node);
                        son.setMinWeight(distance);
                        heap.add(son);
                    } else if (distance < son.getMinWeight()) {
                        son.setParent(node);
                        son.setMinWeight(distance);
                    }
                }
            }
            heap.sort(Comparator.comparingInt(Node::getMinWeight));
            if (heap.isEmpty()) return;
            node = heap.removeFirst();
        }
    }

    public static void printShortestPath(Node node) {
        System.out.println("shortest Path Structure");
        Node son = node;
        Node parent = node.getParent();
        while (parent != null) {
            System.out.println(parent.getName() + " -> " + son.getName());

            son = parent;
            parent = parent.getParent();
        }
    }

    public static void printMinimalSpanningTree(List<Node> nodes) {
        System.out.println("MST Structure:");
        for (Node n : nodes) {
            if (n.getParent() != null) {
                System.out.println(n.getParent().getName() + " -> " + n.getName() +
                        " (Weight: " + n.getMinWeight() + ")");
            }
        }
    }

    public static void resetGraph(List<Node> nodes) {
        for (Node n : nodes) {
            n.setMinWeight(Integer.MAX_VALUE);
            n.setVisited(false);
            n.setParent(null);
        }
    }

}
