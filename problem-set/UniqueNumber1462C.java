import java.io.*;
import java.util.*;

public class UniqueNumber1462C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCases; i++) {
            int currentNumber = Integer.parseInt(reader.readLine());

            if (currentNumber > 45) {
                System.out.println(-1);
                continue;
            }

            List<Integer> digits = new ArrayList<>();
            for (int digit = 9; digit >= 1; digit--) {
                if (currentNumber >= digit) {
                    digits.add(digit);
                    currentNumber -= digit;
                }
            }

            if (currentNumber > 0) {
                System.out.println(-1);
            } else {
                Collections.sort(digits);
                for (int digit : digits) {
                    System.out.print(digit);
                }
                System.out.println();
            }
        }
    }
}
