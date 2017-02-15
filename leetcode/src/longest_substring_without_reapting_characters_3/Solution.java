package longest_substring_without_reapting_characters_3;
import java.util.Arrays;
public class Solution {
	public int lengthOfLongestSubstring(String s) {
		if(s==null||s.length()==0) return 0;
		int[] hash=new int[256];
		int ans=1;
		Arrays.fill(hash, -1);
		int j=0;
		for(int i=0;i<s.length();i++){
			j=Math.max(hash[s.charAt(i)]+1, j);
			hash[s.charAt(i)]=i;
			ans=Math.max(i-j+1, ans);
		}
		
		
		return ans;
	}
}
