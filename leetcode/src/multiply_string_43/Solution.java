package multiply_string_43;

public class Solution {
	    public static String multiply(String num1, String num2) {
	    	if(num1.equals("0")||num2.equals("0")) return "0";
	       int l1=num1.length()-1;
	       int l2=num2.length()-1;
	       String result="0";
	       while(l2>=0){
	           String ml=multiplyone(num1,num2.charAt(l2));
	           result=add(result,ml,(num2.length()-l2-1));
	           l2--;
	       }
	       return result;
	       
	    }
	    public static String multiplyone(String num,Character s){
	        int carry=0;
	        int l=num.length()-1;
	        int bb;
	        int re;
	        int muliter=s-'0';
	        StringBuilder sb=new StringBuilder();
	        while(l>=0){
	            bb=num.charAt(l--)-'0';
	            re=bb*muliter;
	            sb.append(((re)%10+carry)%10);
	            carry=(re/10+((re)%10+carry)/10);
	        }
	        if(carry!=0) sb.append(carry);
	        return sb.reverse().toString();
	    }
	    public static String add(String result,String ml,int l2){
	        while(l2>0){
	            ml=ml+"0";
	            l2--;
	        }
	         int al=result.length()-1;
	        int bl=ml.length()-1;
	        int carry=0;
	        int aByte;
	        int bByte;
	        int sum;
	        StringBuilder sb=new StringBuilder();
	        while(al>=0||bl>=0){
	            sum=carry;
	            aByte=(al>=0)?result.charAt(al--)-'0':0;
	            bByte=(bl>=0)?ml.charAt(bl--)-'0':0;
	            sum=sum+aByte+bByte;
	            sb.append(sum%10);
	            carry=sum/10;
	        }
	        if(carry==1) sb.append(carry);
	        return sb.reverse().toString();
	    }
}
