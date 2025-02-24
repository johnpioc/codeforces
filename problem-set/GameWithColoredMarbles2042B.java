import java.io.*;
import java.util.*;

/*
    Observations:

    - We can simulate the game as n <= 1000
    - To play optimally for both sides, the player should prioritise taking the marbles with the least
        amount of that specific colour, that way they can try to get the additional point for taking
        marbles for that colour
    - If alice and bob were playing optimally, Bob wouldn't let Alice take all the marbles for one
        colour, that is Alice can only get that additional point IF there is only one marble for a specific
        colour
    - We can create a priority queue for each marble colour and their frequency, starting from
        the least number of marbles to most, and simulate the game
 */

public class GameWithColoredMarbles2042B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            // Read number of marbles n
            int n = Integer.parseInt(reader.readLine());

            // Initialise hashtable to count number of marbles per colour
            Map<Integer, Integer> counts = new HashMap<>(n);

            // Read and traverse through second line, and count them within the hashtable
            StringTokenizer secondLine = new StringTokenizer(reader.readLine());

            while (secondLine.hasMoreTokens()) {
                int currentColour = Integer.parseInt(secondLine.nextToken());
                counts.put(currentColour,
                        counts.containsKey(currentColour) ? counts.get(currentColour) + 1 :
                        1);
            }

            // Traverse through entry sets in hashtable, and offer them to a priority queue that
            //  goes from least to most number of marbles for a given colour
            PriorityQueue<int[]> marbleColours = new PriorityQueue<>((x,y) -> Integer.compare(x[1], y[1]));

            for (Map.Entry<Integer, Integer> count : counts.entrySet()) {
                int[] marbleColour = new int[] { count.getKey(), count.getValue() };
                marbleColours.offer(marbleColour);
            }

            // Traverse and poll priority queue, and simulate game. Giving marbles to Alice and Bob
            //  and give them points too
            int alicePoints = 0;
            boolean aliceTurn = true;

            while (!marbleColours.isEmpty()) {
                int[] currentColour = marbleColours.poll();
                if (aliceTurn) {
                    if (currentColour[1] == 1) {
                        alicePoints += 2;
                        aliceTurn = false;
                    } else if (currentColour[1] % 2 == 0) {
                        alicePoints += 1;
                    } else if (currentColour[1] % 2 == 1) {
                        alicePoints += 1;
                        aliceTurn = false;
                    }
                } else {
                    if (currentColour[1] == 1) {
                        aliceTurn = true;
                    } else if (currentColour[1] % 2 == 0) {
                        alicePoints += 1;
                    } else if (currentColour[1] % 2 == 1) {
                        alicePoints += 1;
                        aliceTurn = true;
                    }
                }
            }

            System.out.println(alicePoints);
        }
    }
}
