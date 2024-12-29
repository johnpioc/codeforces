import java.io.*;

public class MakeAP1624A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCases; i++) {
            String line = reader.readLine();
            String[] components = line.split(" ");

            double a = Double.parseDouble(components[0]);
            double b = Double.parseDouble(components[1]);
            double c = Double.parseDouble(components[2]);

            // Case 1
            double m1 = (-c + 2*b)/a;

            if (m1 > 0 && m1 % 1 == 0) {
                System.out.println("YES");
                continue;
            }

            // Case 2
            double m2 = (c + a)/(2*b);
            if (m2 > 0 && m2 % 1 == 0) {
                System.out.println("YES");
                continue;
            }

            // Case 3
            double m3 = (2*b - a)/c;
            if (m3 > 0 && m3 % 1 == 0) {
                System.out.println("YES");
                continue;
            }

            System.out.println("NO");
        }
    }
}
