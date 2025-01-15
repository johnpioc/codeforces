import java.io.*;

/*
    We are given a string s consisting of digits 0 to 9.

    We can perform an operation as many times we want where we can pick any digit in this string
    (except 0), decrease it by 1 and swap it with the digit at index i - 1

    Output: the lexicographically maximum string you can obtain (highest to lowest)

    Logic:

    1. For every digit, if digit - 1 is larger than the digit before it, it should be swapped

    Algorithm:

    1. Read number as a string array
    2. Traverse through string array using variable i
        a. Initialise variable index = i
        b. If current digit - 1 is larger than digit at index - 1, swap the two digits and decrement
            index
        b. Keep doing until the above is not satisfied
    3. Join string and output the number
 */

public class DigitalStringMaximisation2050D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            String[] digits = reader.readLine().split("");

            for (int i = 1; i < digits.length; i++) {
                int index = i;
                while (Integer.parseInt(digits[index]) - 1 > Integer.parseInt(digits[index - 1])) {
                    swap(digits, index - 1, index);
                    index--;
                    if (index == 0) {
                        break;
                    }
                }
            }

            for (String digit : digits) {
                System.out.print(digit);
            }
            System.out.println();
        }
    }

    public static void swap(String[] input, int left, int right) {
        String temp = input[left];
        input[left] = String.valueOf(Integer.parseInt(input[right]) - 1);
        input[right] = temp;
    }
}
