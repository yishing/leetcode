package balanced_binary_tree_110;


//  Definition for a binary tree node.
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
    public boolean isBalanced(TreeNode root) {
       return maximunHeight(root)!=-1;
    }
    public int maximunHeight(TreeNode root){
        if(root==null) return 0;
        int LH= maximunHeight(root.left);
        if(LH==-1) return -1;
        int RH= maximunHeight(root.right);
        if(RH==-1) return -1;
        return Math.abs(LH-RH)<=1?(Math.max(LH,RH)+1):-1;
    }
}