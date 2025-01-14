import java.io.*;

/*
    We are given an array a of length n.

    You get one operation where you can pick an index from 1 to n - 2 inclusive, and do one
    of the following actions:

    1. Decrease index i - 1 by 1, then increase index i + 1 by 1
    2. Decrease index i + 1 by 1, then increase index i - 1 by 1

    After each operation, all the values must be non-negative.

    Output: print "YES" if its possible to make all the elements equal after any number of operations

     Algorithm:
     1. Read n
     2. Intialise variables:

        - integer oddSum - count the sum of numbers in odd positions
        - integer numOfOddNums - count the number of numbers in odd positions
        - integer evenSum - count the sum of numbers in even positions
        - integer numOfEvenNums - count the number of numbers in even positions

      3. Read second line and traverse through it. For each,

        - if i is odd, add to oddSum and increment number of odd nums
        - if i is even, add to evenSu, and increment number of even nums

      4. This test case can only output YES if these conditions are true:

        1. oddSum % numOfOddNums  == 0
        2. evenSum % numOfEvenNums == 0
        3. oddSum / numOfOddNums == evenSum / numOfEvenNums
 */

public class Transfusion2050B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());

            long oddSum = 0;
            long numOfOddNums = 0;
            long evenSum = 0;
            long numOfEvenNums = 0;

            String[] line = reader.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                if ((i + 1) % 2 == 1) {
                    oddSum += Long.parseLong(line[i]);
                    numOfOddNums++;
                } else {
                    evenSum += Long.parseLong(line[i]);
                    numOfEvenNums++;
                }
            }

            if (
                    oddSum % numOfOddNums == 0
                    && evenSum % numOfEvenNums == 0
                    && oddSum / numOfOddNums == evenSum / numOfEvenNums
            ) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
