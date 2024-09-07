package org.datastructure.graph;

import junit.framework.TestCase;
import org.datastructure.graph.impl.DirectedGraph;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class UndirectedGraphTest extends TestCase {

    private DirectedGraph createGraph(){
        DirectedGraph graph = new DirectedGraph();

        graph.addVertexes("A", "B", "C", "D", "E", "F", "G", "H", "I","J");

        graph.setSourceVertex("A");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B","D");
        graph.addEdge("B","F");
        graph.addEdge("D","I");
        graph.addEdge("F","E");
        graph.addEdge("E","H");
        graph.addEdge("D","G");
        graph.addEdge("G","H");
        graph.print();

        return graph;
    }

    public void testBreadthFirstSearch(){
        List<String> expected = List.of("A", "B", "C", "D", "F", "G", "I", "E", "H");
        DirectedGraph graph = createGraph();
        List<String> output = graph.breadthFirstSearch();
        assertIterableEquals(expected,output);
    }

    public void testDepthFirstSearch(){
        List<String> expected = List.of("A", "C", "B", "F", "E", "H", "D", "I", "G");
        DirectedGraph graph = createGraph();
        List<String> output = graph.depthFirstSearch();
        assertIterableEquals(expected,output);
    }

    public void testReachable(){
        boolean expected = true;
        DirectedGraph graph = createGraph();
        boolean output = graph.isReachable("A","H");
        assertEquals(expected, output);
    }

    public void testUnReachable(){
        boolean expected = false;
        DirectedGraph graph = createGraph();
        boolean output = graph.isReachable("A","J");
        assertEquals(expected, output);
    }

    public void testNumberOfProvinces(){
        int expected = 2;
        DirectedGraph graph = createGraph();
        int output = graph.numberOfProvinces();
        assertEquals(output,expected);
    }
}
