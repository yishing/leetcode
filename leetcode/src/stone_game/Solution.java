package stone_game;

public class Solution {
    /**
     * @param A an integer array
     * @return an integer
     */
    public int stoneGame(int[] A) {
        // Write your code here
        if(A.length==0) return 0;
        int[][] sum=new int[A.length][A.length];
        for(int i=0;i<A.length;i++){
            sum[i][i]=A[i];
            for(int j=i+1;j<A.length;j++){
                sum[i][j]=sum[i][j-1]+A[j];
            }
        }
        int[][] dp=new int[A.length][A.length];
        
          for(int i=0;i<A.length;i++){
            // sum[i][i]=A[i];
            for(int j=i+1;j<A.length;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        return search(0,A.length-1,A,dp,sum);
      
    }
    public int search(int i,int j,int[] A,int[][] dp,int[][] sum){
        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];
        for(int k=i;k<j;k++){
         dp[i][j]=Math.min(dp[i][j],search(i,k,A,dp,sum)+search(k+1,j,A,dp,sum)+sum[i][j]);   
        }
        return dp[i][j];
    }
}
