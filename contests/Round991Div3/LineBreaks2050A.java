import java.io.*;

/*
  On the first line, we are given:

  n - number of words in the list
  m - maximum number of characters that can be on the first strip

  The next n lines contain one word of lowercase letters, where the length does not exceed 10

  Output: the maximum number of words x such that the first x words have a total length no more than m

  Algorithm:

  1. Read n and m, also initialise variables numOfWords & totalLength
  2. Run a for loop n times, for each loop
    a. read the line and check the length
    b. If totalLength + current words length is less than m, increment numOfWords and add current
        length to totalLength
    c. else, do nothing (keep loop running to run through rest of words
    d. Output numOfWords
 */

public class LineBreaks2050A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            String[] firstLine = reader.readLine().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            int m = Integer.parseInt(firstLine[1]);

            int numOfWords = 0;
            int totalLength = 0;

            for (int i = 0; i < n; i++) {
                String currentWord = reader.readLine();
                totalLength += currentWord.length();

                if (totalLength <= m) {
                    numOfWords++;
                }
            }

            System.out.println(numOfWords);
        }
    }
}
