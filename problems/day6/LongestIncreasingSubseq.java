package problems.day6;

import java.util.Arrays;

public interface LongestIncreasingSubseq {
    public static int findLengthViaDP(int[] arr){
        int size = arr.length, maxLength=1;
        int[] dp = new int[size];
        Arrays.fill(dp, 1);
        for(int index = 1;index<size;index++){
            for(int comp = 0;comp<index;comp++){
                if(arr[index]>arr[comp])
                    dp[index]=Math.max(dp[index],dp[comp]+1);
            }
            maxLength = Math.max(maxLength,dp[index]);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        System.out.println(findLengthViaDP(new int[]{10,9,2,5,3,7,101,18}));
        System.out.println(findLengthViaDP(new int[]{0,1,0,3,2,3}));
        System.out.println(findLengthViaDP(new int[]{7,7,7,7,7,7,7}));
    }
}
