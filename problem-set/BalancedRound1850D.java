import java.io.*;
import java.util.*;

public class BalancedRound1850D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 0; testCase < testCases; testCase++) {
            String[] line = reader.readLine().split(" ");

            int n = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);

            String[] problemsString = reader.readLine().split(" ");

            int[] problems = new int[n];

            for (int i = 0; i < n; i++) {
                problems[i] = Integer.parseInt(problemsString[i]);
            }

            Arrays.sort(problems);

            int maxCorrectQuestions = 0;
            int currentCount = 0;

            for (int i = 0; i < n - 1; i++) {
                int currentProblem = problems[i];
                int nextProblem = problems[i + 1];

                int difference = nextProblem - currentProblem;

                if (difference <= k) {
                    currentCount++;
                } else {
                    if (maxCorrectQuestions < currentCount) {
                        maxCorrectQuestions = currentCount;
                    }
                    currentCount = 0;
                }
            }

            if (maxCorrectQuestions < currentCount) {
                maxCorrectQuestions = currentCount;
            }

            System.out.println(n - maxCorrectQuestions - 1);
        }
    }
}
