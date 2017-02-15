package maximum_size_subarray_sum_equals_k_325;
import java.util.HashMap;
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums==null||nums.length==0) return 0;
       HashMap<Integer,Integer> summap=new HashMap<Integer,Integer>();
       int sum=0;
       int res=0;
       for(int i=0;i<nums.length;i++){
           sum+=nums[i];
        if(sum==k) res=i+1;
         else  if(summap.containsKey(sum-k)) res=Math.max(i-summap.get(sum-k),res);
         if(!summap.containsKey(sum)) summap.put(sum,i);
       }
       return res;
    }
}