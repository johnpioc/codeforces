import java.io.*;
import java.util.*;

public class MysticPermutation1689B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 0; testCase < testCases; testCase++) {
            int lengthOfPerm = Integer.parseInt(reader.readLine());

            String[] permString = reader.readLine().split(" ");

            int[] newPerm = new int[lengthOfPerm];
            boolean[] took = new boolean[lengthOfPerm];

            if (permString.length == 1) {
                System.out.println(-1);
                continue;
            }

            for (int i = 0; i < lengthOfPerm; i++) {
                for (int j = 0; j < lengthOfPerm; j++) {
                    if (j + 1 != Integer.parseInt(permString[i]) && !took[j]) {
                        newPerm[i] = j + 1;
                        took[j] = true;
                        break;
                    }
                }
            }

            if (newPerm[lengthOfPerm - 1] == 0) {
                for (int i = 0; i < lengthOfPerm; i++) {
                    if (!took[i]) {
                        newPerm[lengthOfPerm - 1] = i + 1;
                        break;
                    }
                }
            }

            if (newPerm[lengthOfPerm - 1] == Integer.parseInt(permString[lengthOfPerm - 1]) ||
                newPerm[lengthOfPerm - 2] == Integer.parseInt(permString[lengthOfPerm - 2])) {
                swap(newPerm, lengthOfPerm - 2, lengthOfPerm - 1);
            }

            for (int num : newPerm) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void swap(int[] perm, int aIndex, int bIndex) {
        int a = perm[aIndex];
        int b = perm[bIndex];

        perm[aIndex] = b;
        perm[bIndex] = a;
    }
}
