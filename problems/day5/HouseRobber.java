package problems.day5;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int prev1 = 0; // max till house i-1
        int prev2 = 0; // max till house i-2

        for (int num : nums) {
            int temp = prev1;
            prev1 = Math.max(prev2 + num, prev1); // choose rob or skip
            prev2 = temp;
        }

        return prev1;
    }

    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();

        System.out.println(hr.rob(new int[]{1,2,3,1}));   // 4
        System.out.println(hr.rob(new int[]{2,7,9,3,1})); // 12
    }
}
