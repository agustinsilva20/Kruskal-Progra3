package Clases;

public class Edge implements Comparable<Edge> {
    public int origen;
    public int destino;
    public int peso;

    public Edge(int origin, int destination, int weight) {
        this.origen = origin;
        this.destino = destination;
        this.peso = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.peso, other.peso);
    }
}

