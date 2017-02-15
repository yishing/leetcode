package product_except_self_238;

public class Solution {
	 public int[] productExceptSelf1(int[] nums) {
	      int[] output=new int[nums.length];
	      int temp=1;
	      for(int i=0;i<nums.length;i++){
	    	  output[i]=temp;
	    	  temp=nums[i]*temp;
	      }
	      temp=1;
	      for(int i=nums.length;i>=0;i--){
	    	  output[i]=temp*output[i];
	    	  temp=nums[i]*temp;
	      }
	    	  
	    	  
	    	  return output;
	    } 

}
