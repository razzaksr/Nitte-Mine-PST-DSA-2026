package problems.day5;

import java.util.*;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Step 1: Sort by end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        // Step 2: Greedy selection
        int count = 0; // intervals to remove
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) 
                // overlap → remove current
                count++;
            else 
                // no overlap → keep and update end
                prevEnd = intervals[i][1];
        }
        return count;
    }

    public static void main(String[] args) {
        NonOverlappingIntervals solver = new NonOverlappingIntervals();

        int[][] intervals1 = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(solver.eraseOverlapIntervals(intervals1)); // 1

        int[][] intervals2 = {{1,2},{1,2},{1,2}};
        System.out.println(solver.eraseOverlapIntervals(intervals2)); // 2

        int[][] intervals3 = {{1,2},{2,3}};
        System.out.println(solver.eraseOverlapIntervals(intervals3)); // 0
    }
}
