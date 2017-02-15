package top_k_frequent_elements_347;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
       HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
       for(int i=0;i<nums.length;i++){
           if(!map.containsKey(nums[i])){
               map.put(nums[i],0);
           }
           int count=map.get(nums[i]);
           map.put(nums[i], ++count);
       }
       List<Integer>[] countMap=new List[nums.length+1];
       for(int i=0;i<=nums.length;i++){
           countMap[i]=new ArrayList<Integer>();
       }
       for(Integer now:map.keySet()){
          int count=map.get(now);
          countMap[count].add(now);
       }
       int count=0;
       int n=nums.length;
       List<Integer> res=new ArrayList<Integer>();
      for(int i=nums.length;i>=0;i--){
          int size=countMap[i].size();
          if(count+size<k){
              res.addAll(countMap[i]);
              count+=size;
              continue;
          }
          else{
              int j=0;
              while(count<k){
                  res.add(countMap[i].get(j));
                  j++;
                  count++;
              }
          }
      }
      return res;
       
        }
}