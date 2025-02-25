import java.io.*;

/*
    Observations:

    - In all cases where n >= 2, we always need to change the first and last index to 0. This is
        so that we can use the 2nd operation as much as possible
    - After doing the above, we can change the 4th position to 1, which makes positions 1-4 all 1
        via second operation
    - After doing the above, we can change the 10th position to 1, which makes positions 1-10 all 1
        via second operation

    - Theorem: if we have a number n of leading 1's starting from the 1st position,
        we can put a 1 at (n + 1)*2 and use the second operation to make all elements from
        1 to (n + 1)*2 all one
 */

public class PaintAStrip2040B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            // Read length of array, n
            int n = Integer.parseInt(reader.readLine());

            // If length of array is 1 or 2, output 1 or 2 respectively and continue
            if (n <= 2) {
                System.out.println(n);
                continue;
            }

            // else, initialise variable numOfLeadingOnes = 1 and numOfFirstOperations = 2, signifying
            //   we have put a 1 in the first position, and in the last position
            int numOfLeadingOnes = 1;
            int numOfFirstOperations = 2;

            // While numOfLeadingOnes + 1 < getConstraint(n, numOfLeadingOnes),
            //  via the theorem above, let numOfLeadingOnes = (numOfLeadingOnes + 1) * 2 and
            // numOfFirstOperations += 1
            int constraint = getConstraint(n, 1);
            while (numOfLeadingOnes + 1 < constraint) {
                numOfLeadingOnes = (numOfLeadingOnes + 1) * 2;
                numOfFirstOperations += 1;
            }

            System.out.println(numOfFirstOperations);
        }
    }

    public static int getConstraint(int lengthOfArray, int startPosition) {
        return (int) Math.ceil((lengthOfArray - startPosition + 1) / 2.0);
    }
}
