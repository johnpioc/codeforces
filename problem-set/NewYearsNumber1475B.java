import java.io.*;

public class NewYearsNumber1475B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCases; i++) {
            int currentValue = Integer.parseInt(reader.readLine());

            // Calculate remainder and quotient
            int remainder = currentValue % 2020;
            int quotient = currentValue / 2020;

            // Check if the number can be expressed as 2020x + 2021y
            if (remainder <= quotient) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
