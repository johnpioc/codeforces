import java.io.*;
import java.util.*;

public class GorillaAndTheExam2057B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            // Read length of array, n and max number of changes, k
            String[] firstLine = reader.readLine().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            int k = Integer.parseInt(firstLine[1]);

            // Read array, numberStrings
            String[] numberStrings = reader.readLine().split(" ");

            // Store counts of each number in a hashtable
            Map<Integer, Integer> counts = new HashMap<>();

            for (String el : numberStrings) {
                int currentNum = Integer.parseInt(el);
                counts.put(currentNum, counts.containsKey(currentNum) ? counts.get(currentNum) + 1 : 1);
            }

            // Create an array of keys from counts in the order of lowest count to highest count
            Integer[] keys = counts.keySet().toArray(new Integer[0]);

            Arrays.sort(keys, (a,b) -> Integer.compare(counts.get(a), counts.get(b)));

            // Eliminate keys in counts using k from minimum count to maximum
            int currentIndex = 0;
            while (k > 0) {
                int currentKey = keys[currentIndex];

                int keyCount = counts.get(currentKey);

                if (keyCount - k <= 0 && counts.keySet().size() > 1) {
                    counts.remove(currentKey);
                }

                k -= keyCount;
                currentIndex++;
            }

            // Output remaining number of keys
            System.out.println(counts.keySet().toArray(new Integer[0]).length);
        }
    }
}
