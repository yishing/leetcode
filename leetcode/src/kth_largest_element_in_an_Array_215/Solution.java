package kth_largest_element_in_an_Array_215;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Arrays.sort(nums);
        // return nums[nums.length-k];
        //简单成马
    if(nums==null||nums.length==0) return 0;
    return helper(nums,0,nums.length-1,nums.length-k+1);
    }
    static int helper(int[] nums,int i,int j,int k){
    	 if(i==j) return nums[i];
    	int pos=partition(nums,i,j);
    	if(pos+1==k){
    		return nums[pos];
    	}
    	else if(pos+1<k){
    		return helper(nums,pos+1,j,k);
    	}
    	else{
    		return helper(nums,i,pos-1,k);
    	}
//    	return 
    }
    static int partition(int[] nums,int i,int j){
    	int pivot=nums[i];
//    	int left=i;
//    	int right=j;
    	while(i<j){
    		while(i<j&&nums[j]>=pivot){
    			j--;
    		}
    		nums[i]=nums[j];
    		while(i<j&&nums[i]<=pivot){
    			i++;
    		}
    		nums[j]=nums[i];
    	}
    	nums[i]=pivot;
    	return i;
    }
   
}