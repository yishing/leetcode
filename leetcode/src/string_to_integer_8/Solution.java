package string_to_integer_8;

public class Solution {
	 public int myAtoi(String str) {
	        if(str==null||str.length()==0) return 0;
	       String s= str.trim();
	       long sum=0;
	       int i=0;
	       int sign=1;
	       if(s.charAt(0)=='+'){
	           sign=1;
	           i++;
	       }
	       else if(s.charAt(0)=='-'){
	           sign=-1;
	           i++;
	       }
	       for(;i<s.length();i++){
	           if(!Character.isDigit(s.charAt(i))){
	                return (int)sum*sign;
	           }
	           sum=sum*10+(s.charAt(i)-'0');
	           if (sign == 1 && sum > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
		       if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
	       }
	         return (int)sum*sign;
	    }
}
