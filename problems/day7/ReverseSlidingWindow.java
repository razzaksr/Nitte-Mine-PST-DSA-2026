package problems.day7;

import java.util.*;

public class ReverseSlidingWindow {
    public static void reverseInWindows(int[] nums, int k) {
        for (int i = 0; i < nums.length; i += k) {
            int left = i;
            int right = Math.min(i + k - 1, nums.length - 1);
            while (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        reverseInWindows(arr, 3);
        System.out.println(Arrays.toString(arr));
        // Output: [3,2,1,6,5,4,8,7]
    }
}
