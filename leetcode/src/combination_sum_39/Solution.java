package combination_sum_39;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
         List<List<Integer>> ans=new ArrayList<List<Integer>>();
         if(candidates==null||candidates.length==0) return ans;
         List<Integer> list=new ArrayList<Integer>();
         backtrack(ans,0,candidates,target,list);
         return ans;
    }
    public void backtrack(List<List<Integer>> ans,int index,int[] candidates,int target,List<Integer> list){
        if(index>=candidates.length) return ;
        if(target<0) return ;
        if(target==0) {
            ans.add(new ArrayList<Integer>(list));
            return ;
        }
        list.add(candidates[index]);
        backtrack(ans,index,candidates,target-candidates[index],list);
        list.remove(list.size()-1);
        backtrack(ans,index+1,candidates,target,list);
    }
  
}