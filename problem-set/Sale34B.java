import java.io.*;

public class Sale34B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = reader.readLine().split(" ");
        int capacity = Integer.parseInt(firstLine[1]);

        int[] cheapestTvs = new int[capacity];

        String[] tvPricesString = reader.readLine().split(" ");

        for (String tvPriceString : tvPricesString) {
            int currentPrice = Integer.parseInt(tvPriceString);

            if (currentPrice < 0) {
                insert(cheapestTvs, currentPrice);
            }
        }

        int maxSumOfMoney = 0;

        for (int price : cheapestTvs) {
            maxSumOfMoney += Math.abs(price);
        }

        System.out.println(maxSumOfMoney);
    }

    public static void insert(int[] array, int toInsert) {
        if (array[array.length - 1] < toInsert) {
            return;
        }

        if (array[0] >= toInsert) {
            for (int i = array.length - 1; i >= 1; i--) {
                array[i] = array[i - 1];
            }

            array[0] = toInsert;
            return;
        }

        if (array[0] < toInsert && toInsert <= array[array.length - 1]) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] >= toInsert) {
                    for (int j = array.length - 1; j >= i; j--) {
                        array[j] = array[j - 1];
                    }

                    array[i] = toInsert;
                    break;
                }
            }
        }
    }
}
