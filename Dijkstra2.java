package es.upm.dit.adsw.ej2;
import java.util.*;
/**
 * Dijkstra: Dijkstra algorithm.
 * @author Jesús Miguel García Sánchez 
 * @author Javier García Cotarelo 
 * @author Javier Sendra Ramos
 * @version 06/03/2019
 * 
 */


public class Dijkstra {
//fuente:https://www.vogella.com/tutorials/JavaAlgorithmsDijkstra/article.html
	private Graph graph;
	private Node src;
    private Set<Node> settledNodes;
    private Set<Node> unSettledNodes;
    private Map<Node, Node> predecessors;
    private Map<Node, Integer> distance;

    public Dijkstra(Graph graph, Node src) {
    	if (graph == null) throw new NullPointerException();
        this.src = src;
        this.graph=graph;
    }

    private void findMinimalDistances(Node node) {
        List<Node> adjacentNodes = getNeighbors(node);
        for (Node target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node)
                    + getDistance(node, target)) {
                distance.put(target, getShortestDistance(node)
                        + getDistance(node, target));
                predecessors.put(target, node);
                unSettledNodes.add(target);
            }
        }
        }

    private int getDistance(Node node, Node target) {
        for (Link edge : graph.getLinks()) {
            if (edge.getSrc().equals(node.getName())
                    && edge.getDst().equals(target.getName())) {
                return edge.getWeight();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    private List<Node> getNeighbors(Node node) {
        List<Node> neighbors = new ArrayList<Node>();
        for (Link edge : graph.getLinks()) {
            if (edge.getSrc()==(node.getName())
                    && !isSettled(graph.getNode(edge.getDst()))) {
                neighbors.add(graph.getNode(edge.getDst()));
            }
        }
        return neighbors;
    }

    private Node getMinimum(Set<Node> vertexes) {
        Node minimum = null;
        for (Node vertex : vertexes) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(Node vertex) {
        return settledNodes.contains(vertex);
    }

    private int getShortestDistance(Node destination) {
        Integer d = distance.get(destination);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

    /*
     * This method returns the path from the source to the selected target and
     * NULL if no path exists
     * @param Node dst- destination Node
     */
    public List<Node> getPath(Node dst) {
    	settledNodes = new HashSet<Node>();
        unSettledNodes = new HashSet<Node>();
        distance = new HashMap<Node, Integer>();
        predecessors = new HashMap<Node, Node>();
        distance.put(src, 0);
        unSettledNodes.add(src);
        while (unSettledNodes.size() > 0) {
            Node node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
        if(src==dst) {
        	List <Node>mismo=new ArrayList<Node>();
        mismo.add(src);
        	return mismo;
        }
        List<Node> path = new ArrayList<Node>();
        Node step = dst;
        // check if a path exists
        if (predecessors.get(step) == null) {
        	
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        // Put it into the correct order
        Collections.reverse(path);
        return path;
    }
}
