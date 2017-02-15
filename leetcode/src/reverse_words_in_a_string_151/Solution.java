package reverse_words_in_a_string_151;
import java.util.Stack;
public class Solution {
    public static String reverseWords(String s) {
        Stack<String> stack=new Stack<String>();
        int i=0;
        while(i<s.length()){
            int j=i;
            while(j<s.length()&&s.charAt(j)!=' '){
                j++;
            }
            if(j-i==0) continue;
            stack.push(s.substring(i,j));
            i=j+1;
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
            sb.append(' ');
        }
        return sb.toString();
    }
	public static void main(String[] args){
		String s=" ";
		System.out.println(reverseWords(s));
	}
}
