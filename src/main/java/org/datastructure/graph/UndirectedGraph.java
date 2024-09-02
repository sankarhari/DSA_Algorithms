package org.datastructure.graph;

import java.util.*;

public class UndirectedGraph {

    private Map<String, Set<String>> graph = new HashMap<>();
    private String sourceVertex;

    public void setSourceVertex(String vertex){
        if(!this.graph.containsKey(vertex))
        {
            throw new RuntimeException("Given vertex \"" + vertex + "\" not found in graph.");
        }

        this.sourceVertex = vertex;
    }

    public void addVertex(String vertex){
        this.graph.putIfAbsent(vertex, new HashSet<>());
    }

    public void addVertexes(String... vertexes){
        for(String vertex: vertexes){
            this.graph.putIfAbsent(vertex, new HashSet<>());
        }
    }

    public void addEdge(String source, String destination){
        if(!this.graph.containsKey(source) || !this.graph.containsKey(destination)){
            throw new RuntimeException("Both source \"" + source + "\" and destination \"" + destination + "\" vertex must exist in the graph");
        }

        this.graph.get(source).add(destination);
        this.graph.get(destination).add(source);
    }

    public void removeVertex(String vertex){
        if(!this.graph.containsKey(vertex))
        {
            throw new RuntimeException("Given vertex \"" + vertex + "\" not found in graph.");
        }

        for(String destination: this.graph.get(vertex)){
            this.graph.get(destination).remove(vertex);
        }

        this.graph.remove(vertex);
    }

    public void removeEdge(String source, String destination){
        if(!this.graph.containsKey(source) || !this.graph.containsKey(destination)){
            throw new RuntimeException("Both source \"" + source + "\" and destination \"" + destination + "\" vertex must exist in the graph");
        }

        this.graph.get(source).remove(destination);
        this.graph.get(destination).remove(source);
    }

    public void print(){
        for(String vertex: this.graph.keySet()){
            System.out.print(vertex + " -> ");
            System.out.println( String.join(", ", this.graph.get(vertex)));
        }
    }

    public void breadthFirstSearch(){
        List<String> visited = new ArrayList<>();
        List<String> traversal = new ArrayList<>();
        breadthFirstSearch(traversal, visited);
        System.out.println(String.join(", ", traversal));
    }

    public void breadthFirstSearch(List<String> traversal,List<String> visited){
        Queue<String> bfsQueue = new LinkedList<>();
        bfsQueue.add(this.sourceVertex);
        while(!bfsQueue.isEmpty())
        {
            String currentVertex = bfsQueue.poll();
            traversal.add(currentVertex);
            visited.add(currentVertex);
            for(String vertex: this.graph.get(currentVertex)){
                if(!visited.contains(vertex) && !bfsQueue.contains(vertex))
                    bfsQueue.add(vertex);
            }
        }
    }

    public void depthFirstSearch(){
        List<String> visited = new ArrayList<>();
        List<String> traversal = new ArrayList<>();
        depthFirstSearch(traversal,visited);
        System.out.println(String.join(", ", traversal));
    }

    public void depthFirstSearch(List<String> traversal, List<String> visited){

        Stack<String> dfsStack = new Stack<>();
        dfsStack.push(this.sourceVertex);
        while(!dfsStack.isEmpty()){
            String currentVertex = dfsStack.pop();
            traversal.add(currentVertex);
            visited.add(currentVertex);
            for(String vertex: this.graph.get(currentVertex)){
                if(!visited.contains(vertex) && !dfsStack.contains(vertex))
                    dfsStack.push(vertex);
            }
        }
    }

    public void isReachable(String source, String destination){
        List<String> path = new ArrayList<>();
        List<String> visited = new ArrayList<>();
        boolean answer = isReachable(source, destination, path, visited);
        if(answer){
            System.out.println("\"" + source + "\" -> \"" + destination + "\" is reachable.");
            System.out.println("Path: " + String.join("->",path));
        }
        else{
            System.out.println("\"" + source + "\" -> \"" + destination + "\" is not reachable.");
        }
    }

    public boolean isReachable(String source, String destination, List<String> path,List<String> visited){
        if(source.equals(destination))
        {
            path.add(source);
            return true;
        }
        visited.add(source);
        path.add(source);
        boolean answer = false;
        for(String vertex: this.graph.get(source)){
            if(!visited.contains(vertex)) {
                answer = answer || isReachable(vertex, destination, path, visited);
            }
        }
        return answer;
    }

}
