import java.io.*;
import java.util.*;

/*
    Algorithm:

    For each test case

    1. Read number of kids n
    2. Initialise directed adjacency list adj
    3. Read second line and traverse through it, for each
        a. Add its connection to adjacency list
    4. Traverse through second line again, and perform depth first search with itself as the source
    and destination

 */

public class BooksExchange1249B1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());

            int[] adj = new int[n];

            String[] connections = reader.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                int connection = Integer.parseInt(connections[i]);
                adj[i] = connection - 1;
            }

            for (int i = 0; i < n; i++) {
                int numOfSteps = depthFirstSearch(adj, i, i, 0);
                System.out.print(numOfSteps + " ");
            }
            System.out.println();
        }
    }

    public static int depthFirstSearch(int[] adj, int source, int dest, int numOfSteps) {
        if (source == dest && numOfSteps != 0) {
            return numOfSteps;
        }

        int nextStep = adj[source];
        numOfSteps++;
        return depthFirstSearch(adj, nextStep, dest, numOfSteps);
    }
}
