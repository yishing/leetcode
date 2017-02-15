package add_two_numbers_445;


// * Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

  public class Solution {
	    class PartialSum{
	        public ListNode sum=null;
	        public int carry=0;
	    }
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	       int length1=getLength(l1);
	       int length2=getLength(l2);
	       if(length1<length2){
	          l1=padList(l1,length2-length1);
	        //   System.out.println(l1.val);
	       }
	       
	       else if(length1>length2){
	           l2=padList(l2,length1-length2);
	            //  System.out.println("2");
	            // System.out.println(l2.val);
	       }
	       
	       PartialSum sum=addList(l1,l2);
	       if(sum.carry==0) return sum.sum;
	       else{
	           ListNode res =insertBefore(sum.sum,sum.carry);
	           return res;
	       }
	       
	    }
	    private PartialSum addList(ListNode l1,ListNode l2){
	        if(l1==null&&l2==null){
	            PartialSum sum=new PartialSum();
	            return sum;
	        }
	        PartialSum sum=addList(l1.next,l2.next);
	        // System.out.println(l1.val);
	        // System.out.println(l2.val);
	        int value=sum.carry+l1.val+l2.val;
	        ListNode res=insertBefore(sum.sum,value%10);
	        sum.sum=res;
	        sum.carry=value/10;
	        // System.out.println(res.val);
	        // System.out.println(sum.carry);
	        return sum;
	        
	    }
	    private static int getLength(ListNode l){
	        int ans=0;
	        while(l!=null){
	            l=l.next;
	            ans++;
	        }
	        return ans;
	    }
	    private static ListNode padList(ListNode l,int length){
	        ListNode res=l;
	        while(length>0){
	         res= insertBefore(res,0);
	         length--;
	        }
	        return res;
	    }
	    private static ListNode insertBefore(ListNode now,int toadd){
	        ListNode res=new ListNode(toadd);
	        res.next=now;
	        return res;
	    }
	}