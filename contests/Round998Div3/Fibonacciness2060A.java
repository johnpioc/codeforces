import java.io.*;

/*
    Observations:

    - We can classify each number from position 1-5 by a-e. Our last 2 numbers are d and e. We can achieve at least
        2 Fibonacciness by finding c in  b + c = d && c + d = e => 2c = e - b. If the result of this operation is
        not an integer:

            Let c be a + b, and check d and e to see if they allign with Fib sequence

        If the result of this operation IS an integer, check if a + b = c in which we end up with 3, otherwise 2
 */

public class Fibonacciness2060A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            String[] secondLine = reader.readLine().split(" ");

            int a = Integer.parseInt(secondLine[0]);
            int b = Integer.parseInt(secondLine[1]);
            int d = Integer.parseInt(secondLine[2]);
            int e = Integer.parseInt(secondLine[3]);

            if ((d - b) == (e - d)) {
                int c = (e - b) / 2;

                if (a + b == c) {
                    System.out.println(3);
                } else {
                    System.out.println(2);
                }
            } else {
                int c = a + b;
                int fib = 1;

                if (d == b + c) {
                    fib++;
                }

                if (e == c + d) {
                    fib++;
                }

                System.out.println(fib);
            }

        }
    }
}
