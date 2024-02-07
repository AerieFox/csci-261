package hw5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class ConnectGraph{

    private static List<List<Integer> > adj;
    private static boolean[] visited;
    public static void addEdge(int v, int w)
    {
        adj.get(v).add(w);
        adj.get(w).add(v);
    }
    public static List<Integer> BFS(int src) {
        List<Integer> queue = new ArrayList<>();
        queue.add(src);
        visited[src] = true;
        List<Integer> reachableNodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.remove(0);
            reachableNodes.add(u);
            for (int itr : adj.get(u)) {
                if (visited[itr] == false) {
                    visited[itr] = true;
                    queue.add(itr);
                }
            }
        }
        return reachableNodes;
    }

    public static int connectGraph() {
        int numComponents = -1;

        while(true) {
            for(int i = 1; i < visited.length; i++) {
                if(visited[i] == false) {
                    BFS(i);
                    numComponents++;
                    i = 0;
                }
            }
            return numComponents;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("/Users/astowwe/source/Algorithms/src/hw5/InputFilesP1/input-1.3"));
        String[] firstLine = scanner.nextLine().split(" ");
        int numVertices = Integer.parseInt(firstLine[0]);
        int numEdges = Integer.parseInt(firstLine[1]);
        int[][] edges = new int[numEdges][];
        for(int i = 0; i < numEdges; i++) {
            String[] curLine = scanner.nextLine().split(" ");
            edges[i] = new int[]{Integer.parseInt(curLine[0]), Integer.parseInt(curLine[1])};
        }

        visited = new boolean[numVertices+1];
        adj = new ArrayList<>();
        for (int i = 0; i < numVertices + 1; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            addEdge(edge[0], edge[1]);
        }

        System.out.println(connectGraph());
    }
}

// This code is contributed by 29AjayKumar

