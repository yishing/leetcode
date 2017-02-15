package combination_sum_II_40;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         List<List<Integer>> ans=new ArrayList<List<Integer>>();
         if(candidates==null||candidates.length==0) return ans;
         List<Integer> list=new ArrayList<Integer>();
        Arrays.sort(candidates);
        backtrack(ans,list,0,candidates,target);
        return ans;
    }
    public void backtrack(List<List<Integer>> ans,List<Integer> list,int index,int[] candidates,int target){
          if(target==0){
            ans.add(new ArrayList<Integer>(list));
            return ;
        }
        if(index>=candidates.length) return ;
        if(target<0) return ;
      
        list.add(candidates[index]);
         backtrack(ans,list,index+1,candidates,target-candidates[index]);
         while(index<candidates.length-1&&candidates[index]==candidates[index+1]){
             index++;
         }
         list.remove(list.size()-1);
          backtrack(ans,list,index+1,candidates,target);
    }
  
}