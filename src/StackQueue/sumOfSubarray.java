package StackQueue;

import java.util.Stack;

public class sumOfSubarray {
    public static int sumSubarrayMins(int[] arr) {
        int MOD = 1_000_000_007;
        int n = arr.length;

        // Previous Less Element (PLE)
        Stack<Integer> stack = new Stack<>();
        int[] ple = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            ple[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Next Less Element (NLE)
        stack.clear();
        int[] nle = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                nle[stack.pop()] = i;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            nle[stack.pop()] = n;
        }

        // Calculate the result
        long result = 0;

        for (int i = 0; i < n; i++) {
            long leftCount = i - ple[i];
            long rightCount = nle[i] - i;
            result = (result + arr[i] * leftCount * rightCount) % MOD;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        System.out.println(sumSubarrayMins(arr));  // Output: 17
    }
}
