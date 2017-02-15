package find_all_duplicates_in_an_array_442;
import java.util.List;
import java.util.ArrayList;
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
      
        // HashSet<Integer> set=new HashSet<Integer>();
        List<Integer> ans=new ArrayList<Integer>();
          if(nums.length==0) return ans;
        for(int i=0;i<nums.length;i++){
             int index = Math.abs(nums[i])-1;
          if(nums[index]>=0){
              nums[index]=-nums[index];
          }
          else{
              ans.add(index+1);
          } 
        }
          
        return ans;
    }
   
}
