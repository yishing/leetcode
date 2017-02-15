package binary_tree_level_order_traversal_II;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

//  Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> nowList=new ArrayList<Integer>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode now=queue.poll();
                if(now.left!=null) queue.offer(now.left);
                if(now.right!=null) queue.offer(now.right);
                nowList.add(now.val);
            }
            res.add(0,nowList);
        }
        
        return res;
    }
    //bfs
    
    
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        List<List<Integer>> ans=new ArrayList<>();
//        levelTraversal(ans, root, 0);
//         return ans;
//     }
//     public void levelTraversal(List<List<Integer>> ans,TreeNode root,int level){
//         if(root==null) return ;
//         if(level>=ans.size())  ans.add(0, new LinkedList<Integer>());
//           levelTraversal(ans, root.left, level+1);
//           levelTraversal(ans, root.right, level+1);
//           ans.get(ans.size()-level-1).add(root.val);
//     }
     //dfs
}