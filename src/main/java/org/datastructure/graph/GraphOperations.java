package org.datastructure.graph;

public interface GraphOperations {
    void setSourceVertex(String vertex);
    void addVertex(String vertex);
    void addVertexes(String... vertexes);
    void addEdge(String source, String destination);
    void removeVertex(String vertex);
    void removeEdge(String source, String destination);
    void print();
    void breadthFirstSearch();
    void depthFirstSearch();
    void isReachable(String source, String destination);
    void numberOfProvinces();
}
