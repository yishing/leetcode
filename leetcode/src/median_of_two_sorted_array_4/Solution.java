package median_of_two_sorted_array_4;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int k=(m+n)/2;
        if((m+n)%2==0){
            return (findK(nums1,nums2,k)+findK(nums1,nums2,k+1))/2.0;
            
        }
        return findK(nums1,nums2,k);
    }
    static int findK(int[] nums1,int[] nums2,int k){
        return findKhelper(nums1,0,nums2,0,k);
    }
    static int findKhelper(int[] nums1,int i,int[] nums2,int j,int k){
        if(k==1) return Math.min(nums1[i],nums2[j]);
        if(nums1.length-i<k/2){
           return  findKhelper(nums1,i,nums2,j+k/2,k-k/2);
        }
        if(nums2.length-i<k/2){
           return  findKhelper(nums1,i+k/2,nums2,j,k-k/2);
        }
        if(nums1[i+k/2-1]<nums2[j+k/2-1]){
             return  findKhelper(nums1,i+k/2,nums2,j,k-k/2);
        }
        else{
             return  findKhelper(nums1,i,nums2,j+k/2,k-k/2);
        }
        
    }
}