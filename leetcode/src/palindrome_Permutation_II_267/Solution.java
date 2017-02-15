package palindrome_Permutation_II_267;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> res=new ArrayList<String>();
        int[] hash=new int[256];
        int oddcount=0;
        for(int i=0;i<s.length();i++){
            hash[s.charAt(i)]++;
            if(hash[s.charAt(i)]%2==0){
                oddcount--;
            }
            else{
                oddcount++;
            }
        }
        if(oddcount>1) return res;
        String mid="";
        int length=0;
        for(int i=0;i<256;i++){
            if(hash[i]>0){
                if(hash[i]==1){
                  mid = "" + (char)i;
                  hash[i]--;  
                } 
                 hash[i] /= 2; 
                length += hash[i];
            }
        }
        String curS="";
        dfs(res,hash,length,mid,curS);
        return res;
    }
    static void dfs(List<String> res,int[] hash,int length,String mid,String curS){
        if(curS.length()==length){
           StringBuilder reverse = new StringBuilder(curS).reverse(); // Second half
            res.add(curS + mid + reverse);
             return;
        }
        for(int i=0;i<256;i++){
            if(hash[i]>0){
                hash[i]--;
                 dfs(res,hash,length+1,mid,curS+(char)i);
                 hash[i]++;
            }
        }
    }
    
}