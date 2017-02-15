package graph_valid_tree_261;

public class Solution {
    public boolean validTree2(int n, int[][] edges) {
        // initialize n isolated islands
        int[] nums = new int[n];
       // Arrays.fill(nums, -1);
        for(int i=0;i<n;i++) nums[i]=-1;
        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            
            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;
            
            // union
            nums[x] = y;
        }
        
        return edges.length == n - 1;
    }
    
    int find(int nums[], int i) {
        if (nums[i] == -1) return i;
        return find(nums, nums[i]);
    }
}
