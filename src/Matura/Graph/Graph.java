package Matura.Graph;

import java.util.*;

public class Graph {


    public static void shortestPath(Node node1, Node node2) {
        List<Node> saum = new LinkedList<>(node1.getNeighbours());
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
            for (int i = 0; i < minNode.getNeighbours().size(); i++) {

                Node n = minNode.getNeighbours().get(i);
                int weight = minNode.getWeights().get(i);

                if (n.isVisited()) continue;
                if (!saum.contains(n)) saum.add(n);
                distances.put(n, distances.get(minNode) + weight);
            }
        }
    }


    public static void minimalSpanningTree(Node root) {
        List<Node> baum = new LinkedList<>();
        baum.add(root);

        List<Node> saum = new LinkedList<>(root.getNeighbours());
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

            for (int i = 0; i < nextNode.getNeighbours().size(); i++) {
                if (!baum.contains(nextNode.getNeighbours().get(i))) {
                    if(!saum.contains(nextNode.getNeighbours().get(i))) {
                        saum.add(nextNode.getNeighbours().get(i));
                        weightsToSaum.add(nextNode.getWeights().get(i));
                        minimalParents.add(nextNode);
                    }
                    else {
                        for (int j = 0; j < saum.size(); j++) {
                            if (saum.get(j).equals(nextNode.getNeighbours().get(i))) {
                                minimalParents.set(j, nextNode);
                                weightsToSaum.set(j, nextNode.getWeights().get(i));
                            }
                        }
                    }
                }
            }
        }
    }
}
