public class DifferenceArray {

    static void initialiseDiffArray(int A[], int D[]) {
        int n = A.length;

        D[0] = A[0];
        D[n] = 0;

        for (int i = 1; i < n; i++) {
            D[i] = A[i] - A[i - 1];
        }
    }

    static void update(int D[], int l, int r, int x) {
        D[l] += x;
        D[r + 1] -= x;
    }

    static void printArray(int A[], int D[]) {
        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                A[i] = D[i];
            } else {
                A[i] = D[i] + A[i - 1];
            }

            System.out.print(A[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] A = new int[] {10, 5, 20, 40};
        int n = A.length;

        int D[] = new int[n + 1];
        initialiseDiffArray(A, D);

        update(D, 0, 1, 10);
        printArray(A, D);

        update(D, 1, 3, 20);
        update(D, 2, 2, 30);

        printArray(A, D);
    }
}
