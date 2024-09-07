package org.datastructure.graph;

import java.util.List;

public interface GraphOperations {
    void setSourceVertex(String vertex);
    void addVertex(String vertex);
    void addVertexes(String... vertexes);
    void addEdge(String source, String destination);
    void removeVertex(String vertex);
    void removeEdge(String source, String destination);
    void print();
    List<String> breadthFirstSearch();
    List<String> depthFirstSearch();
    boolean isReachable(String source, String destination);
    int numberOfProvinces();
}
