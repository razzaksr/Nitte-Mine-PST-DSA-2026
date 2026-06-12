package problems.day6;

public class UniqueGridPath {
    public static int viaMath(int row, int column){
        long steps = 1;
        int total = row+column-2, dir = 0;
        dir = Math.min(row-1,column-1);
        for(int index=1;index<=dir;index++)
            steps=steps*(total-dir+index)/index;
        return (int)steps;
    }
    public static int viaDP(int rSize, int cSize){
        int[][] dp = new int[rSize][cSize];
        for(int row=0;row<rSize;row++) dp[row][0] = 1;
        for(int col=0;col<cSize;col++) dp[0][col] = 1;
        for(int row=1;row<rSize;row++){
            for(int col=1;col<cSize;col++)
                dp[row][col] = dp[row-1][col]+dp[row][col-1];
        }
        return dp[rSize-1][cSize-1];
    }
    public static void main(String[] args) {
        System.out.println(viaDP(3, 7));
        System.out.println(viaDP(3, 2));
    }
}
