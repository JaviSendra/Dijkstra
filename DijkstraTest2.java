package es.upm.dit.adsw.ej2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Pruebas del algoritmo de Dijkstra.
 * 
 * @author Jesús Miguel García Sánchez 
 * @author Javier García Cotarelo 
 * @author Javier Sendra Ramos
 * 
 * @version 11.2.2018
 */
public class DijkstraTest {
    private Graph graph;
    private Node A;
    private Node B;
    private Node C;

    @Before
    public void setup() {
        graph = new Graph();
        A = new Node("a", 0, 0);
        B = new Node("b", 0, 0);
        C = new Node("c", 0, 0);
        graph.addNode(A);
        graph.addNode(B);
        graph.addNode(C);
        graph.addLink(new Link("a", "b", 2));
        graph.addLink(new Link("b", "c", 2));
        graph.addLink(new Link("a", "c", 5));
    }

    @Test
    public void test1() {
        Dijkstra dijkstra = new Dijkstra(graph, A);

        List<Node> pathAB = dijkstra.getPath(B);
        List<Node> expectedAB = Arrays.asList(A, B);
        assertThat(pathAB, is(expectedAB));
        assertEquals(2, graph.getWeight(pathAB));

        List<Node> pathAC = dijkstra.getPath(C);
        List<Node> expectedAC = Arrays.asList(A, B, C);
        assertThat(pathAC, is(expectedAC));
        assertEquals(4, graph.getWeight(pathAC));
    }

    @Test
    public void test2() {
        Dijkstra dijkstra = new Dijkstra(graph, B);

        List<Node> pathBC = dijkstra.getPath(C);
        List<Node> expectedBC = Arrays.asList(B, C);
        assertEquals(expectedBC, pathBC);
        assertThat(pathBC, is(expectedBC));
        assertEquals(2, graph.getWeight(pathBC));

        List<Node> pathBA = dijkstra.getPath(A);
        assertNull(pathBA);
    }
    @Test
    //Comprobamos que el peso es 0 si vas de un nodo a él mismo
    public void test3() {
    	Dijkstra dijkstra = new Dijkstra(graph, A);

        List<Node> pathAA = dijkstra.getPath(A);
        assertEquals(0, graph.getWeight(pathAA));

    }
    @Test
    //Comprobamos que si va de un nodo a él mismo, devuelve A
    public void test4() {
        Dijkstra dijkstra = new Dijkstra(graph,A);
        List<Node>esperado= new ArrayList<Node>();
        esperado.add(A);
        List<Node> pathA= dijkstra.getPath(A);
        assertEquals(esperado, pathA);
  
    }
    
}

