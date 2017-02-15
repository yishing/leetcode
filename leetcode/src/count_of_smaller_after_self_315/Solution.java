package count_of_smaller_after_self_315;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
//public class Solution {
//    public List<Integer> countSmaller(int[] nums) {
//      Integer[] count = new Integer[nums.length];
//    if(nums.length == 0){
//        return Arrays.asList(count);
//    }
//    Node root=new Node(nums[nums.length-1]);
//    for(int i=nums.length-1;i>=0;i--){
//        count[i]=insert(root,nums[i]);
//    }
//    return Arrays.asList(count);
//    }
//    class Node{
//        Node left,right;
//        int leftsum=0;
//        int dup=0;
//        int val;
//         public Node(int val){
//        this.val = val;
//    }
//    }
//    public int insert(Node node,int value){
//        int sum=0;
//      while(node.val!=value){
//            if(value<node.val){
//                if(node.left==null) node.left=new Node(value);
//                node.leftsum++;
//                node=node.left;
//            }
//            else if(value>node.val){
//                 if(node.right==null) node.right=new Node(value);
//                sum+=node.leftsum+node.dup;
//                node=node.right;
//            }
//      }
//      node.dup++;
//      return sum+node.leftsum; 
//    }
//}
public class Solution {
    int[] count;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();     
        count = new int[nums.length];
        int[] indexes = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            indexes[i]=i;
        }
        mergesort(nums,indexes,0,nums.length-1);
        for(int i=0;i<nums.length;i++){
            res.add(count[i]);
        }
        return res;
    }
    public void mergesort(int[] nums,int[] indexes,int start,int end){
        if(start<=end) return;
        int mid=start+(start-end)/2;
        mergesort(nums,indexes,start,mid);
        mergesort(nums,indexes,mid+1,end);
        merge(nums,indexes,start,end);
    }
    public void merge(int[] nums,int[] indexes,int start,int end){
          int mid=start+(start-end)/2;
          int left_index=start;
          int right_index=mid++;
          int sort_index = 0;
       int   rightcount=0;
          int[] new_indexes=new int[start-end+1];
          while(left_index<=mid&&right_index<=end){
              if(nums[indexes[left_index]]<nums[indexes[right_index]]){
                  new_indexes[sort_index]=indexes[left_index];
                  count[indexes[left_index]] += rightcount;
                  left_index++;
                //  sort_index++;
              }
              else if(nums[indexes[left_index]]>nums[indexes[right_index]]){
               new_indexes[sort_index] = indexes[right_index];
			rightcount++;
			right_index++;

              }
              sort_index++;
          }
          while(left_index<=mid){
              new_indexes[sort_index]=indexes[left_index];
              count[indexes[left_index]] += rightcount;
                left_index++;
              sort_index++;
          }
          while(right_index<=end){
               new_indexes[sort_index++] = indexes[right_index++];
          }
          for(int i = start; i <= end; i++){
		indexes[i] = new_indexes[i - start];
	}
    }
}
    
    
    
    
    
    
    
    
    
    
//    public class Solution {
//        int[] count;
//        public List<Integer> countSmaller(int[] nums) {
//            List<Integer> res = new ArrayList<Integer>();     
//            count = new int[nums.length];
//            int[] indexes = new int[nums.length];
//            for(int i=0;i<nums.length;i++){
//                indexes[i]=i;
//            }
//            mergesort(nums,indexes,0,nums.length-1);
//            for(int i=0;i<nums.length;i++){
//                res.add(count[i]);
//            }
//            return res;
//        }
//        public void mergesort(int[] nums,int[] indexes,int start,int end){
//            if(end<=start) return;
//            int mid=start+(end-start)/2;
//            mergesort(nums,indexes,start,mid);
//            mergesort(nums,indexes,mid+1,end);
//            merge(nums,indexes,start,end);
//        }
//        public void merge(int[] nums,int[] indexes,int start,int end){
//              int mid=start+(end-start)/2;
//              int left_index=start;
//              int right_index=mid+1;
//              int sort_index = 0;
//           int   rightcount=0;
//              int[] new_indexes=new int[end-start+1];
//              while(left_index<=mid&&right_index<=end){
//                  if(nums[indexes[right_index]] < nums[indexes[left_index]]){
//    			new_indexes[sort_index] = indexes[right_index];
//    			rightcount++;
//    			right_index++;
//    		}else{
//    			new_indexes[sort_index] = indexes[left_index];
//    			count[indexes[left_index]] += rightcount;
//    			left_index++;
//    		}
//    		sort_index++;
//              }
//              while(left_index<=mid){
//                  new_indexes[sort_index]=indexes[left_index];
//                  count[indexes[left_index]] += rightcount;
//                    left_index++;
//                  sort_index++;
//              }
//              while(right_index<=end){
//                   new_indexes[sort_index++] = indexes[right_index++];
//              }
//              for(int i = start; i <= end; i++){
//    		indexes[i] = new_indexes[i - start];
//    	}
//        }
//    }
//}