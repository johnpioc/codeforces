import java.io.*;
import java.util.*;

/*
    We are given number of stations n and Alice's station s. Bob lives at station 1

    The second line contains n integers. This represents the train line going from station 1 to n The ith station is
    open if it is 1, and closed if 0

    The third line contains n integers. This represents the train line going from station n to 1.

    Output: print "YES" if Bob can travel from station 1 to Alice's house in station s

    Algorithm:

    1. Read n and s
    2. Initialise List of Integer Lists for adjacency list of length n
    3. Read second line and traverse through it, for each
        a. Take note of the last station that was 1 (open)
        b. Once you come across a new station that is 1 (open), add current station as a connection
            to the previous open station
    4. Read third line, traverse through it backwards and do the same as above.
    5. Perform Depth First Search with source 1 to see if there is a path to node s
*/

public class Metro1055A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = reader.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int s = Integer.parseInt(firstLine[1]);

        List<List<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(i, new ArrayList<>());
        }

        String[] secondLine = reader.readLine().split(" ");
        String[] thirdLine = reader.readLine().split(" ");

        int lastOpenStation = 0;

        for (int i = 1; i <= n; i++) {
            int currentStation = Integer.parseInt(secondLine[i - 1]);

            if (currentStation == 1) {
                if (lastOpenStation != 0) {
                    adj.get(lastOpenStation - 1).add(i);
                }

                lastOpenStation = i;
            }
        }

        lastOpenStation = 0;

        for (int i = n - 1; i >= 0; i--) {
            int currentStation = Integer.parseInt(thirdLine[i]);

            if (currentStation == 1) {
                if (lastOpenStation != 0) {
                    adj.get(lastOpenStation - 1).add(i + 1);
                }

                lastOpenStation = i + 1;
            }
        }

        boolean[] visited = new boolean[n];
        boolean canTravelTo = depthFirstSearch(adj, visited, 1, s);

        if (canTravelTo) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean depthFirstSearch(List<List<Integer>> adj, boolean[] visited, int source, int dest) {
        if (source == dest) {
            return true;
        }

        visited[source - 1] = true;

        for (int i : adj.get(source - 1)) {
            if (!visited[i - 1]) {
                if (depthFirstSearch(adj, visited, i, dest)) {
                    return true;
                }
            }
        }

        return false;
    }
}
