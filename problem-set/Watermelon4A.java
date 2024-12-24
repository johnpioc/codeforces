import java.io.*;

public class Watermelon4A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int watermelonWeight = Integer.parseInt(reader.readLine());
        if (watermelonWeight % 2 == 0 && watermelonWeight != 2) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
