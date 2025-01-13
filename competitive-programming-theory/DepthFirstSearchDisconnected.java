import java.util.*;

public class DepthFirstSearchDisconnected {
    static void addEdge(List<List<Integer>> adj, int s, int t) {
        adj.get(s).add(t);
        adj.get(t).add(s);
    }

    static void DFSRec(List<List<Integer>> adj, boolean[] visited, int s) {
        visited[s] = true;
        System.out.print(s + " ");

        for (int i : adj.get(s)) {
            if (!visited[i]) {
                DFSRec(adj, visited, i);
            }
        }
    }

    static void DFS(List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFSRec(adj, visited, i);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        int[][] edges
                = { { 1, 2 }, { 2, 0 }, { 0, 3 }, { 4, 5 } };

        for (int[] edge: edges) {
            addEdge(adj, edge[0], edge[1]);
        }

        System.out.println("Complete DFS of the graph: ");
        DFS(adj, V);
    }
}
