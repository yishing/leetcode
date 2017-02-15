package paint_house_256;

public class Solution {
    public int minCost(int[][] costs) {
      int n=costs.length;
      int[] green=new int[2];
      int[] red=new int[2];
      int[] blue=new int[2];
     
      for(int i=1;i<=n;i++){
          green[i%2]=Math.min(red[(i-1)%2],blue[(i-1)%2])+costs[i-1][2];
          red[i%2]=Math.min(blue[(i-1)%2],green[(i-1)%2])+costs[i-1][0];
          blue[i%2]=Math.min(red[(i-1)%2],green[(i-1)%2])+costs[i-1][1];
      }
      return Math.min(green[n%2],Math.min(red[n%2],blue[n%2]));
    }
}