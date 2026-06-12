package problems.day6;

import java.util.Stack;

public class Histogram {
    public static int findMax(int[] arr){
        int maxArea = Integer.MIN_VALUE;
        Stack<Integer> stk = new Stack<>();
        for(int index = 0; index<=arr.length;index++){
            int currentValue = (index==arr.length)?0:arr[index];
            // when pop need to be done
            while(!stk.isEmpty()&&currentValue<arr[stk.peek()]){
                int height = arr[stk.pop()];
                int width = stk.isEmpty()?index:index-stk.peek()-1;
                int tempArea = width*height;
                maxArea = Math.max(maxArea, tempArea);
            }
            stk.push(index);
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] heights = {1,3,5,4,2};
        int received = findMax(heights);
        System.out.println("Largest area: "+received);
    }
}
