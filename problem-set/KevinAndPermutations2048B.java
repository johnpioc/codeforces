import java.io.*;

/*
    Logic:

    - Given an integer n, if want to minimise the value within a subarray of length k, we have to come up with
    - the lowest values of n. For example, if n = 4 and k = 2. There are 3 possible subarrays - 1 and 2 should be the
    - highest priority for those subarrays
 */

public class KevinAndPermutations2048B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            String[] firstLine = reader.readLine().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            int k = Integer.parseInt(firstLine[1]);
            int minsPlaced = 0;

            for (int i = 1; i <= n; i++) {
                int currentNum;

                if (i % k == 0) {
                    currentNum =  i / k;
                    minsPlaced += 1;
                } else {
                    currentNum = (n / k) + i - minsPlaced;
                }

                System.out.print(currentNum + " ");
            }
            System.out.println();
        }
    }
}
