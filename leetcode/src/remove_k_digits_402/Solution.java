package remove_k_digits_402;
import java.util.Stack;

public class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack=new Stack<Integer>();
        int n=num.length();
        int count=k;
        if(num.length()<=k) return "0";
       for(int i=0;i<num.length();i++){
        //   if(count==k) break;
        int number=num.charAt(i)-'0';
         while(!stack.isEmpty()&&number<stack.peek()&&count>0){
             count--;
             stack.pop();
         }
         stack.push(number);
       }
       while(count>0){
           stack.pop();
           count--;
       }
       StringBuilder sb=new StringBuilder();
       while(!stack.isEmpty()){
           int a=stack.pop();
        //   System
           sb.append(a);
       }
       sb.reverse();
         while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString();
       
    }
}