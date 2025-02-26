import java.io.*;
import java.util.StringTokenizer;

/*
    Observations:

    - The ordering of characters DOES matter, but we are able rearrange the string to maximise the value
    - We should count the number of occurences for each character

    - Theorem: the optimal way of rearranging the string is to distribute the hyphens evenly among the sides, and all
        the underscores in the middle.
    - To count the number of subsequences, we can count the number of hyphens a and number of underscores b.
        Then, find x = ceil(a / 2) and y = floor(a/2), in which the number of sequences is x * y * b
 */

public class HavingBeenATreasurerInThePastIHelpGoblinsDeceive2072B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine());

            String secondLine = reader.readLine();
            long a = 0;
            long b = 0;

            for (int i = 0; i < secondLine.length(); i++) {
                if (secondLine.charAt(i) == '-') {
                    a += 1;
                } else if (secondLine.charAt(i) == '_') {
                    b += 1;
                }
            }

            long x = a / 2;
            long y = (a + 1) / 2;

            System.out.println(x * y * b);

        }
    }
}
