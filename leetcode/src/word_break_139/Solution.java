package word_break_139;

import java.util.List;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp=new boolean[s.length()+1];
        int maxLen=0;
        for(String w: wordDict){
            maxLen=Math.max(maxLen,w.length());
        }
        dp[0]=true;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=i+maxLen;j++){
                if(j<=s.length()&&dp[i]&&wordDict.contains(s.substring(i,j))){
                    dp[j]=true;
                    // break;
                }
            }
        }
        return dp[s.length()];
    }
}
