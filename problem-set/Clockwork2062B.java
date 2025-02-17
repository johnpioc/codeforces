import java.io.*;

/*
    Algorithm:

    For each test case:

    1. Read number of clocks, n
    2. Read second line of clocks and store as a string array
    3. Traverse though string array of clocks, for each:
        a. Check that the current value is greater than 2 * max(i, n - i - 1)
        b. If false, output "NO" and continue
    4. If all are true, output "YES" and continue

 */

public class Clockwork2062B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int numOfClocks = Integer.parseInt(reader.readLine());

            String[] clocks = reader.readLine().split(" ");
            boolean isDefinite = false;

            for (int i = 0; i < clocks.length; i++) {
                int currentTime = Integer.parseInt(clocks[i]);

                if (currentTime <= 2 * Math.max(i, numOfClocks - i - 1)) {
                    isDefinite = true;
                    break;
                }
            }

            if (isDefinite) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
