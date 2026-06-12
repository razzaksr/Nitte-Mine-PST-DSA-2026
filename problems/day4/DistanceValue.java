package problems.day4;

public class DistanceValue {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int a : arr1) {
            boolean valid = true;
            for (int b : arr2) {
                if (Math.abs(a - b) <= d) {
                    valid = false;
                    break;
                }
            }
            if (valid) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        DistanceValue dv = new DistanceValue();
        int[] arr1 = {4,5,8};
        int[] arr2 = {10,9,1,8};
        System.out.println(dv.findTheDistanceValue(arr1, arr2, 2)); // 2
    }
}
