import java.io.*;

/*
    Observations:

    - To play optimally, a player's first preference for a move should be to move towards the end closest to the other
        player
    - It can be seen that if both Alice and Bob have the same parity, Alice will always win, otherwise, Bob will win
 */

public class TwoFrogs2055A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            // Read line set variables n - number of lilypads, a - starting position of alice, b starting position of bob
            String[] firstLine = reader.readLine().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            int a = Integer.parseInt(firstLine[1]);
            int b = Integer.parseInt(firstLine[2]);

            // Compare parity of Alice and Bob. If they're the same, Alice will win, if not, Bob will win
            if (a % 2 == b % 2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
