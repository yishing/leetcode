package sort_colors_75;

public class Solution {
    public void sortColors(int[] nums) {
        if(nums==null||nums.length==0) return;
        int head=0;
        int tail=nums.length-1;
        int i=0;
        while(i<=tail){
            if(nums[i]==0){
                swap(nums,i,head);
                head++;
                i++;
                continue;
            }
              if(nums[i]==1){
                  i++;
                continue;
            }
              if(nums[i]==2){
                swap(nums,i,tail);
                tail--;
                continue;
            }
            
        }
    }
     void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
     }
}