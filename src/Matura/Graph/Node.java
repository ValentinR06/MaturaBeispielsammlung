package Matura.Graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private final String name;
    private final List<Node> neighbors = new ArrayList<>();
    private final List<Integer> weights = new ArrayList<>();
    private boolean visited = false;
    private Node parent = null;
    private int minWeight = Integer.MAX_VALUE;

    public Node(String name) {
        this.name = name;
    }

    public void addNeighbor(Node neighbor, int weight) {
        neighbors.add(neighbor);
        weights.add(weight);
    }

    public String getName() { return name; }
    public List<Node> getNeighbors() { return neighbors; }
    public List<Integer> getWeights() { return weights; }
    public boolean isVisited() { return visited; }
    public void setVisited(boolean visited) { this.visited = visited; }
    public Node getParent() { return parent; }
    public void setParent(Node parent) { this.parent = parent; }
    public int getMinWeight() { return minWeight; }
    public void setMinWeight(int minWeight) { this.minWeight = minWeight; }

    @Override
    public String toString() { return name; }
}
