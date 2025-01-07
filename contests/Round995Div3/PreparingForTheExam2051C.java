import java.io.*;

public class PreparingForTheExam2051C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String[] firstLine = reader.readLine().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            int m = Integer.parseInt(firstLine[1]);
            int k = Integer.parseInt(firstLine[2]);

            if (n - k >= 2) {
                for (int i = 0; i < m; i++) {
                    System.out.print("0");
                }
                reader.readLine();
                reader.readLine();
                System.out.println();
                continue;
            } else if (n == k) {
                for (int i = 0; i < m; i++) {
                    System.out.print("1");
                }
                reader.readLine();
                reader.readLine();
                System.out.println();
                continue;
            }

            String[] secondLine = reader.readLine().split(" ");

            boolean[] knows = new boolean[n];

            String[] thirdLine = reader.readLine().split(" ");

            for (String numberString : thirdLine) {
                int currentNum = Integer.parseInt(numberString);

                knows[currentNum - 1] = true;
            }

            for (String missingQuestion : secondLine) {
                int currentQuestion = Integer.parseInt(missingQuestion);

                if (!knows[currentQuestion - 1]) {
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }

            System.out.println();
        }
    }
}
