package find_the_difference_389;

public class Solution {
    public char findTheDifference(String s, String t) {
      char ans=0;
    //   for(Character c:s) ans=ans^c;
    //   for(Character c:t) ans=ans^c;
    for(int i=0;i<s.length();i++){
        ans^=s.charAt(i);
    }
        for(int i=0;i<t.length();i++){
        ans^=t.charAt(i);
    }
        return ans;
    }
}

