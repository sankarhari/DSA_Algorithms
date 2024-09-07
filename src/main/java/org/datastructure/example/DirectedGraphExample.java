package org.datastructure.example;

import org.datastructure.graph.impl.DirectedGraph;
import org.datastructure.graph.impl.UndirectedGraph;

public class DirectedGraphExample {

    public static void main(String[] args){
        DirectedGraph graph = new DirectedGraph();

        graph.addVertexes("A", "B", "C", "D", "E", "F", "G", "H", "I");

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

//        graph.removeVertex("A");
//        graph.removeEdge("A", "D");
//        graph.print();
        System.out.print("BFS: ");
        graph.breadthFirstSearch();

        System.out.print("DFS: ");
        graph.depthFirstSearch();

        graph.isReachable("A","H");

        UndirectedGraph graph2 = new UndirectedGraph();

        graph2.addVertexes("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");

        graph2.setSourceVertex("1");

        graph2.addEdge("1", "3");
        graph2.addEdge("1","7");
        graph2.addEdge("3","7");
        graph2.addEdge("4","9");
        graph2.addEdge("8","5");
        graph2.addEdge("6","8");
        graph2.addEdge("5","10");
        graph2.addEdge("6","10");
        graph2.print();

        graph2.numberOfProvinces();
    }
}
