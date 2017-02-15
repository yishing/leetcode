package paint_fence_276;

public class Solution {
    public int numWays(int n, int k) {
        if(n==0) return 0;
        if(n==1) return k;
       int[] dp=new int[n+1];
     int  diff=k*k-1;
       int same=k;
       for(int i=2;i<=n;i++){
           int temp=diff;
           diff=(k-1)*(same+diff);
           same=temp;
       }
       return diff+same;
    }
}