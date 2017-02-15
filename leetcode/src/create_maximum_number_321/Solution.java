package create_maximum_number_321;

public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n=nums1.length;
        int m=nums2.length;
        int i=Math.max(0,k-m);
        int[] ans=new int[k];
        for(;i<=n&&i<=k;i++){
            int[] temp=merge(maxArray(nums1,i),maxArray(nums2,k-i),k);
            if(greater(temp,0,ans,0)) ans=temp;
        }
        return ans;
    }
    public int[] maxArray(int[] nums,int k){
        // int i=0;
        // int j=0;
        int[] res=new int[k];
         for (int i = 0, j = 0; i < nums.length; ++i) {
             while(nums.length-i+j>k&&j>0&&res[j-1]<nums[i])j--;
             if(j<k) {
                 res[j]=nums[i];
                 j++;
             }
             
         }
         return res;
    }
    public boolean greater(int[] nums1,int i1,int[] nums2,int i2){
        while(i1<nums1.length&&i2<nums2.length&&nums1[i1]==nums2[i2]){
            i1++;
            i2++;
        }
        return i2==nums2.length||(i1 < nums1.length && nums1[i1] > nums2[i2]);
    }
    public int[] merge(int[] nums1,int[] nums2,int k){
        int[] ans=new int[k];
          for (int i = 0, j = 0, r = 0; r < k; ++r)
        ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
    return ans;
    }
    
}