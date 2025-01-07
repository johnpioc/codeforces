import java.io.*;

public class Journey2051A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            String[] components = reader.readLine().split(" ");
            double n = Double.parseDouble(components[0]);
            double a = Double.parseDouble(components[1]);
            double b = Double.parseDouble(components[2]);
            double c = Double.parseDouble(components[3]);
            double total = a + b + c;

            double result = n / total;

            if (result % 1 == 0) {
                System.out.println((int) (result * 3));
            } else {
                if ((int) result * (int) total  + (int) a >= (int) n) {
                    System.out.println((int) Math.floor(result) * 3 + 1);
                } else if ((int) result * (int) total + (int) a + (int) b >= (int) n) {
                    System.out.println( (int) Math.floor(result) * 3 + 2 );
                } else {
                    System.out.println((int) Math.floor(result) * 3 + 3);
                }
            }
        }
    }
}
