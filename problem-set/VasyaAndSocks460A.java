import java.io.*;

public class VasyaAndSocks460A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        String[] components = input.split(" ");

        int n = Integer.parseInt(components[0]);
        int m = Integer.parseInt(components[1]);
        int dayNumber = 0;

        while (n != 0) {
            dayNumber++;

            if (dayNumber % m == 0) {
                n++;
            }

            n -= 1;
        }

        System.out.println(dayNumber);
    }
}
