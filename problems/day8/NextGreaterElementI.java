package problems.day8;

import java.util.*;

public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        // Step 1: Process nums2 with a monotonic decreasing stack
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) nextGreater.put(stack.pop(), num);
            stack.push(num);
        }
        // Step 2: Build result for nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreater.getOrDefault(nums1[i], -1);
        }
        return result;
    }

    public static void main(String[] args) {
        NextGreaterElementI solver = new NextGreaterElementI();
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(solver.nextGreaterElement(nums1, nums2))); // [-1,3,-1]

        int[] nums1b = {2,4};
        int[] nums2b = {1,2,3,4};
        System.out.println(Arrays.toString(solver.nextGreaterElement(nums1b, nums2b))); // [3,-1]
    }
}
