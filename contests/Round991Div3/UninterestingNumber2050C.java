import java.io.*;

/*
    We are given a number n.

    We can pick any digit inside n, square it and replace it with the result, AS LONG AS the result
    is less than 10. (We can only square numbers 2 and 3.) (We can also square 1 but that would
    not do anything)

    Output: "YES" if after all operations, n is divisible by 9.

    Observations:

    - Theorem: given an integer n. If the sum of its individual digits are divisible by 9, then
        the whole integer is divisible by 9

     Logic:

     - We can read through the digits of the number and see if the sum of its digits add up to 9
     - If not, find the difference from its current sum and the closest divisor of 9
     - With that difference, see if we can add 2's or 6's to it to get to a divisor of 9

     Algorithm:

     1. Read line (number), initialise variable totalSum, numOfThrees and numOfTwos
     2. Traverse digit by digit, for each
        a. add digit to totalSum
        b. if digit is 3, numOfThrees++
        c. if digit is 2, numOfTwos++
     3. if totalsum is divisible by 9, output YES
     4. Loop from 0 to numOfThrees, variable i
        4a. Loop from 0 to numOfTwos, variable j
            4aa. Check if (totalSum mod 9 + (6 * i) mod 9 + (2 * j) mod 9) mod 9 == 0
            4ab. If yes, break all loops and output "YES"
     5. If loop has ended and not broken, output "NO"
 */

public class UninterestingNumber2050C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            String[] digits = reader.readLine().split("");

            long totalSum = 0;
            int numOfThrees = 0;
            int numOfTwos = 0;

            for (String digit : digits) {
                int currentDigit = Integer.parseInt(digit);

                totalSum += currentDigit;

                if (currentDigit == 3) {
                    numOfThrees++;
                }

                if (currentDigit == 2) {
                    numOfTwos++;
                }
            }

            if (totalSum % 9 == 0) {
                System.out.println("YES");
                continue;
            }

            boolean result = false;

            for (int i = 0; i <= numOfThrees; i++) {
                if (result) {
                    break;
                }
                for (int j = 0; j <= numOfTwos; j++) {
                    boolean divisibleBy9 = isDivisibleBy9(totalSum, i, j);
                    if (divisibleBy9) {
                        result = true;
                        break;
                    }
                }
            }

            if (result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean isDivisibleBy9(long totalSum, int numOfThrees, int numOfTwos) {
        return (totalSum % 9 + (6 * numOfThrees) % 9 + (2 * numOfTwos) % 9) % 9 == 0;
    }
}
