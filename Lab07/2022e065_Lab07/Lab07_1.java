// 2022/E/065
// Lab07 Part01

import java.util.ArrayList;
import java.util.Scanner;

public class Lab07_1 {    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		
        System.out.print("Enter the number of vertices: ");
        int vertexCount = scanner.nextInt();
        scanner.nextLine(); 

        Graph g = new Graph(vertexCount);

        System.out.println("Enter the vertex names:");
        for (int i = 0; i < vertexCount; i++) {
            String vertexName = scanner.nextLine();
            g.addVertex(vertexName);
        }

        System.out.print("Enter the number of edges: ");
        int edgeCount = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the edges in the format (u v weight):");
        for (int i = 0; i < edgeCount; i++) {
            String u = scanner.next();
            String v = scanner.next();
            int weight = scanner.nextInt();
            g.addEdge(u, v, weight);
        }

        g.printAdjList();

        g.primMST();

        scanner.close();
    }
}

// Graph class
class Graph {
    private ArrayList<ArrayList<Edge>> adjList; // List of adjacency lists
    private ArrayList<String> vertices;          // List of vertex names  

    Graph(int v) { // v - vertices
        adjList = new ArrayList<>();
        vertices = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>()); // adjacency lists
        }
    }

    public void addVertex(String vertex) {
        vertices.add(vertex); // Add vertex 
    }

    public void addEdge(String u, String v, int w) {
        int uIndex = vertices.indexOf(u);
        int vIndex = vertices.indexOf(v);

        adjList.get(uIndex).add(new Edge(v, w)); // Add edge u -> v
        adjList.get(vIndex).add(new Edge(u, w)); // Add edge v -> u 
    }

    public void printAdjList() {
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print("Adj list of vertex " + vertices.get(i) + ": ");
            for (Edge edge : adjList.get(i)) {
                System.out.print("[" + edge.vertex + ", weight: " + edge.weight + "] ");
            }
            System.out.println();
        }
    }

    public void primMST() {
        int n = vertices.size();
        int[] key = new int[n];
        int[] parent = new int[n];
        boolean[] inMST = new boolean[n];

        for (int i = 0; i < n; i++) {
            key[i] = Integer.MAX_VALUE;
            parent[i] = -1; // Initialize parent to -1 (no parent)
            inMST[i] = false;
        }

        key[0] = 0;  // Starting from vertex 0

        // Loop to construct the MST
        for (int count = 0; count < n - 1; count++) {
            int u = minKey(key, inMST);

            inMST[u] = true;

            for (Edge edge : adjList.get(u)) {
                int vIndex = vertices.indexOf(edge.vertex);
                if (!inMST[vIndex] && edge.weight < key[vIndex]) {
                    key[vIndex] = edge.weight;
                    parent[vIndex] = u;
                }
            }
        }

        // Print MST
        System.out.println("Edge \tWeight");
        for (int i = 1; i < n; i++) {
            System.out.println(vertices.get(parent[i]) + " - " + vertices.get(i) + "\t" + key[i]);
        }
    }

    private int minKey(int[] key, boolean[] inMST) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < vertices.size(); i++) {
            if (!inMST[i] && key[i] < min) {
                min = key[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}

// Edge class
class Edge {
    String vertex;
    int weight;

    Edge(String vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}
