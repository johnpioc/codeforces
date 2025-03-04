import java.io.*;
import java.util.*;

public class FarmerJohnsCardGame2060B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t=1; t<=testCases; t++) {
            // Read n and m
            String[] firstLine = reader.readLine().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            int m = Integer.parseInt(firstLine[1]);

            // Create priority queue of 2 integer arrays: 1st element is the cow number, second element is the card
            // number.
            PriorityQueue<int[]> cards = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));

            // Read next n lines, and place cards onto priority queue
            for (int i = 0; i < n; i++) {
                String[] currentLine = reader.readLine().split(" ");
                for (String card : currentLine) {
                    cards.offer(new int[] { i + 1, Integer.parseInt(card) });
                }
            }

            // Get initial order and go through priority queue to make sure that for every n cows, the order holds
            int[] order = new int[n];
            boolean isValid = true;
            while (!cards.isEmpty()) {
                int[] currentCard = cards.poll();
                if (currentCard[1] <= n - 1) {
                    for (int i = 0; i < currentCard[1]; i++) {
                        if (order[i] == currentCard[0]) {
                            isValid = false;
                            break;
                        }
                    }

                    if (!isValid) break;
                    order[currentCard[1]] = currentCard[0];
                } else {
                    if (order[currentCard[1] % n] != currentCard[0]) {
                        isValid = false;
                        break;
                    }
                }
            }

            if (isValid) {
                for (int cow : order) {
                    System.out.print(cow + " ");
                }
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
