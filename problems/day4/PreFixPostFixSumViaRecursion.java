package problems.day4;

import java.util.Arrays;

public class PreFixPostFixSumViaRecursion {
    // Recursive function for prefix sum
    static void prefixSum(int[] arr, int[] prefix, int i) {
        if (i == 0) {
            prefix[0] = arr[0];
            return;
        }
        prefixSum(arr, prefix, i - 1); // compute previous
        prefix[i] = prefix[i - 1] + arr[i];
    }
    // Recursive function for postfix sum
    static void postfixSum(int[] arr, int[] postfix, int i) {
        if (i == arr.length - 1) {
            postfix[i] = arr[i];
            return;
        }
        postfixSum(arr, postfix, i + 1); // compute next
        postfix[i] = arr[i] + postfix[i + 1];
    }
    public static void main(String[] args) {
        int[] arr = {23, 12, 98, 45, 18, 45, 12, 98};
        int n = arr.length;

        int[] prefix = new int[n];
        int[] postfix = new int[n];

        // Build prefix recursively
        prefixSum(arr, prefix, n - 1);

        // Build postfix recursively
        postfixSum(arr, postfix, 0);

        System.out.println("Prefix Sum: " + Arrays.toString(prefix));
        System.out.println("Postfix Sum: " + Arrays.toString(postfix));
    }
}
