import java.io.*;
import java.util.*;

/*
    Logic:

    1. The more distinct characters there are, the more permutations one can make. We need to try to eliminate as many
        unique characters as possible
    2. To minimise permutations, we can take the character with the lowest occurences, and switch it for a character
        with the most occurences
 */

public class ReplaceCharacter2047B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            // Read length of string n
            int n = Integer.parseInt(reader.readLine());

            // Initiate hashtable that maps Strings to integers - counts
            Map<String, Integer> counts = new HashMap<>(n);

            // Traverse through second line, and for each character, add it to hashtable with their counts
            String[] secondLine = reader.readLine().split("");
            for (String character : secondLine) {
                counts.put(character, counts.containsKey(character) ? counts.get(character) + 1 : 1);
            }

            // Traverse through hashtable, and find the lowestCount and highestCount
            String lowestCountChar = "";
            String highestCountChar = "";

            for (Map.Entry<String, Integer> characterCount : counts.entrySet()) {
                if (lowestCountChar.isEmpty()) {
                    lowestCountChar = characterCount.getKey();
                    highestCountChar = characterCount.getKey();
                    continue;
                }

                if (counts.get(lowestCountChar) > characterCount.getValue()) {
                    lowestCountChar = characterCount.getKey();
                }

                if (counts.get(highestCountChar) < characterCount.getValue()) {
                    highestCountChar = characterCount.getKey();
                }

            }

            // Traverse through second line again and print it character by character, however when we first come
            //  across the lowstCount character, replace it with the highestCount character
            boolean alreadyReplaced = false;
            for (String character : secondLine) {
                if (character.equals(lowestCountChar) && !lowestCountChar.equals(highestCountChar) && !alreadyReplaced) {
                    System.out.print(highestCountChar);
                    alreadyReplaced = true;
                } else if (lowestCountChar.equals(highestCountChar) && !character.equals(lowestCountChar) && !alreadyReplaced) {
                    System.out.print(highestCountChar);
                    alreadyReplaced = true;
                } else {
                    System.out.print(character);
                }
            }

            System.out.println();

        }
    }
}
