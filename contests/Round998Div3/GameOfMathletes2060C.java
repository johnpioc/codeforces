import java.io.*;
import java.util.Map;
import java.util.HashMap;

public class GameOfMathletes2060C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t<=testCases; t++) {
            // Read n and k
            String[] firstLine = reader.readLine().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            int k = Integer.parseInt(firstLine[1]);

            // Read second line and split into array of strings
            String[] secondLine = reader.readLine().split(" ");

            // Initialise int array of values aas well as an integer score
            int score = 0;
            int[] seen = new int[2*n];

            // Traverse through second line, and for each,
            //  a. Find complementary number = k - currentNumber
            //  b. If this is inside the hashtable, remove it and add 1 to the score
            //  c. If not, add to hashtable
            for (String numberString : secondLine) {
                int currentNum = Integer.parseInt(numberString);
                int complement = k - currentNum;
                if (complement <= 0) {
                    continue;
                }
                if (seen[complement - 1] > 0) {
                    seen[complement - 1]--;
                    score++;
                } else {
                    seen[currentNum - 1]++;
                }
            }

            // Output score
            System.out.println(score);
        }
    }
}
