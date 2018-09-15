import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Dijkstra {
    public static void main(String args[]) {
        int[][] graph = new int[][]{
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        runDijkstra(graph, 0);
    }

    public static void runDijkstra(int[][] graph, int src) {
        int[] d = new int[graph.length];
        Set<Integer> visitedNodes = new HashSet<>();
        Arrays.fill(d, Integer.MAX_VALUE);
        d[src] = 0;
        while (visitedNodes.size() < graph.length) {
            // Get the node that currently has the smallest distance.
            int smallestIndex = 0;
            // Find first not visited node;
            while (visitedNodes.contains(smallestIndex)) {
                smallestIndex++;
            }
            for (int i = 1 ; i < graph.length ; i++) {
                if (!visitedNodes.contains(i) && d[i] < d[smallestIndex]) {
                    smallestIndex = i;
                }
            }
            // Mark it.
            visitedNodes.add(smallestIndex);
            // Check all adjacent vertices, 
            for (int col = 0 ; col < graph[smallestIndex].length ; col++) {
                if (graph[smallestIndex][col] == 0) {
                    continue;
                }
                if (d[smallestIndex] + graph[smallestIndex][col] < d[col]) {
                    d[col] = d[smallestIndex] + graph[smallestIndex][col];
                }
            }
        }
        System.out.printf("Target Node                   Shortest Distance\n");
        for (int i = 0 ; i < d.length ; i++) {
            System.out.printf("%d                                 %d\n", i, d[i]);
        }
    }
}