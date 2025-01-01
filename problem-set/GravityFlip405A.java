import java.util.*;
import java.io.*;

public class GravityFlip405A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numOfCols = Integer.parseInt(reader.readLine());
        int[] blockTowers = new int[numOfCols];

        String[] blockTowersString = reader.readLine().split(" ");
        for (int i = 0; i < numOfCols; i++) {
            blockTowers[i] = Integer.parseInt(blockTowersString[i]);
        }

        Arrays.sort(blockTowers);

        for (int blockTower : blockTowers) {
            System.out.print(blockTower + " ");
        }
    }
}
