import java.io.*;
import java.util.*;

public class BusinessTrip149A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(reader.readLine());

        if (k == 0) {
            System.out.println(0);
            return;
        }

        String[] monthStrings = reader.readLine().split(" ");
        int[] monthGrowths = new int[monthStrings.length];

        for (int i = 0; i < monthGrowths.length; i++) {
            monthGrowths[i] = Integer.parseInt(monthStrings[i]);
        }

        Arrays.sort(monthGrowths);

        int runningTotalGrowth = 0;
        int numOfMonths = 0;

        for (int i = monthGrowths.length - 1; i >= 0; i--) {
            runningTotalGrowth += monthGrowths[i];
            numOfMonths++;

            if (runningTotalGrowth >= k) {
                break;
            } else if (monthGrowths[i] == 0) {
                break;
            }
        }

        if (runningTotalGrowth >= k) {
            System.out.println(numOfMonths);
        } else {
            System.out.println(-1);
        }
    }
}
