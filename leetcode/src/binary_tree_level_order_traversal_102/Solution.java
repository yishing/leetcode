package binary_tree_level_order_traversal_102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// * Definition for a binary tree node.
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> list=new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                TreeNode now=queue.poll();
                if(now.left!=null) queue.offer(now.left);
                 if(now.right!=null) queue.offer(now.right);
                list.add(now.val);
            }
            res.add(list);
        }
        return res;
        
    }
    //bfs
    
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> res=new ArrayList<>();
//        if(root==null) return res;
//        dfs(res,root,0);
//        return res;
//        
//    }
//    public void dfs(List<List<Integer>> res,TreeNode root,int level){
//        if(root==null) return ;
//        if(level>=res.size()){
//            res.add(new LinkedList<Integer>());
//        }
//          dfs(res, root.left, level+1);
//          dfs(res, root.right, level+1);
//        res.get(level).add(root.val);
//        
//    }
    //dfs
    
    
    
}