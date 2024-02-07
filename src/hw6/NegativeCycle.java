package hw6;

import java.io.*;
import java.util.Scanner;


class NegativeCycle {

    static void BellmanFord(Graph graph, int src) {
        int V = graph.V;
        int E = graph.E;
        int[] dist = new int[V];

        for (int i = 0; i < V; ++i) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int weight = graph.edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        for (int j = 0; j < E; ++j) {
            int u = graph.edge[j].src;
            int v = graph.edge[j].dest;
            int weight = graph.edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/astowwe/source/Algorithms/src/hw6/inputFiles/input-1.3"));
        String[] firstLine = scanner.nextLine().split(" ");
        int numVertices = Integer.parseInt(firstLine[0]);
        int numEdges = Integer.parseInt(firstLine[1]);
        Graph graph = new Graph(numVertices, numEdges);
        for(int i = 0; i < numEdges; i++) {
            String[] curLine = scanner.nextLine().split(" ");
            graph.edge[i].src = Integer.parseInt(curLine[0])-1;
            graph.edge[i].dest = Integer.parseInt(curLine[1])-1;
            graph.edge[i].weight = Integer.parseInt(curLine[2]);
        }
        BellmanFord(graph, 0);
    }
}

