package merge_k_sorted_lists_23;
import java.util.PriorityQueue;
import java.util.Comparator;
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
 
 
public class Solution {
    private static Comparator<ListNode> listComparator=
        new Comparator<ListNode>(){
            @Override 
            public int compare(ListNode l1,ListNode l2){
                return l1.val-l2.val;
            }
        };
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length==0) return null;
        PriorityQueue<ListNode> pq=new PriorityQueue<ListNode>(listComparator);
        for(ListNode node:lists){
            pq.offer(node);
        }
        ListNode dummy=new ListNode(0);
        ListNode ans=dummy;
        while(!pq.isEmpty()){
            ListNode cur=pq.poll();
            dummy.next=cur;
            ListNode temp=cur.next;
            cur.next=null;
            pq.offer(temp);
            dummy=dummy.next;
            
        }
        return ans.next;
    }
}