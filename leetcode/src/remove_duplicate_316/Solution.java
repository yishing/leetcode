package remove_duplicate_316;

import java.util.Stack;

public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] hash=new int[26];
        boolean[] visited=new boolean[26];
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a']++;
        }
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)-'a']--;
             if(visited[s.charAt(i)-'a']) continue;
            while(!stack.isEmpty()&&s.charAt(i)<stack.peek()&&hash[stack.peek()-'a']!=0){
                visited[stack.pop()-'a']=false;
            }
            stack.push(s.charAt(i));
            visited[s.charAt(i)-'a']=true;
            
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
             sb.append(stack.pop());
        }
        return sb.reverse().toString();
       
       
            
        }
}