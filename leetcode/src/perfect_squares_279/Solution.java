package perfect_squares_279;
import java.util.Queue;
import  java.util.LinkedList;
public class Solution {
    public int numSquares(int n) {
    Queue<Integer> queue=new LinkedList<Integer>();
    int[] dp=new int[n+1];
    int i=1;
    while(i*i<=n){
        if(i*i==n) return 1;
        dp[i*i]=1;
        queue.offer(i*i);
    }
    while(!queue.isEmpty()){
        int now=queue.poll();
        for( i=1;i*i+now<=n;i++){
            if(i*i+now==n) return dp[now]+1;
            else if(i*i+now<n&&dp[i*i+now]==0){
                dp[i*i+now]=dp[now]+1;
                queue.offer(i*i+now);
            }
            else if(i*i+now>n) break;
        }
    }
    return dp[n];
    }
}