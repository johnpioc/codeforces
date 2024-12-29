import java.io.*;

public class Candies1343A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCases; i++) {
            int currentValue = Integer.parseInt(reader.readLine());

            int power = 2;

            while (true) {
                int denominator = (1 << power) - 1;
                if (currentValue % denominator == 0) {
                    System.out.println(currentValue / denominator);
                    break;
                }
                power++;
            }
        }
    }
}
