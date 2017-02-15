package permutation_47;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	  public List<List<Integer>> permuteUnique(int[] nums) {
	        boolean[] visted=new boolean[nums.length];
	        Arrays.sort(nums);
	        List<List<Integer>> ans=new ArrayList<List<Integer>>();
	        List<Integer> list=new ArrayList<Integer>();
	        helper(ans,list,nums,visted);
	        return ans;
	    }
	    public void helper(List<List<Integer>> ans,List<Integer> list,int[] nums,boolean[] visted){
	        if(list.size()==nums.length){
	            ans.add(new ArrayList<Integer>(list));
	            return;
	        }
	        for(int i=0;i<nums.length;i++){
	            if(visted[i]) continue;
	            if(i>0&&nums[i]==nums[i-1]&&!visted[i-1]){
	                continue;
	            }
	            if(!visted[i]){
	            visted[i]=true;
	            list.add(nums[i]);
	            helper(ans,list,nums,visted);
	            list.remove(list.size()-1);
	            visted[i]=false;
	            }
	        }
	    }
}
