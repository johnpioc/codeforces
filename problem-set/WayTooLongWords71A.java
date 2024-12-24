import java.io.*;

public class WayTooLongWords71A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numOfWords = Integer.parseInt(reader.readLine());
        String[] words = new String[numOfWords];

        for (int i = 0; i < numOfWords; i++) {
            words[i] = reader.readLine();
        }

        for (String word : words) {
            if (word.length() > 10) {
                int numInBetween = word.length() - 2;
                String output = String.valueOf(word.charAt(0)) + numInBetween + word.charAt(word.length() - 1);
                System.out.println(output);
            } else {
                System.out.println(word);
            }
        }
    }
}
