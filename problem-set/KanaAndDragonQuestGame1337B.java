import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KanaAndDragonQuestGame1337B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCases; i++) {
            String line = reader.readLine();
            String[] components = line.split(" ");

            int hitpoints = Integer.parseInt(components[0]);
            int voidAbsorptionUses = Integer.parseInt(components[1]);
            int lightningStrikeUses = Integer.parseInt(components[2]);

            while (voidAbsorptionUses > 0 && hitpoints > 10) {
                hitpoints = voidAbsorption(hitpoints);
                voidAbsorptionUses--;
            }

            if (hitpoints <= lightningStrikeUses * 10) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static int voidAbsorption(int hitpoints) {
        return hitpoints/2 + 10;
    }
}
