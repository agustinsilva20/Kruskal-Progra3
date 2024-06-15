
import Clases.*;
import Interfaces.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hola, mundo!");
		
		IGraph grafo = new Graph();
		grafo.addEdge(4, 7, 9); // (d,g): 9
		grafo.addEdge(1, 7, 1); // (a,g) :1
		grafo.addEdge(1, 6, 5); // (a,f) : 5
		grafo.addEdge(2, 3, 3); // (b,c) : 3
		grafo.addEdge(1, 6, 5); // (a,f) : 5
		grafo.addEdge(3, 7, 3); // (c,g) : 3
		grafo.addEdge(1, 2, 4); // (a,b) : 4
		grafo.addEdge(5, 7, 4); // (e,g) : 4
		grafo.addEdge(4, 5, 7); // (d,e): 7
		grafo.addEdge(5, 6, 8); // (e,f): 8
		grafo.addEdge(1, 6, 5); // (a,f) : 5
		grafo.addEdge(3, 4, 5); // (c,d) : 5
		grafo.addEdge(6, 7, 2); // (f,g) : 2
		grafo.addEdge(1, 3, 7); // (a,c) : 7
		grafo.addEdge(4, 7, 9); // (d,g): 9
		
		List<Edge> result = Kruskal(grafo);
		
		for (Edge edge : result) {
            System.out.println("Origen: " + edge.origen + "- Destino: " + edge.destino + "- Peso: " + edge.peso );
        }
		
		
	}
	
	public static List<Edge> Kruskal (IGraph grafo) {

				// Inicio el minheap
				IHeap heap = new MinHeap();
				int cantidadVertices = 0;
				// Agregar todas las aristas al Min heap: Este las va a ordenar de menor a mayor
		        for (Edge edge : grafo.edges()) {
		            heap.push(edge);
		            cantidadVertices ++;
		        }
		        
		        // Inicio el conjunto
				IDisjointSet disjointset = new DisjointSet(cantidadVertices);
				
				// Resultado Final
				List<Edge> result = new ArrayList<>();
				
				// Inicio el proceso
				while (!heap.isEmpty() && result.size() < cantidadVertices - 1) {
		            Edge edge = heap.first();
		            heap.pop();

		            int root1 = disjointset.find(edge.origen);
		            int root2 = disjointset.find(edge.destino);

		            // Si los nodos no están en el mismo conjunto, agregar la arista al MST
		            if (root1 != root2) {
		                result.add(edge);
		                disjointset.union(root1, root2);
		            }
		        }

		        return result;
	}

}
