package invert_binary_tree_226;
import java.util.Queue;
import java.util.LinkedList;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        // if(root==null) return null;
        // TreeNode l=root.left;
        // TreeNode r=root.right;
        // root.left=r;
        // root.right=l;
        // invertTree(root.left);
        // invertTree(root.right);
        // return root;
        if(root==null) return null;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode now=queue.poll();
            TreeNode l=now.left;
            now.left=now.right;
            now.right=l;
            if(now.left!=null) queue.offer(now.left);
            if(now.right!=null) queue.offer(now.right);
        }
        return root;
    }
}