package minimum_bianry_tree_depth_111;

import java.util.Queue;
import java.util.LinkedList;
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class Solution {
    public int minDepth(TreeNode root) {
        // if(root==null) return 0;
        // if(root.left==null&&root.right==null) return 1;
        // if(root.left!=null&&root.right==null) return minDepth(root.left)+1;
        // if(root.left==null&&root.right!=null) return minDepth(root.right)+1;
        // return Math.min(minDepth(root.left),minDepth(root.right))+1;
        if(root==null) return 0;
        Queue<TreeNode> pq=new LinkedList<TreeNode>();
        pq.offer(root);
        int depth=1;
        TreeNode rightmost=root;
        while(!pq.isEmpty()){
            TreeNode now=pq.poll();
            if(now.left==null&&now.right==null){
                break;
            }
           if(now.left!=null) pq.offer(root.left);
           if(now.right!=null)  pq.offer(root.right);
           if(now==rightmost){
               
            depth++;
            rightmost=root.right==null?root.left:root.right;
            //加入此判断才能知道是不是到了这层的结尾
           }
            
        }
        return depth;
        
    }
}
