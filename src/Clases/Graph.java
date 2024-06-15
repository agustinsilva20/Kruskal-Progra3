package Clases;

import java.util.ArrayList;
import java.util.List;
import Interfaces.IGraph;

public class Graph implements IGraph {
    private List<Edge> edges;

    public Graph() {
        edges = new ArrayList<>();
    }

    @Override
    public void addEdge(int origen, int destino, int peso) {
        edges.add(new Edge(origen, destino, peso));
    }

    @Override
    public List<Edge> edges() {
        return edges;
    }
}