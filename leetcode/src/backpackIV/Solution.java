package backpackIV;

public class Solution {
    /**
     * @param nums an integer array and all positive numbers, no duplicates
     * @param target an integer
     * @return an integer
     */
    public int backPackIV(int[] nums, int target) {
        // Write your code here
        int[][] dp=new int[nums.length+1][target+1];
        // for(int i=1;i<=nums.length)
        // for(int i=1;i<=nums.length;i++){
        //     if(nums[i-1]<=target) dp[i][nums[i-1]]=1;
        // }
        dp[0][0]=1;
      for(int i=1;i<=nums.length;i++){
         
          for(int j=0;j<=target;j++){
             int k = 0; 
                while(k * nums[i-1] <= j) {
                    dp[i][j] += dp[i-1][j-nums[i-1]*k];
                    k+=1;
                }
          }
      }
    return dp[nums.length][target];
    }
}