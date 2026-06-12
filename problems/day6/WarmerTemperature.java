package problems.day6;

import java.util.Arrays;
import java.util.Stack;

public class WarmerTemperature {
    public static void findDay(int[] temp, int[] res){
        Stack<Integer> stk = new Stack<>();
        for(int index = 0; index<temp.length;index++){
            int currentValue = temp[index];
            while(!stk.isEmpty()&&currentValue>temp[stk.peek()]){
                int position = stk.pop();
                res[position] = index - position;
            }
            stk.push(index);
        }
    }
    public static void main(String[] args) {
        int[] forecast = {73,74,75,71,69,72,76,73};
        int[] result = new int[forecast.length];
        findDay(forecast, result);
        System.out.println(Arrays.toString(result));
    }
}
