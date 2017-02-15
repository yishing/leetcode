package longest_increasing_path_in_a_matrix;

public class Solution {
    int[] dx={-1,1,0,0};
    int[] dy={0,0,-1,1};
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
         if(matrix.length==0||matrix[0].length==0) return 0;
      dp=new int[matrix.length][matrix[0].length];
      int ans=0;
      for(int i=0;i<matrix.length;i++){
          for(int j=0;j<matrix[0].length;j++){
              dp[i][j]=search(i,j,dp,matrix);
              ans=Math.max(ans,dp[i][j]);
          }
      }
      return ans;
    }
    public int search(int i,int j,int[][] dp,int[][] matrix){
        if(dp[i][j]!=0) return dp[i][j];
       int ans=1;
        for(int k=0;k<4;k++){
            int ni=i+dx[k];
            int nj=j+dy[k];
            if(ni<0||ni>=matrix.length||nj<0||nj>=matrix[0].length) continue;
            if(matrix[ni][nj]<matrix[i][j]){
                ans=Math.max(search(ni,nj,dp,matrix)+1,ans);
            }
        }
        dp[i][j]=ans;
        return ans;
    }
    
    }
