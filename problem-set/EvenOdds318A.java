import java.io.*;

public class EvenOdds318A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        String[] components = line.split(" ");

        long n = Long.parseLong(components[0]);
        long k = Long.parseLong(components[1]);

        long lastOddIndex = (long) Math.ceil((double) n / 2);
        long output;

        // Case 1 & 2
        if (k <= lastOddIndex) {
            output = 1 + (2 * (k - 1));
        } else { // Case 3 & 4
            output = 2 * (k - lastOddIndex);
        }

        System.out.println(output);
    }
}
