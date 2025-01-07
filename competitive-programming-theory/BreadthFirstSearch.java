import java.util.*;

public class BreadthFirstSearch {
    static void bfsIterative(List<List<Integer>> adj, int s) {
        Queue<Integer> queue = new LinkedList<>();

        boolean[] visited = new boolean[adj.size()];

        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int x  : adj.get(current)) {
                if (!visited[x]) {
                    visited[x] = true;
                    queue.add(x);
                }
            }
        }
    }

    static void addEdge(List<List<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        int V = 5;

        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 4);

        System.out.println("BFS starting from 0: ");
        bfsIterative(adj, 0);
    }
}
