package problems.day5;

import java.util.*;

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        // Sort meetings by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Check for overlaps
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false; // overlap found
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MeetingRooms mr = new MeetingRooms();

        int[][] intervals1 = {{0,30},{5,10},{15,20}};
        System.out.println(mr.canAttendMeetings(intervals1)); // false

        int[][] intervals2 = {{7,10},{2,4}};
        System.out.println(mr.canAttendMeetings(intervals2)); // true
    }
}
