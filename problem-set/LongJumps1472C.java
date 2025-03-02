import java.io.*;

public class LongJumps1472C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            // Read length of array n
            int n = Integer.parseInt(reader.readLine());

            // Read second line and convert to array of strings
            String[] a = reader.readLine().split(" ");

            // Initialise highestScore = 0 && runningScoreCache of length n;
            int highestScore = 0;
            int[] runningScoreCache = new int[n];

            // Traverse through array of strings, and for each
            //  Set j = current index. While j is less than n, add current value to score and add current value to j
            //  If score is higher the highestScore, set highestScore to score
            for (int i = 0; i < a.length; i++) {
                int score = getRunningScore(runningScoreCache, a, i);

                if (score > highestScore) {
                    highestScore = score;
                }
            }

            // Output highestScore
            System.out.println(highestScore);
        }
    }

    public static int getRunningScore(int[] cache, String[] a, int start) {
        if (cache[start] != 0) {
            return cache[start];
        }

        int startValue = Integer.parseInt(a[start]);

        if (start + startValue < a.length) {
            return cache[start] = startValue + getRunningScore(cache, a, start + startValue);
        } else {
            return cache[start] = startValue;
        }
    }
}
