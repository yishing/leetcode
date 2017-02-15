package largest_rectangle_in_histogram_84;
import java.util.Stack;
public class Solution {
    public int largestRectangleArea(int[] heights) {
         if(heights.length==0) return 0;
      Stack<Integer> stack=new Stack<Integer>();
      int ans=0;
      for(int i=0;i<heights.length;i++){
          while(!stack.empty()&&heights[stack.peek()]>heights[i]){
              int pos=stack.pop();
            //   ans=Math.max(heights[pos]*(stack.empty()?i:(i-stack.peek()-1)),ans);
               ans=Math.max(heights[pos]*(stack.empty()?i:(i-stack.peek()-1)),ans);
          }
          stack.push(i);
      }
      while(!stack.empty()){
           int pos=stack.pop();
              ans=Math.max(heights[pos]*(stack.empty()?heights.length:heights.length-stack.peek()-1),ans);
      }
      return ans;
    }
}
