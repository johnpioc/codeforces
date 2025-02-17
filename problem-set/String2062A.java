import java.io.*;
import java.util.*;

/*
    Logic:

    1. We can implement sliding window to determine what subsequence of s needs to be converted to 0, also ensuring
        that current 0's do not get touched

    Algorithm:

    For each test case:

    1. Read the sequence s, and initialise variables start = 0, and end = s.length - 1
    2. Traverse through s front to back, using i, and only stop when we encounter a 1. Set start = i
        a. If the whole s is traversed without breaking prematurely, output 0 and continue
    3. Traverse through s back to front, using i, only stop when we encounter a 1. Set end = i
    4. Initialise, numOfOperations = 0
    4. While start != end:
        a. Initialise list of size s.length, toSwitch and increment numOfOperations
        b. Traverse s from indexes start to end, identifying alternating 1 and 0's
        c. For each alternating 1 and 0 (start with 1), write its curent position to toSwitch
        d. Using toSwitch, switch all elements at the given positions from 0 to 1 or vice versa
        e. Now, traverse through s from front to back and set start to the position of the first 1
        f. Do the same for end, traversing from front to back
    5. Output numOfOperations + 1

 */

public class String2062A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            String[] s = reader.readLine().split("");

            int start = Integer.MIN_VALUE;
            int end = Integer.MAX_VALUE;

            for (int i = 0; i < s.length; i++) {
                if (s[i].equals("1")) {
                    start = i;
                    break;
                }
            }

            if (start == Integer.MIN_VALUE) {
                System.out.println(0);
                continue;
            }

            for (int i = s.length - 1; i >= 0; i--) {
                if (s[i].equals("1")) {
                    end = i;
                    break;
                }
            }

            int numOfOperations = 0;

            while (start != end) {
                numOfOperations++;

                int newStart = start;
                int newEnd = end;

                boolean lastIsZero = true;

                for (int i = start; i < end + 1; i++) {
                    if (lastIsZero && s[i].equals("1")) {
                        s[i] = "0";
                        lastIsZero = false;
                    } else if (!lastIsZero && s[i].equals("0")) {
                        s[i] = "1";
                        lastIsZero = true;
                    }


                }

                for (int i = start; i < end + 1; i++) {
                    if (s[i].equals("1")) {
                        newStart = i;
                        break;
                    }
                }

                for (int i = end; i >= start; i--) {
                    if (s[i].equals("1")) {
                        newEnd = i;
                        break;
                    }
                }

                start = newStart;
                end = newEnd;
            }

            System.out.println(numOfOperations + 1);
        }
    }
}
