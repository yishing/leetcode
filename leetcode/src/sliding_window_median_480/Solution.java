package sliding_window_median_480;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
         PriorityQueue<Integer> minheap = new PriorityQueue();
         PriorityQueue<Integer> maxheap = new PriorityQueue(1000, Collections.reverseOrder());
         double[] ans=new double[nums.length-k+1];
         for(int i=0;i<nums.length;i++){
             if(maxheap.isEmpty()||nums[i]<maxheap.peek()){
                 maxheap.offer(nums[i]);
             }
             else{
                 minheap.offer(nums[i]);
             }
             if(minheap.size()>maxheap.size()){
                 maxheap.offer(minheap.poll());
             }
             if(maxheap.size()>minheap.size()+1){
                 minheap.offer(maxheap.poll());
             }
             if(i>=k-1){
                 if(k%2==0) ans[i-k+1]=(minheap.peek()/2.0+maxheap.peek()/2.0);
                 else ans[i-k+1]=(double)maxheap.peek();
                 if(nums[i-k+1]<=maxheap.peek()){
                     maxheap.remove(nums[i-k+1]);
                 }
                 else{
                     minheap.remove(nums[i-k+1]);
                 }
                   if(minheap.size()>maxheap.size()){
                 maxheap.offer(minheap.poll());
             }
             if(maxheap.size()>minheap.size()+1){
                 minheap.offer(maxheap.poll());
             }
             }
             
         }
         return ans;
    }
   //一定要注意保持好两个堆大小差距只能唯一，并且保证一个堆是多一个或是相等
}