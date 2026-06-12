package problems.day6;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingMax {
    public static int[] generate(int[] arr, int window){
        if(arr.length==0) return new int[0];
        int size = arr.length, index = 0;
        int[] finArr = new int[size-window+1];
        Deque<Integer> dq = new LinkedList<>();
        while(index<size){
            while(!dq.isEmpty()&&dq.peekFirst()<=index-window) dq.pollFirst();
            while(!dq.isEmpty()&&arr[dq.peekLast()]<arr[index]) dq.pollLast();
            dq.offer(index);
            if(index>=window-1)
                finArr [index-window+1] = arr[dq.peekFirst()];
            index++;
        }
        return finArr;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int window = 3;
        int[] res = generate(arr, window);
        System.out.println(Arrays.toString(res));
    }
}
