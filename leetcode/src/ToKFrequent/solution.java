package ToKFrequent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class solution {
	public static List<Integer> topKFrequent1(int[] nums, int k){
	Map<Integer, Integer> counterMap = new HashMap<>();
    for(int num : nums) {
        int count = counterMap.getOrDefault(num, 0);
        counterMap.put(num, count+1);
    }
    
    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue()-b.getValue());
    for(Map.Entry<Integer, Integer> entry : counterMap.entrySet()) {
    	System.out.println("add"+entry.getKey()+"fre"+entry.getValue());
        pq.offer(entry);
        if(pq.size() > k) System.out.println("delete"+pq.poll().getKey());
    }
    
    List<Integer> res = new LinkedList<>();
    while(!pq.isEmpty()) {
        res.add(0, pq.poll().getKey());
    }
    return res;
}
	public static List<Integer> topKFrequent2(int[] nums, int k) {
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for(int num: nums){
	        map.put(num, map.containsKey(num)? map.get(num) + 1 : 1);
	    }
	    PriorityQueue<Map.Entry<Integer, Integer>> pque = 
	    new PriorityQueue<Map.Entry<Integer, Integer>>((o1, o2) -> o1.getValue() - o2.getValue());
	    pque.addAll(map.entrySet());
	    List<Integer> ret = new ArrayList<Integer>();
	    for(int i = 0; i < k; i++){
	    	
	    	int x=pque.poll().getKey();
	    	
	    	System.out.println(x);
	        ret.add(x);
	    }
	    return ret;
	}
}
