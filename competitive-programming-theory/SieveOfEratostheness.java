public class SieveOfEratostheness {
    public static void main(String[] args) {
        int upperLimit = 100;

        boolean prime[] = new boolean[upperLimit + 1];

        for (int i = 0; i <= upperLimit; i++) {
            prime[i] = true;
        }

        for (int p = 2; p*p <= upperLimit; p++) {
            if (prime[p] == true) {
                for (int i = p * p; i <= upperLimit; i+= p) {
                    prime[i] = false;
                }
            }
        }

        // Print all prime numbers
        for (int i = 2; i <= upperLimit; i++) {
            if (prime[i] == true) {
                System.out.print(i + " ");
            }
        }
    }
}
