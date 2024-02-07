package hw5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class NumPaths {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/astowwe/source/Algorithms/src/hw5/InputFilesP2/input-1.1"));
        String[] firstLine = scanner.nextLine().split(" ");
        int numVertices = Integer.parseInt(firstLine[0]);
        int numEdges = Integer.parseInt(firstLine[1]);
        String[] secondLine = scanner.nextLine().split(" ");
        int start = Integer.parseInt(secondLine[0]);
        int target = Integer.parseInt(secondLine[1]);

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= numVertices; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < numEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] dist = new int[numVertices+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        int[] count = new int[numVertices+1];
        count[start] = 1;

        Queue<Integer> queue = new java.util.LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int u : adj.get(v)) {
                if (dist[u] > dist[v] + 1) {
                    dist[u] = dist[v] + 1;
                    count[u] = count[v];
                    queue.offer(u);
                } else if (dist[u] == dist[v] + 1) {
                    count[u] += count[v];
                }
            }
        }

        System.out.println(count[target]);
    }
}
