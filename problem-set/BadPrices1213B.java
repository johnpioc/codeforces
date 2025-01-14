import java.io.*;

public class BadPrices1213B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int numberOfDays = Integer.parseInt(reader.readLine());

            String[] prices = reader.readLine().split(" ");
            int lowestPrice = Integer.parseInt(prices[numberOfDays - 1]);

            int numOfBadDays = 0;

            for (int i = numberOfDays - 2; i >= 0; i--) {
                int currentPrice = Integer.parseInt(prices[i]);

                if (currentPrice > lowestPrice) {
                    numOfBadDays++;
                } else {
                    lowestPrice = currentPrice;
                }
            }

            System.out.println(numOfBadDays);
        }
    }
}
