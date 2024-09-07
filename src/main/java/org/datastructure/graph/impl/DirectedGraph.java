package org.datastructure.graph.impl;

import org.datastructure.graph.GraphOperations;

import java.util.*;

public class DirectedGraph implements GraphOperations {

    private Map<String, Set<String>> graph = new HashMap<>();
    private String sourceVertex;

    @Override
    public void setSourceVertex(String vertex){

        if(!this.graph.containsKey(vertex))
        {
            throw new RuntimeException("Given vertex \"" + vertex + "\" not found in graph.");
        }

        this.sourceVertex = vertex;
    }

    @Override
    public void addVertex(String vertex){
        this.graph.putIfAbsent(vertex, new HashSet<>());
    }

    @Override
    public void addVertexes(String... vertexes){
        for(String vertex: vertexes){
            this.graph.putIfAbsent(vertex, new HashSet<>());
        }
    }

    @Override
    public void addEdge(String source, String destination){
        if(!this.graph.containsKey(source) || !this.graph.containsKey(destination)){
            throw new RuntimeException("Both source \"" + source + "\" and destination \"" + destination + "\" vertex must exist in the graph");
        }

        this.graph.get(source).add(destination);
    }

    @Override
    public void removeVertex(String vertex){
        if(!this.graph.containsKey(vertex))
        {
            throw new RuntimeException("Given vertex \"" + vertex + "\" not found in graph.");
        }

        Set<String> vertexes = this.graph.keySet();
        for(String checkVertex: vertexes){
            this.graph.get(checkVertex).remove(vertex);
        }

        this.graph.remove(vertex);
    }

    @Override
    public void removeEdge(String source, String destination){
        if(!this.graph.containsKey(source) || !this.graph.containsKey(destination)){
            throw new RuntimeException("Both source \"" + source + "\" and destination \"" + destination + "\" vertex must exist in the graph");
        }

        this.graph.get(source).remove(destination);
    }

    @Override
    public void print(){
        for(String vertex: this.graph.keySet()){
            System.out.print(vertex + " -> ");
            System.out.println( String.join(", ", this.graph.get(vertex)));
        }
    }

    @Override
    public List<String> breadthFirstSearch(){
        List<String> visited = new ArrayList<>();
        List<String> traversal = new ArrayList<>();
        breadthFirstSearch(traversal, visited);
        System.out.println(String.join(", ", traversal));
        return traversal;
    }

    private void breadthFirstSearch(List<String> traversal,List<String> visited){
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

    @Override
    public List<String> depthFirstSearch(){
        List<String> visited = new ArrayList<>();
        List<String> traversal = new ArrayList<>();
        depthFirstSearch(traversal,visited);
        System.out.println(String.join(", ", traversal));
        return traversal;
    }

    private void depthFirstSearch(List<String> traversal, List<String> visited){

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

    @Override
    public boolean isReachable(String source, String destination){
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
        return answer;
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

    @Override
    public int numberOfProvinces(){
        Set<String> visited = new HashSet<>();
        Set<String> source = new HashSet<>();
        for(String vertex: this.graph.keySet()){

            if(!visited.contains(vertex)){
                source.add(vertex);
                numberOfProvinces(vertex, visited);
            }
        }
        System.out.println(source);
        System.out.println("Prince Count is: " + source.size());
        return source.size();
    }

    private void numberOfProvinces(String vertex, Set<String> visited)
    {
        if(!visited.contains(vertex)) {
            visited.add(vertex);
        }
        Set<String> destinations = this.graph.get(vertex);
        for(String destination: destinations) {
            if(!visited.contains(destination)) {
                numberOfProvinces(destination, visited);
            }
        }
    }
}
