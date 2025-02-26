import java.io.*;

/*
    Observations:

    - Given a length of an array n, integer k and another integer p, where we can pick a number i and x such that 1 <= i <= n
        and -p <= x <= p, if n = 1 and k > p, then this is impossible.
    - Adding on from the example above, if n = 2 and (k / 2) > p, then this is impossible

    - Theorem: given a length of an array m, a sum we must reach integer k, and another integer p, we can only solve
        this problem if (k / n) > p. If this holds, we can solve the problem using (k / p) + 1
 */

public class NewWorldNewMeNewArray2072A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            // Read first line
            String[] firstLine = reader.readLine().split(" ");
            double n = Double.parseDouble(firstLine[0]);
            double k = Double.parseDouble(firstLine[1]);
            double p = Double.parseDouble(firstLine[2]);

            // Check if this can be solved in the first place above using the theorem. If false, output -1 and continue
            // If true, output (k / p) + 1
            if (Math.abs(k / n) > p) {
                System.out.println(-1);
            } else {
                System.out.println((int) Math.ceil(Math.abs(k / p )));
            }
        }
    }
}
