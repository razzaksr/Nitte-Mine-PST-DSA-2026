package problems.day6;

public class LongestCommonSubseq {
    public static int findSeq(String sample, String dna){
        int rSize = sample.length();
        int cSize = dna.length();
        int[][] grid = new int[rSize+1][cSize+1];
        for(int row=1;row<=rSize;row++){
            for(int col=1;col<=cSize;col++){
                if(sample.charAt(row-1)==dna.charAt(col-1))
                    grid[row][col] = grid[row-1][col-1]+1;
                else
                    grid[row][col] = Math.max(grid[row-1][col],
                grid[row][col-1]);
            }
        }
        return grid[rSize][cSize];
    }
    public static void main(String[] args) {
        System.out.println(findSeq("abcde", "ace"));
        System.out.println(findSeq("abc", "abc"));
        System.out.println(findSeq("abc", "def"));
    }
}
