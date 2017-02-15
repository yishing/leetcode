package courses_schedule_II_210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList[] graph=new ArrayList[numCourses];
        int[] preCount=new int[numCourses];
        Queue<Integer> queue=new LinkedList<Integer>();
        for(int i=0;i<numCourses;i++){
            graph[i]=new ArrayList<Integer>();
        }
        for(int[] prerequisite:prerequisites){
            graph[prerequisite[0]].add(prerequisite[1]);
            preCount[prerequisite[1]]++;
        }
        int count=0;
        int[] ans=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(preCount[i]==0){
                queue.offer(i);
                // ans[numCourses-1-count]=i;
                count++;
            }
        }
        int index=numCourses-1;
        while(!queue.isEmpty()){
            int now=queue.poll();
            ans[index]=now;
            index--;
            for(int i=0;i<graph[now].size();i++){
                int prepre=(int)graph[now].get(i);
                preCount[prepre]--;
                if(preCount[prepre]==0){
                    queue.offer(prepre);
                    count++;
                }
            }
        }
        if(count==numCourses) return ans;
        else return new int[0];
    }
}