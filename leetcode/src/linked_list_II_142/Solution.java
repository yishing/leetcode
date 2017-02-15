package linked_list_II_142;
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
 public class Solution {
	    public void reorderList(ListNode head) {
	        if(head==null) return;
	        ListNode fast=head;
	        ListNode mid=head;
	        while(fast!=null&&fast.next!=null){
	            fast=fast.next;
	            if(fast.next!=null) fast=fast.next;
	            mid=mid.next;
	        }
	        // ListNode midhead=new ListNode(0);
	        ListNode cur=mid.next;
	        ListNode pre=mid;
	        System.out.println(mid.val);
	        while(cur!=null){
	          ListNode temp=cur.next;
	          cur.next=pre;
	          pre=cur;
	          cur=temp;
	        }
	        mid.next=null;
	        // System.out.println(pre.val);
	        // System.out.println(pre.next.val);
	        // System.out.println(pre.next.next.val);
	        while(head!=null&&pre!=null){
	            ListNode temp1=head.next;
	            ListNode temp2=pre.next;
	            head.next=pre;
	            pre.next=temp1;
	            head=temp1;
	            pre=temp2;
	            
	        }
	         
	        
	    }
	}
