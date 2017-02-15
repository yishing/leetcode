package reversewordsinastring;

public class Solution {
	  public String reverseWords(String s) {
	         if (s == null || s.length() == 0) {
	            return "";
	        }
	        String[] now=s.split(" ");
	        StringBuilder sb=new StringBuilder();
	        for(int i=now.length-1;i>=0;i--){
	            if(!now[i].equals("")){
	            sb.append(now[i]).append(" ");
	            }
	        }
	      return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
	    }

}
