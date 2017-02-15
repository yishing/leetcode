package coins_in_a_line_lintcode;
import java.util.Arrays;
public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
      int[] dp=new int[values.length+1];
      Arrays.fill(dp,-1);
      int sum = 0;
        for(int now : values) 
            sum += now;
      return sum<2*memorySearch(dp,values,values.length);
    }
    public int memorySearch(int[] dp,int[] values,int n){
        if(dp[n]!=-1) return dp[n];
        if(n==0) dp[n]=0;
      else  if(n==1) dp[n]=values[values.length-1];
      else    if(n==2) dp[n]=values[values.length-1]+values[values.length-2];
      else if(n==3) dp[n]=values[values.length-3]+values[values.length-2];
      else{
           dp[n] = Math.max(
                Math.min(memorySearch(dp,values,n-2) , memorySearch(dp,values,n-3)) + values[values.length-n],
                Math.min(memorySearch(dp,values,n-3),memorySearch(dp,values,n-4)) + values[values.length-n] + values[values.length - n + 1]
                );
      }
      return dp[n];
        
    }
   
}