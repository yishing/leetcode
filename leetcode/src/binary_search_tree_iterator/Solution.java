package binary_search_tree_iterator;
import  java.util.Stack;

   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


public class Solution {
    // List<Integer>  list=new ArrayList<Integer>();
    // int index;
    private Stack<TreeNode> stack;
    public Solution(TreeNode root) {
       Stack<TreeNode> stack=new Stack<TreeNode>();
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    /** @return the next smallest number */
    public int next() {
    TreeNode now=stack.pop();
    int r=now.val;
    if(now.right!=null){
        while(now!=null){
            stack.push(now);
            now=now.left;
        }
    }
    return r;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */