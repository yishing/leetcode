package merge_sort;

public class Solution {
	public static void main(String[] args){
	int[] herewego={3,4,1,2,3,6,4,7,7,2,22};
	mergeSort(herewego);
	for(int i=0;i<herewego.length;i++){
		System.out.println(herewego[i]);
	}
	}
	public static void mergeSort(int[] nums){
		int[] temp=new int[nums.length];
		 mergeSortHelper(nums,0,nums.length-1,temp);
		
	}
	public static void mergeSortHelper(int[] nums,int i,int j,int[] temp){
		if(i>=j) return ;
		int mid=(i+j)/2;
		mergeSortHelper(nums,i,mid,temp);
		mergeSortHelper(nums,mid+1,j,temp);
		merge(nums,i,j,temp);
	}
	private static void merge(int[] nums,int i,int j,int[] temp){
		int mid=(i+j)/2;
		int left=i;
		int right=mid+1;
		int index=i;
		while(left<=mid&&right<=j){
			if(nums[left]<nums[right]){
				temp[index]=nums[left];
				left++;
				index++;
			}
			else if(nums[right]<=nums[left]){
				temp[index]=nums[right];
				right++;
				index++;
			}
		}
		while(left<=mid){
			temp[index]=nums[left];
			left++;
			index++;
		}
		while(right<=j){
			temp[index]=nums[right];
			right++;
			index++;
		}
		for(int k=i;k<=j;k++){
			nums[k]=temp[k];
		}
	}
}
