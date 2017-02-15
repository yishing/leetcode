package permutation_46;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        helper(ans,list,nums);
        return ans;
    }
    public void helper(List<List<Integer>> ans,List<Integer> list,int[] nums){
        if(list.size()==nums.length){
            // System.out.println("asdfads");
            ans.add(new ArrayList<Integer>(list));
            return;
        }
      else{  for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])){
                continue;
            }
            else{
                list.add(nums[i]);
                helper(ans,list,nums);
                list.remove(list.size()-1);
                // System.out.println(list);
            }
        }
    }
    }
}