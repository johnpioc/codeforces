import java.io.*;

public class ThreeIndices1380A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 0; testCase < testCases; testCase++) {
            int n = Integer.parseInt(reader.readLine());

            String[] permutationString = reader.readLine().split(" ");

            boolean doesExist = false;

            for (int i = 1; i < n - 1; i++) {
                int leftInt = Integer.parseInt(permutationString[i - 1]);
                int middleInt = Integer.parseInt(permutationString[i]);
                int rightInt = Integer.parseInt(permutationString[i + 1]);

                if (leftInt < middleInt && rightInt < middleInt) {
                    System.out.println("YES");
                    System.out.println(i + " " + (i + 1) + " " + (i + 2));
                    doesExist = true;
                    break;
                }
            }

            if (!doesExist) {
                System.out.println("NO");
            }
        }
    }
}
