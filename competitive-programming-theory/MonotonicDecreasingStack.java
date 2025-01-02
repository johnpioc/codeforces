import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

public class MonotonicDecreasingStack {
    public static List<Integer> monontonicDecreasing(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            while(!stack.isEmpty() && stack.peek() < num) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result.add(stack.peek());
            } else {
                result.add(-1);
            }

            stack.push(num);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 4, 1, 5, 9, 2, 6 };
        List<Integer> result = monontonicDecreasing(nums);
        System.out.println("Monotonic decreasing stack: " + result);
    }
}
