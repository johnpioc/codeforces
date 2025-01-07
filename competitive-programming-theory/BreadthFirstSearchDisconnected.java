import java.util.*;

public class BreadthFirstSearchDisconnected {
    public static void bfsDisconnected(List<List<Integer>> adj) {
        boolean[] visited = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                bfs(adj, i, visited);
            }
        }
    }

    public static void bfs(List<List<Integer>> adj, int s, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int x : adj.get(current)) {
                if (!visited[x]) {
                    visited[x] = true;
                    queue.add(x);
                }
            }
        }
    }

    public static void addEdge(List<List<Integer>> adj, int u , int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 5);

        bfsDisconnected(adj);
    }
}
