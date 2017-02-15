package add_Binary_67;

public class Solution {
	public static String addBinary1(String a, String b) {
        StringBuilder sb = new StringBuilder();
     int i = a.length() - 1, j = b.length() -1, carry = 0;
     while (i >= 0 || j >= 0) {
         int sum = carry;
         if (j >= 0) sum += b.charAt(j--) - '0';
         if (i >= 0) sum += a.charAt(i--) - '0';
         sb.append(sum % 2);
         carry = sum / 2;
     }
     if (carry != 0) sb.append(carry);
     return sb.reverse().toString();
 }
	public static String addBinary2(String a, String b) {
        if(a == null || a.isEmpty()) {
           return b;
       }
       if(b == null || b.isEmpty()) {
           return a;
       }
       StringBuilder sb=new StringBuilder();
       int al=a.length()-1;
       int bl=b.length()-1;
       int carry=0;
       char[] ca=a.toCharArray();
       char[] cb=b.toCharArray();
       int aByte;
       int bByte;
       int now=0;
       while(al>-1||bl>-1||carry==1){
            aByte = (al > -1) ? Character.getNumericValue(ca[al--]) : 0;
           bByte = (bl > -1) ? Character.getNumericValue(cb[bl--]) : 0;
           now=aByte^bByte^carry;
           carry=(aByte+bByte+carry)>=2?1:0;
           sb.append(now);
           
       }
       return sb.reverse().toString();
       
   }

}
