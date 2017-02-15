package course_schedule_207;
import java.util.Queue;
import java.util.LinkedList;
import  java.util.ArrayList;
public class Solution {
    // class Class{
    //     int C
    // }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length==0) return true;
        // HashSet<Integer> set=new HashSet<Integer>();
        ArrayList[] pre=new ArrayList[numCourses];
        Queue<Integer> queue=new LinkedList<Integer>();
        int[] precount=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            pre[i]=new ArrayList<Integer>();
        }
        for(int[] prerequisite:prerequisites){
            pre[prerequisite[0]].add(prerequisite[1]);
           precount[prerequisite[1]]++;
            
        }
        int count=0;
        
        for(int i=0;i<numCourses;i++){
            if(precount[i]==0){
                queue.offer(i);
                count++;
            }
        }
        while(!queue.isEmpty()){
            int now=queue.poll();
            for(int i=0;i<pre[now].size();i++){
                int prepre=(int) pre[now].get(i);
                precount[prepre]--;
                if(precount[prepre]==0){
                    queue.offer(prepre);
                    count++;
                }
            }
        }
        return count==numCourses;
        
    }
}