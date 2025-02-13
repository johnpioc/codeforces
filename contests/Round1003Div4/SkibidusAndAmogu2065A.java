import java.io.*;

public class SkibidusAndAmogu2065A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            String currentWord = reader.readLine();
            String root = currentWord.substring(0, currentWord.length() - 2);

            System.out.println(root + "i");
        }
    }
}
