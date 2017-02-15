package trapping_rainwater_II_407;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int trapRainWater(int[][] heightMap) {
         int []dx = {1,-1,0,0};
         int []dy = {0,0,1,-1};
        if(heightMap.length<1) return 0;
        PriorityQueue<Point> queue =  new PriorityQueue<Point>(1,new PointComparator());
        boolean[][] visited=new boolean[heightMap.length][heightMap[0].length];
        for(int i=0;i<heightMap.length;i++){
            queue.offer(new Point(i,0,heightMap[i][0]));
            queue.offer(new Point(i,heightMap[0].length-1,heightMap[i][heightMap[0].length-1]));
            visited[i][0]=true;
            visited[i][heightMap[0].length-1]=true;
        }
        for(int i=0;i<heightMap[0].length;i++){
              queue.offer(new Point(0,i,heightMap[0][i]));
            queue.offer(new Point(heightMap.length-1,i,heightMap[heightMap.length-1][i]));
            visited[0][i]=true;
            visited[heightMap.length-1][i]=true;
        }
        int ans=0;
        while(!queue.isEmpty()){
            Point now=queue.poll();
            System.out.println(now.h);
            for(int i=0;i<4;i++){
                int nx=now.x+dx[i];
                int ny=now.y+dy[i];
                if(nx>=0&&nx<=heightMap.length-1&&ny>=0&&ny<=heightMap[0].length-1&&!visited[nx][ny]){
                    ans+=(heightMap[now.x][now.y]>heightMap[nx][ny])?(heightMap[now.x][now.y]-heightMap[nx][ny]):0;
                    visited[nx][ny]=true;
                    queue.offer(new Point(nx,ny,Math.max(now.h,heightMap[nx][ny])));
                }
            }
        }
        return ans;
    }
}
class Point{
    public int x;
    public int y;
    public int h;
    public Point(int _x,int _y,int _h){
        x=_x;
        y=_y;
        h=_h;
    }
    
}
class PointComparator implements Comparator<Point>{
    public int compare(Point p1,Point p2){
        if(p1.h > p2.h)
      return 1;
    else if(p1.h == p2.h){
     return 0;
    }
    else {
      return -1;
    }
    }
}