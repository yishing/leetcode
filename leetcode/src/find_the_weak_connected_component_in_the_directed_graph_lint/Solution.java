package find_the_weak_connected_component_in_the_directed_graph_lint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


// * Definition for Directed graph.
 class DirectedGraphNode {
      int label;
      ArrayList<DirectedGraphNode> neighbors;
      DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
  };

public class Solution {
    /**
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
     class UnionFind{
         HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
         public UnionFind(HashSet<Integer> set){
             for(Integer node:set){
                 map.put(node,node);
             }
         }
         public int compressed_find(int x){
             int parent=map.get(x);
             while(parent!=map.get(parent)){
                 parent=map.get(parent);
             }
             int fa=map.get(x);
             int temp=-1;
             while(fa!=map.get(fa)){
                 temp=map.get(fa);
                 map.put(fa,parent);
                 fa=temp;
             }
            return parent;             
         }
         public void union(int x,int y){
             int pa_x=compressed_find(x);
             int pa_y=compressed_find(y);
             if(pa_x!=pa_y){
                 map.put(pa_x,pa_y);
             }
         }
         
     }
     List<List<Integer> >  print(HashSet<Integer> hashSet, UnionFind uf, int n) {
    List<List <Integer> > ans = new ArrayList<List<Integer>>();
  HashMap<Integer, List <Integer>> hashMap = new HashMap<Integer, List <Integer>>();
  for(int i : hashSet){
    int fa = uf.compressed_find(i);
    if(!hashMap.containsKey(fa)) {
      hashMap.put(fa,  new ArrayList<Integer>() );
    }
    List <Integer> now =  hashMap.get(fa);
    now.add(i);
    hashMap.put(fa, now);
  }
  for( List <Integer> now: hashMap.values()) {
  Collections.sort(now);
    ans.add(now);
  }
    return ans;
  }
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // Write your code here
        // HashMap<Integer,Integer> map=new HahsMap<Integer,Integer>();
        HashSet<Integer> set=new HashSet<Integer>();
        for(DirectedGraphNode node:nodes){
            set.add(node.label);
            for(DirectedGraphNode neighbor:node.neighbors){
                set.add(neighbor.label);
            }
        }
        UnionFind uf=new UnionFind(set);
         for(DirectedGraphNode node:nodes){
             for(DirectedGraphNode neighbour : node.neighbors) {
                int fnow = uf.compressed_find(node.label);
                int fneighbour = uf.compressed_find(neighbour.label);
                if(fnow!=fneighbour){
                    uf.union(fnow,fneighbour);
                }
             }
         }
         return print(set,uf,nodes.size());
    }
}