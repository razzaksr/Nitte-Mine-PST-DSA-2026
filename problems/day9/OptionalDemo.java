import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.IntStream;

public class OptionalDemo {
    // leet code 35. Search Insert Position
    public int searchInsert(int[] nums, int target) {
        OptionalInt found = Arrays.stream(nums).filter(n -> n==target).findFirst();
        if(found.isPresent()) {
            for(int i=0;i<nums.length;i++) if(nums[i]==target) return i;
        }
        int pos = Arrays.binarySearch(nums,target);
        return pos>=0 ? pos : -(pos+1);
    }
    // leet code 41. First Missing Positive
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n: nums) set.add(n);
        // int i=1;
        // while(true){
        //     Optional<Integer> opt = Optional.of(i);
        //     System.out.println(i);
        //     if(!set.contains(opt.get())) return i;
        //     i++;
        // }
        return IntStream.range(1, Integer.MAX_VALUE).
        filter(index->!set.contains(index)).
        findFirst().
        getAsInt();
    }
    public static void main(String[] args) {
        OptionalDemo demo = new OptionalDemo();
        // int[] nums = {1,3,5,6};
        // int target = 5;
        // System.out.println(demo.searchInsert(nums, target)); // Output: 2
        int[] nums2 = {3,4,-1,1};
        System.out.println(demo.firstMissingPositive(nums2)); // Output: 2

        // Map<String, String> map = new HashMap<>();
        // map.put("key1", "value1");
        // String value = Optional.ofNullable(map.get("key2")).orElse("default");
        // System.out.println(value); // Output: default
    }
}
