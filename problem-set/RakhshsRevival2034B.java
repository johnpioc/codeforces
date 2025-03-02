import java.io.*;
import java.util.StringTokenizer;

/*
    Observations:

    - A sliding window would be probably be good to use here. It will be of size m
    - We can traverse the sliding window from back to front, and check that the total sum of the sliding window is
    - at least 1. If not, we can use the number at the very end and use Timar on it
 */

public class RakhshsRevival2034B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            // Read first line that consists of n, m and k
            String[] firstLine = reader.readLine().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            int m = Integer.parseInt(firstLine[1]);
            int k = Integer.parseInt(firstLine[2]);

            // Read second input as a string and convert to integer array
            String[] secondLine = reader.readLine().split("");
            int[] s = new int[n];

            for (int i = 0; i < n; i++) {
                s[i] = Integer.parseInt(secondLine[i]);
            }


            // Create a substring from index 0 to m (sliding window) and find its sum of 1's
            int start = 0;
            int end = m - 1;
            int sum = 0;

            for (int i = 0; i <= end; i++) {
                sum += s[i];
            }

            int numOfOperations = 0;

            // Traverse the sliding window from start to end, and for each iteration:
            //  a. Check if sliding window has a sum of at least 1. If false, apply Timar to the rightmost index
            //  b. If true, adjusts the start and end index by 1, adjust the substring and minus/add any new or taken
            //      away characters
            //  c. Everytime Timar is used, keep a record of it
            while (end != n) {
                if (sum == 0) {
                    numOfOperations++;
                    timar(s, end, k);
                    sum++;
                }

                sum -= s[start];
                if (end <= n - 2) {
                    sum += s[end + 1];
                }
                start++;
                end++;

            }

            // Output the number of times Timar was used
            System.out.println(numOfOperations);
        }
    }

    public static void timar(int[] s, int start, int k) {
        for (int i = start; i - start < k && i < s.length; i++) {
            s[i] = 1;
        }
    }
}
