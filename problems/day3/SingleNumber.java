package problems.day3;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR cancels out duplicates
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();

        int[] nums1 = {2, 2, 1};
        System.out.println(sn.singleNumber(nums1)); // 1

        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println(sn.singleNumber(nums2)); // 4

        int[] nums3 = {1};
        System.out.println(sn.singleNumber(nums3)); // 1
    }
}
