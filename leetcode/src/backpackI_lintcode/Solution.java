package backpackI_lintcode;

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        boolean[][] dp=new boolean[A.length+1][m+1];
        // for(int i=0;i<m;i++){
        //     if(A[0]<i) dp[0][i]=true;
        // }
        for(int i=0;i<=A.length;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<=A.length;i++){
            for(int j=1;j<=m;j++){
                if(j-A[i-1]>=0){
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-A[i-1]];
                }
                else dp[i][j]=dp[i-1][j];
            }
        }
        for(int j=m;j>=0;j--){
            if(dp[A.length][j]){
                return j;
            }
        }
        return 0;
      
        
    }
}