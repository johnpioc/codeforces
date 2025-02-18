import java.io.*;
import java.util.*;

/*
    Algorithm:

    For each test case:
    1. Read first line and set variables n and m
    2. Initialise integer array of integer arrays, cards. Format: for each element, there is an integer array where the
        the first element is the nth cow, and the second element is the card number from that cow
    3. Read through the next n lines and add them into cards
    4. Sort cards array by card number (second element)
    5. Traverse through cards, keeping an eye on the first n elements to determine an order
        a. If the order has the same cow appearing twice, output "-1" and continue
        b. Once the order has been set, traverse through rest to check if order holds
        c. If order doesn't hold, output "-1" and continue
        d. If order does hold, output the order
 */

public class FarmerJohnsCardGame2060B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            String[] firstLine = reader.readLine().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            int m = Integer.parseInt(firstLine[1]);


            int[][] cards = new int[n*m][2];

            for (int i = 1; i <= n; i++) {
                String[] currentLine = reader.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    int currentCard = Integer.parseInt(currentLine[j]);
                    cards[(i - 1) * m + j][0] = i;
                    cards[(i - 1) * m + j][1] = currentCard;
                }
            }

            Arrays.sort(cards, (a,b) -> Integer.compare(a[1], b[1]));

            int[] order = new int[n];
            boolean isValid = true;

            for (int i = 0; i < cards.length; i++) {
                int[] currentCard = cards[i];
                if (i < n) {
                    for (int cow : order) {
                        if (cow == currentCard[0]) {
                            isValid = false;
                            break;
                        }
                    }
                    order[i] = currentCard[0];
                }

                if (!isValid) {
                    break;
                }

                if (i >= n) {
                    if (order[i % n] != currentCard[0]) {
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
