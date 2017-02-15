package queue_reconstruct_by_height_406;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2){
                return o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0];
            }
        }
            );
            List<int[]> ans=new ArrayList<int[]>();
          
            for(int[] now:people){
                ans.add(now[1],now);
            }
             return ans.toArray(new int[people.length][]);
        }
       
    }