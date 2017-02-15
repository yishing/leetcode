package valid_binary_sarch_tree_98;
  class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class Solution {
    public boolean isValidBST(TreeNode root) {
      return isValid(root,null,null);
    }
    public boolean isValid(TreeNode root,Integer low,Integer high){
        if(root==null) return true;
        if((low==null||root.val>low)&&(high==null||root.val<high)){
        return isValid(root.left,low,root.val)&&isValid(root.right,root.val,high);}
        return false;

    }
}