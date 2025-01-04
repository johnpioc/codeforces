import java.util.*;

public class MonotonicIncreasingQueue {
    static Deque<Integer> increasingMonotonicQueue(int arr[], int n) {
        Deque<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            while (!queue.isEmpty() && queue.getLast() > arr[i]) {
                queue.removeLast();
            }

            queue.addLast(arr[i]);
        }

        return queue;
    }

    public static void main(String[] args) {
        int arr[] = {5, 3, 1, 9, 8, 2, 6 };
        int n = arr.length;

        Deque<Integer> queue = increasingMonotonicQueue(arr, n);

        Iterator it = queue.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
