import java.io.*;

public class Football96A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String playersString = reader.readLine();
        int index = 0;
        int currentTeamCount = 1;
        boolean isDangerous = false;
        char currentTeam = playersString.charAt(index);

        while (index < playersString.length() - 6 && !isDangerous) {
            while (playersString.charAt(++index) == currentTeam && currentTeamCount < 7) {
                currentTeamCount++;
                if (index + 1 == playersString.length()) {
                    break;
                }
            }

            if (currentTeamCount == 7) {
                isDangerous = true;
            } else {
                currentTeam = playersString.charAt(index);
                currentTeamCount = 1;
            }
        }

        if (isDangerous) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
