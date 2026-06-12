package problems.day4;

public class FindMinimumRotatedArray {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // If mid element is greater than right, min must be in right half
            if (nums[mid] > nums[right]) left = mid + 1;
            else 
                // Otherwise, min is in left half (including mid)
                right = mid;
        }
        // At the end, left == right pointing to the minimum
        return nums[left];
    }

    public static void main(String[] args) {
        FindMinimumRotatedArray solver = new FindMinimumRotatedArray();

        System.out.println(solver.findMin(new int[]{3,4,5,1,2}));      // 1
        System.out.println(solver.findMin(new int[]{4,5,6,7,0,1,2}));  // 0
        System.out.println(solver.findMin(new int[]{11,13,15,17}));    // 11
    }
}
