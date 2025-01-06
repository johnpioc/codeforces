import java.io.*;

public class PreparingForTheOlympiad2051A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = Integer.parseInt(reader.readLine());

            String[] monocarpTrainingDays = reader.readLine().split(" ");
            String[] stereocarpTrainingDays = reader.readLine().split(" ");

            int mProblemsSolved = 0;
            int sProblemsSolved = 0;

            for (int i = 0; i < n - 1; i++) {
                if (Integer.parseInt(monocarpTrainingDays[i]) > Integer.parseInt(stereocarpTrainingDays[i + 1])) {
                    mProblemsSolved += Integer.parseInt(monocarpTrainingDays[i]);
                    sProblemsSolved += Integer.parseInt(stereocarpTrainingDays[i + 1]);
                }
            }

            mProblemsSolved += Integer.parseInt(monocarpTrainingDays[n - 1]);

            int difference = mProblemsSolved - sProblemsSolved;

            System.out.println(difference);
        }
    }
}
