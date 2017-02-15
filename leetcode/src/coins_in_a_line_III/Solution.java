package coins_in_a_line_III;

public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
     
    public boolean firstWillWin(int[] values) {
        // write your code here
        if(values.length==0) return false;
        int sum=0;
        for(int i=0;i<values.length;i++) sum+=values[i];
        int[][] dp=new int[values.length+1][values.length+1];
        for(int i=0;i<=values.length;i++){
            for(int j=0;j<=values.length;j++){
                dp[i][j]=-1;
            }
        }
        return 2*memorySearch(values,0,values.length-1,dp)>sum;
        
    }
    public int memorySearch(int[] values,int i,int j,int[][] dp){
        if(dp[i][j]!=-1) return dp[i][j];
        else if(i==j) dp[i][j]=values[i];
        else if(j-i==1) dp[i][j]=Math.max(values[i],values[j]);
        else{
            dp[i][j]=Math.max(Math.min(memorySearch(values,i+2,j,dp),memorySearch(values,i+1,j-1,dp))+values[i],Math.min(memorySearch(values,i,j-2,dp),memorySearch(values,i+1,j-1,dp))+values[j]);
        }
        return dp[i][j];
    }
   
}
