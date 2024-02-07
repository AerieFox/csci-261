package hw6;

public class Graph {

    int V, E;
    Edge edge[];

    class Edge {
        int src, dest, weight;
        Edge() { src = dest = weight = 0; }
    }

    Graph(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[e];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }


}
