import java.io.*;

public class ShohagLovesStrings2039B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            String s = reader.readLine();

            String substring = "";

            if (s.length() == 2) {
                if (s.charAt(0) == s.charAt(1)) {
                    System.out.println(s);
                } else {
                    System.out.println(-1);
                }

                continue;
            }

            for (int i = 0; i < s.length() - 2; i++) {
                char current = s.charAt(i);
                char next = s.charAt(i + 1);
                char nextNext = s.charAt(i + 2);

                if (current == next) {
                    substring = s.substring(i, i+2);
                    break;
                } else if (next == nextNext) {
                    substring = s.substring(i + 1, i + 3);
                    break;
                } else if (current != nextNext) {
                    substring = s.substring(i, i+3);
                    break;
                }
            }

            if (substring.isEmpty()) {
                System.out.println(-1);
            } else {
                System.out.println(substring);
            }

        }
    }

    public static int getNumOfSubstrings(int numOfUniqueChars) {
        return (int) Math.pow(2, numOfUniqueChars) - 1;
    }
}
