package org.datastructure.graph;

import java.util.List;

public class Example {

    public static void main(String[] args){
        UndirectedGraph graph = new UndirectedGraph();

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
    }
}
