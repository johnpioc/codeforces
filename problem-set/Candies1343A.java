import java.io.*;

public class Candies1343A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCases; i++) {
            int currentValue = Integer.parseInt(reader.readLine());

            int denominator = 3;
            int power = 2;

            while (currentValue % denominator != 0) {
                denominator += (int) Math.pow(2, power);
                power++;
            }

            System.out.println(currentValue / denominator);
        }
    }
}
