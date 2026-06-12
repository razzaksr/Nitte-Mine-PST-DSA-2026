package problems.day7;

import java.util.*;

public class SubarraysWithKDistinctViaSW {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, res = 0;

        for (int right = 0; right < nums.length; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            while (freq.size() > k) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) {
                    freq.remove(nums[left]);
                }
                left++;
            }

            res += right - left + 1; // all subarrays ending at right
        }
        return res;
    }

    public static void main(String[] args) {
        SubarraysWithKDistinctViaSW solver = new SubarraysWithKDistinctViaSW();
        System.out.println(solver.subarraysWithKDistinct(new int[]{1,2,1,2,3}, 2)); // 7
        System.out.println(solver.subarraysWithKDistinct(new int[]{1,2,1,3,4}, 3)); // 3
    }
}
