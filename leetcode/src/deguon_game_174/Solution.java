package deguon_game_174;

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length;
        int n=dungeon[0].length;
        int[][] dp=new int[dungeon.length+1][dungeon[0].length+1];
         if (dungeon[m - 1][n - 1] >= 0) {
            dp[m][n] = 1;
        } else {
            dp[m][n] = 1 - dungeon[m-1][n-1];
        }
        for(int i=m-1;i>=1;i--){
            dp[i][n]=Math.max(dp[i+1][n]-dungeon[i-1][n-1],1);
        }
         for(int j=n-1;j>=1;j--){
            dp[m][j]=Math.max(dp[m][j+1]-dungeon[m-1][j-1],1);
        }
        for(int i=m-1;i>=1;i--){
           for(int j=n-1;j>=1;j--){
               int right=Math.max(dp[i+1][j]-dungeon[i-1][j-1],1);
               int bottom=Math.max(dp[i][j+1]-dungeon[i-1][j-1],1);
               dp[i][j]=Math.min(right,bottom);
           }
        }
        return dp[1][1];
        

    }
}
