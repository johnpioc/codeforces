import java.io.*;

/*
    Observations:

    - If there are at least two materials which are below their required limit, it is impossible to raise them up
        to their limits
    - Similarly, if there is at least one material that is below the required limit, and there is at least another
        material that is equal to its required limit, it is impossible to reach their required limits
    - Logic: we can find the maximum gap of the current units and required units, and we can find the smallest gap above
        the required units OR zero. If that maximum gap is bigger than the smallest gap, then it is impossible to raise
        all to the required units
    -
 */

public class Crafting2055B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            // Read number of types of materials, n
            int n = Integer.parseInt(reader.readLine());

            // Read second line and store in array variable, currentUnits
            String[] secondLine = reader.readLine().split(" ");
            int[] currentUnits = new int[n];

            for (int i = 0; i < n; i++) {
                currentUnits[i] = Integer.parseInt(secondLine[i]);
            }

            // Read third line and create differences array
            String[] thirdLine = reader.readLine().split(" ");
            int[] differences = new int[n];

            for (int i = 0; i < n; i++) {
                differences[i] = currentUnits[i] - Integer.parseInt(thirdLine[i]);
            }

            // From differences, find the highestDeficit (smallest negative number)
            int highestDeficit = 0;
            int indexOfHighestDeficit = 0;

            for (int i = 0; i < n; i++) {
                int difference = differences[i];
                if (difference < highestDeficit) {
                    highestDeficit = difference;
                    indexOfHighestDeficit = i;
                }
            }

            // Traverse through differences, and for all positive numbers including 0, abs(highestDifference) < current
            // difference
            boolean canCraft = true;
            for (int i = 0; i < n; i++) {
                int difference = differences[i];
                if (difference < 0) {
                    if (i != indexOfHighestDeficit) {
                        canCraft = false;
                        break;
                    } else {
                        continue;
                    }
                }

                if (Math.abs(highestDeficit) > difference) {
                    canCraft = false;
                    break;
                }
            }

            if (canCraft) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }
    }
}
