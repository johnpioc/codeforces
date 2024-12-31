import java.io.*;

public class FoodBuying1296B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCases; i++) {
            int dollars = Integer.parseInt(reader.readLine());
            int totalSpent = 0;

            while (dollars >= 10) {
                int onesValue = dollars % 10;
                dollars -= onesValue;

                // Spend Money
                totalSpent += dollars;
                dollars = (dollars / 10) + onesValue;
            }

            // Spend Rest of money
            totalSpent += dollars;

            System.out.println(totalSpent);
        }
    }
}
