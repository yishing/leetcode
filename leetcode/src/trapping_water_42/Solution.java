package trapping_water_42;

import java.util.Stack;

public class Solution {
//	public int trap(int[] height) {
//        Stack<Integer> stack=new Stack<>();
//        int ans=0;
//        stack.push(0);
//        for(int i=1;i<height.length;i++){
//            if(height[i]>height[stack.peek()]){
//               int bottom=height[stack.pop()];
//               while(!stack.isEmpty()&&height[i]>=height[stack.peek()]){
//                   int temp=stack.pop();
//                   ans=ans+(height[temp]-bottom)*(i-temp-1);
//                   bottom=height[temp];
//               }
//               if(!stack.isEmpty()) ans += (height[i]-bottom)*(i-stack.peek()-1); //解决了 4，3，2这种中间是有一个凹下去的情况
//            }
//            stack.push(i);
//        }
//        return ans;
//    }
	//stasck
	 public int trap(int[] height){
	        if(height.length<3) return 0;
	        int[] left=new int[height.length];
	        int[] right=new int[height.length];
	        left[0]=height[0];
	        int ans=0;
	        right[height.length-1]=height[height.length-1];
	    //  int  high=lower[0];
	        for(int i=1;i<height.length;i++){
	            left[i]=Math.max(left[i-1],height[i-1]);
	        }
	        for(int i=height.length-2;i>=0;i--){
	            right[i]=Math.max(right[i+1],height[i+1]);
	            int minheight=Math.min(right[i],left[i]);
	            if(minheight>height[i]) ans=ans+minheight-height[i];
	        }
	        return ans;
	    }
	 //two pointers
}
