package maximal_rectangle_85;
import java.util.Stack;
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0||matrix[0].length==0) return 0;
        int[][] height=new int[matrix.length][matrix[0].length];
      for(int i=0;i<matrix.length;i++){
          for(int j=0;j<matrix[0].length;j++){
              if(i==0&&matrix[i][j]=='1') height[i][j]=1;
              else if(matrix[i][j]=='1'){
                  height[i][j]=height[i-1][j]+1;
              }
          }
      }
      int ans=0;
      for(int i=0;i<matrix.length;i++){
          Stack<Integer> stack=new Stack<Integer>();
          for(int j=0;j<matrix[0].length;j++){
              while(!stack.empty()&&height[i][stack.peek()]>height[i][j]){
                  int pos=stack.pop();
                  ans=Math.max(height[i][pos]*(stack.empty()?j:(j-stack.peek()-1)),ans);
              }
              stack.push(j);
          }
          
          while(!stack.empty()){
               int pos=stack.pop();
              ans=Math.max(height[i][pos]*(stack.empty()?matrix[0].length:(matrix[0].length-stack.peek()-1)),ans);
          }
      }
      return ans;
        }
}