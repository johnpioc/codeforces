import java.io.*;

public class Team231A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numOfProblems = Integer.parseInt(reader.readLine());
        int numOfCanSolve = 0;

        for (int i = 0; i < numOfProblems; i++) {
            String currentLine = reader.readLine();
            String[] components = currentLine.split(" ");
            int numOfOnes = 0;

            for (String component : components) {
                if (Integer.parseInt(component) == 1) {
                    numOfOnes++;
                }
            }

            if (numOfOnes >= 2) {
                numOfCanSolve++;
            }
        }

        System.out.println(numOfCanSolve);
    }
}
