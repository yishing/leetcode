package foursum_18;


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
         List<List<Integer>> result=new ArrayList<>();
          if(nums.length<4)return result;
        for(int i=0;i<nums.length-3;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<nums.length-2;j++){
                if(j>i+1&&nums[j]==nums[j-1]) continue;
                int left=j+1;
            int right=nums.length-1;
            int target2=target-nums[i]-nums[j];
            while(left<right){
                int sum=target2-nums[left]-nums[right];
                 if(sum>0){
                    left++;
                }
                else if(sum<0){
                    right--;
                }
                else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                    
                     while(left<right&&nums[left]==nums[left+1])
                    {left++;}
                    while(right>left&&nums[right]==nums[right-1])
                    {right--;}
                    left++;
                    right--;
                }
               
            }
            }
            
    }
    return result;
}// 三次方
}