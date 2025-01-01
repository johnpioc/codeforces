import java.io.*;
import java.util.*;

public class Twins160A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numOfCoins = Integer.parseInt(reader.readLine());
        String[] coinsString = reader.readLine().split(" ");

        int[] coins = new int[coinsString.length];
        int totalSum = 0;

        for (int i = 0; i < coinsString.length; i++) {
            coins[i] = Integer.parseInt(coinsString[i]);
            totalSum += coins[i];
        }

        Arrays.sort(coins);

        int myTotalValue = 0;
        int myNumOfCoins = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            int currentCoin = coins[i];
            myTotalValue+= currentCoin;
            totalSum -= currentCoin;
            myNumOfCoins++;

            if (myTotalValue > totalSum) {
                break;
            }
        }

        System.out.println(myNumOfCoins);
    }
}
