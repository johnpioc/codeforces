import java.io.*;

public class OddQueries1807D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 0; testCase < testCases; testCase++) {
            String[] firstLine = reader.readLine().split(" ");
            int lengthOfArray = Integer.parseInt(firstLine[0]);
            int numOfQueries = Integer.parseInt(firstLine[1]);

            String[] arrayString = reader.readLine().split(" ");
            int[] array = new int[lengthOfArray];

            for (int i = 0; i < lengthOfArray; i++) {
                array[i] = Integer.parseInt(arrayString[i]);
            }

            // Generate prefix sums and suffix sums
            int[] prefixSums = new int[lengthOfArray];
            prefixSums[0] = array[0];

            for (int i = 1; i < lengthOfArray; i++) {
                prefixSums[i] = array[i] + prefixSums[i - 1];
            }

            int[] suffixSums = new int[lengthOfArray];
            suffixSums[lengthOfArray - 1] = array[lengthOfArray - 1];

            for (int i = lengthOfArray - 2; i >= 0; i--) {
                suffixSums[i] = array[i] + suffixSums[i + 1];
            }

            for (int q = 0; q < numOfQueries; q++) {
                String[] query = reader.readLine().split(" ");
                int leftIndex = Integer.parseInt(query[0]);
                int rightIndex = Integer.parseInt(query[1]);
                int toChangeTo = Integer.parseInt(query[2]);

                int newSum = prefixSums[lengthOfArray - 1];

                if (leftIndex - 2 >= 0 && rightIndex <= lengthOfArray - 1) {
                    newSum = prefixSums[leftIndex - 2] + (rightIndex - leftIndex + 1)*toChangeTo + suffixSums[rightIndex];
                } else if (leftIndex - 2 < 0 && rightIndex <= lengthOfArray - 1) {
                    newSum = (rightIndex - leftIndex + 1)*toChangeTo + suffixSums[rightIndex];
                } else if (leftIndex - 2 >= 0 && rightIndex > lengthOfArray - 1) {
                    newSum = prefixSums[leftIndex - 2] + (rightIndex - leftIndex + 1)*toChangeTo;
                } else if (leftIndex -2 < 0 && rightIndex > lengthOfArray - 1) {
                    newSum = (rightIndex - leftIndex + 1)*toChangeTo;
                }

                if (newSum % 2 == 0) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }
        }
    }
}
