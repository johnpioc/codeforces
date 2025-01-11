import java.io.*;
import java.util.*;

public class PoweringTheHero1800C1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 0; t < testCases; t++) {
            int n = Integer.parseInt(reader.readLine());

            // Max-heap to keep track of the largest cards
            PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            long maxPower = 0;

            String[] cards = reader.readLine().split(" ");

            for (String card : cards) {
                long currentCard = Long.parseLong(card);

                if (currentCard == 0) {
                    // Only poll from the heap if it is not empty
                    if (!maxHeap.isEmpty()) {
                        maxPower += maxHeap.poll();
                    }
                } else {
                    // Add the current card to the max-heap
                    maxHeap.add(currentCard);
                }
            }

            System.out.println(maxPower);
        }
    }
}
