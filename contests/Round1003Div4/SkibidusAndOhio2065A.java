import java.io.*;

/*
    Algorithm:

    For each test case:
    1. Read the word
    2. Iterate over its characters. For each character
        a. Check if its previous character is the same as the current one
        b. If it is, OUTPUT 1
        c. If its not, move onto next character
    3. If it hasn't outputed 1 yet, OUTPUT the length of the word
 */

public class SkibidusAndOhio2065A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            String currentWord = reader.readLine();
            boolean hasDouble = false;

            for (int i = 1; i < currentWord.length(); i++) {
                char previousCharacter = currentWord.charAt(i - 1);
                char currentCharacter = currentWord.charAt(i);

                if (currentCharacter == previousCharacter) {
                    System.out.println(1);
                    hasDouble = true;
                    break;
                }
            }

            if (!hasDouble) {
                System.out.println(currentWord.length());
            }
        }
    }
}
