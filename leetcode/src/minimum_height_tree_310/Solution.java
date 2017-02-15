package minimum_height_tree_310;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] level=new int[n];
        ArrayList[] graph=new ArrayList[n];
        Queue<Integer> queue=new LinkedList<Integer>();
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<Integer>();
        }
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
            level[edge[0]]++;
            level[edge[1]]++;
        }
        for(int i=0;i<n;i++){
            if(level[i]==1){
                queue.offer(i);
            }
        }
        while(n>2){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int now=queue.poll();
                n--;
                for(int j=0;j<graph[now].size();j++){
                    int neighbor=(int)graph[now].get(j);
                    level[neighbor]--;
                    if(level[neighbor]==1){
                        queue.offer(neighbor);
                    }
                }
                
            }
        }
        List<Integer> ans=new ArrayList<Integer>();
        while(!queue.isEmpty()){
            ans.add(queue.poll());
        }
        return ans;
    }
}