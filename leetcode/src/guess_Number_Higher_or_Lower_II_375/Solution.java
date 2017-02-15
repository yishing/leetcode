package guess_Number_Higher_or_Lower_II_375;

public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp=new int[n+1][n+1];
        // Arrays.fill(dp,-1);
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=-1;
            }
        }
      return solve(dp,1,n);
    //   int res=Integer.MAX_VALUE;
    }
    public int solve(int[][] dp,int i,int j){
      if(i>=j) return 0;
      if(dp[i][j]!=-1) return dp[i][j];
      dp[i][j]=Integer.MAX_VALUE;
      for(int k=i;k<=j;k++){
          dp[i][j]=Math.min(dp[i][j],k+Math.max(solve(dp,k+1,j),solve(dp,i,k-1)));
      }
      return dp[i][j];
    }
}