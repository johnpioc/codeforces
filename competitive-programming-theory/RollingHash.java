import java.util.*;

public class RollingHash {
    private static final int BASE = 31;
    private static final int MOD = (int) 1e9 + 7;

    public static List<Long> computeRollingHash(String s, int k) {
        List<Long> hashes = new ArrayList<>();
        int n = s.length();
        long hash = 0;
        long power = 1;

        for (int i = 0; i < k - 1; i++) {
            power = (power * BASE) % MOD;
        }

        for (int i = 0; i < k; i++) {
            hash = (hash * BASE + (s.charAt(i) - 'a' + 1)) % MOD;
        }
        hashes.add(hash);

        // Slide the window and compute hashes
        for (int i = k; i < n; i++) {
            hash = (hash - (s.charAt(i - k) - 'a' + 1) * power % MOD + MOD) % MOD;
            hash = (hash * BASE + (s.charAt(i) - 'a' + 1)) % MOD;
            hashes.add(hash);
        }

        return hashes;
    }

    public static void main (String[] args) {
        String s = "HelloWorld";
        int k = 3;

        List<Long> rollingHashes = computeRollingHash(s, k);
        System.out.println("Rolling hashes" + rollingHashes);
    }
}
