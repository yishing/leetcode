package threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        if(nums.length<3) return result;
        for(int i=0;i<nums.length-2;i++){
            //int target=0-nums[i];
            if (i != 0 && nums[i] == nums[i - 1]) {
				continue; // to skip duplicate numbers; e.g [0,0,0,0]
			}
           
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    List<Integer> sol=new ArrayList<>();
                    sol.add(nums[i]);
                    sol.add(nums[left]);
                    sol.add(nums[right]);
                    result.add(sol);
                    while(left<right&&nums[left]==nums[left+1])
                    {left++;}
                    while(right>left&&nums[right]==nums[right-1])
                    {right--;}
                }
                if(sum<0){
                    left++;
                }
                else{
                    right--;
                }
            }
            
   
        }
        return result;
}
}
