import java.io.*;
import java.util.*;

public class NumericStringTemplate2000C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int lengthOfArray = Integer.parseInt(reader.readLine());

            String[] numberArray = reader.readLine().split(" ");

            int numOfStrings = Integer.parseInt(reader.readLine());

            for (int stringNum = 1; stringNum <= numOfStrings; stringNum++) {
                String string = reader.readLine();

                if (string.length() != lengthOfArray) {
                    System.out.println("NO");
                    continue;
                }

                Map<Character, Integer> charToInt = new HashMap<>();
                Map<Integer, Character> intToChar = new HashMap<>();
                boolean status = true;

                for (int i = 0; i < lengthOfArray; i++) {
                    char currentChar = string.charAt(i);
                    int currentNum = Integer.parseInt(numberArray[i]);

                    if (charToInt.containsKey(currentChar)) {
                        if (charToInt.get(currentChar) != Integer.parseInt(numberArray[i])) {
                            status = false;
                            break;
                        }
                    } else {
                        charToInt.put(currentChar, Integer.parseInt(numberArray[i]));
                    }

                    if (intToChar.containsKey(currentNum)) {
                        if (intToChar.get(currentNum) != currentChar) {
                            status = false;
                            break;
                        }
                    } else {
                        intToChar.put(currentNum, currentChar);
                    }
                }

                if (!status) {
                    System.out.println("NO");
                } else {
                    System.out.println("YES");
                }
            }
        }
    }
}
