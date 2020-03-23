package es.upm.dit.adsw.ej2;
import java.util.Random;
/**
 * Dijkstra: Dijkstra algorithm.
 * @author Jesús Miguel García Sánchez 
 * @author Javier García Cotarelo 
 * @author Javier Sendra Ramos
 * @version 06/03/2019
 * 
 */

public class DijkstraMeter {
	
public DijkstraMeter () {
		}
public static void load (Graph graph, int n) {
	Random random = new Random ();
	int rnd;
	int rndWeight;
	for (int i = 0; i < n; i++) {
		Node node = new Node(Integer.toString(i), 0, 0);
		graph.addNode(node);
		for (int j = 0; j < 4; j++) {
			rnd = random.nextInt(n); 
			rndWeight = random.nextInt(10);
			graph.addLink2D(node.getName(), Integer.toString(rnd), rndWeight);
		}
	}
}

public static long doit (Graph graph) {
	 Node n0 = graph.getNode("0");
	 Node n1 = graph.getNode(Integer.toString(graph.getNodes().size()));
	 Dijkstra algo=new Dijkstra(graph, n0);
	 long t0 = System.currentTimeMillis();
	 algo.getPath(n1);
	 long t2 = System.currentTimeMillis();
	 return t2 - t0;
	}


public static void main (String [] args) {
	for (int n = 1_000; n < 100_000; n+= 5_000) {
		Graph graph = new Graph();
		load(graph, n);
		long t = doit(graph);
		System.out.printf("%s %d%n", n, t);
		}
}

}

