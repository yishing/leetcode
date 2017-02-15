package number_of_Connected_Components_in_an_Undirected_Graph_323;

public class Solution {
    public int countComponents(int n, int[][] edges) {
      int[] hashmap=new int[n];
    //   int count=1;
    for(int i=0;i<n;i++){
         hashmap[i] = i; 
    }
      for(int[] edge:edges){
          int i1=findFather(edge[0],hashmap);
          int i2=findFather(edge[1],hashmap);
          if(i1!=i2) {
              hashmap[i1]=i2;
              n--;
          }
      }
      return n--;
    }
   int findFather(int i1,int[] map){
       while(map[i1]!=i1){
           i1=map[i1];
       }
       return i1;
   }
}