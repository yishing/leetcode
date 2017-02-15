package subsets2_90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
       List<List<Integer>> ans=new ArrayList<List<Integer>>();
       List<Integer> temp=new ArrayList<Integer>();
      // ans.add(temp);
       helper(ans,temp,0,nums);
       return ans;
    }
    public void helper(List<List<Integer>> ans,List<Integer> temp,int j,int[] nums){
       if(j<=nums.length) ans.add(temp);
        for(int i=j;i<nums.length;i++){
            temp.add(nums[i]);
            helper(ans,new ArrayList<>(temp),j+1,nums);
            temp.remove(temp.size()-1);
              while (i < nums.length && nums[i] == nums[i+1]) {i++;}
        }
        return ;
    }
  //  the followed  method is based on https://discuss.leetcode.com/topic/4661/c-solution-and-explanation/2
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> empty=new ArrayList<Integer>();
        ans.add(empty);
        for(int i=0;i<nums.length;){
            int count=0;
            while(count+i<nums.length&&nums[i+count]==nums[i]){
                count++;
        }
        int index=ans.size();
        for(int k=0;k<index;k++){
            List<Integer> temp=ans.get(k);
            for(int j=0; j<count; j++){
            temp.add(nums[j]);
            ans.add(temp);
            }
        }
        i=i+count;
      }
      return ans;
  }
}
