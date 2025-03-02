import java.io.*;

public class RakhshsRevival2034Boptimal {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            String[] firstLine = reader.readLine().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            int m = Integer.parseInt(firstLine[1]);
            int k = Integer.parseInt(firstLine[2]);

            String s = reader.readLine();
            int numOfConsecutiveZeroes = 0;
            int numOfOperations = 0;

            for (int i = 0; i < s.length(); i++) {
                char currentChar = s.charAt(i);
                int value = currentChar - '0';

                if (value == 1) {
                    numOfConsecutiveZeroes = 0;
                    continue;
                } else {
                    numOfConsecutiveZeroes++;
                }

                if (numOfConsecutiveZeroes >= m) {
                    i += k - 1;
                    numOfOperations++;
                    numOfConsecutiveZeroes = 0;
                }
            }

            System.out.println(numOfOperations);
        }
    }
}
