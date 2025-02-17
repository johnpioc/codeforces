import java.io.*;

/*
 */

public class GameOfMathletes2060C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            String[] firstLine = reader.readLine().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            int k = Integer.parseInt(firstLine[1]);

            String[] secondLine = reader.readLine().split(" ");
            int[] availableNums = new int[Math.max(n,k)];

            int score = 0;

            for (String numString : secondLine) {
                int currentNum = Integer.parseInt(numString);

                int complementaryNum = k - currentNum;

                if (complementaryNum <= 0) {
                    continue;
                }

                if (availableNums[complementaryNum - 1] > 0) {
                    availableNums[complementaryNum - 1] -= 1;
                    score += 1;
                } else {
                    availableNums[currentNum - 1] += 1;
                }
            }

            System.out.println(score);
        }
    }
}
