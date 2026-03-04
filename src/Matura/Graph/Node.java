package Matura.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Node {
    private final String name;
    private final List<Node> neighbours;
    private final List<Integer> weights;

    private boolean visited;

    public Node(String name) {
        this.name = name;
        this.neighbours = new LinkedList<>();
        this.weights = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void addNeighbour(Node neighbour, int weight) {
        neighbours.add(neighbour);
        weights.add(weight);
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }

    public List<Integer> getWeights() {
        return weights;
    }

}
