import java.util.*;

public class Code {
    // Graph class to represent a directed graph
    static class Graph {
        private Map<Integer, List<Integer>> adjList;

        // Constructor to initialize the graph
        public Graph() {
            adjList = new HashMap<>();
        }

        // Add a vertex to the graph
        public void addVertex(int vertex) {
            adjList.putIfAbsent(vertex, new ArrayList<>());
        }

        // Add an edge from vertex 'u' to vertex 'v'
        public void addEdge(int u, int v) {
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(u).add(v);
        }

        // Depth First Search (DFS) recursive method
        public void dfs(int start) {
            Set<Integer> visited = new HashSet<>();
            dfsHelper(start, visited);
        }

        // Helper function for DFS to manage recursion
        private void dfsHelper(int vertex, Set<Integer> visited) {
            if (visited.contains(vertex)) {
                return;
            }
            System.out.print(vertex + " ");
            visited.add(vertex);
            for (int neighbor : adjList.get(vertex)) {
                dfsHelper(neighbor, visited);
            }
        }

        // Method to display the graph's adjacency list
        public void displayGraph() {
            for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
                System.out.print(entry.getKey() + " -> ");
                for (Integer neighbor : entry.getValue()) {
                    System.out.print(neighbor + " ");
                }
                System.out.println();
            }
        }
    }

    // Main class to test the Graph implementation
    public static void main(String[] args) {
        Graph graph = new Graph();
        
        // Adding vertices
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        
        // Adding edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        
        // Displaying the graph
        System.out.println("Graph adjacency list:");
        graph.displayGraph();

        // Performing DFS traversal starting from vertex 0
        System.out.println("\nDFS traversal starting from vertex 0:");
        graph.dfs(0);
    }
}
