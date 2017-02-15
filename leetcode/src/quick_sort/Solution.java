package quick_sort;

public class Solution {
	public static void main(String[] args){
		int[] herewego={3,4,1,2,3,6,4,7,7,2,22};
		quickSort(herewego);
		for(int i=0;i<herewego.length;i++){
			System.out.println(herewego[i]);
		}
	}
	
	public static void quickSort(int[] nums){
		if(nums==null||nums.length==0) return ;
		quickSorthelper(nums,0,nums.length-1);
	}
	private static void quickSorthelper(int[] nums,int i,int j){
		if(i>=j) return ;
		int pivot=nums[(i+j)/2];
		int left=i;
		int right=j;
		while(left<=right){
			while(left<=right&&nums[right]>pivot){
				right--;
			}
//			swap(nums,left,right);
			while(left<=right&&nums[left]<pivot){
				left++;
			}
			if(left<=right){
			swap(nums,left,right);
			left++;
			right--;
			}
			
		}
		quickSorthelper(nums,i,right);
		quickSorthelper(nums,left,j);
	}
	private static void swap(int[] nums,int left,int right){
		int temp=nums[left];
		nums[left]=nums[right];
		nums[right]=temp;
	}
}
