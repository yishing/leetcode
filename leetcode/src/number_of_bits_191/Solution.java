package number_of_bits_191;

public class Solution {
	public int hammingWeight(int n) {
	 int ans=0;
     while(n!=0){
         ans=(n&1)==1?ans+1:ans;
         n=n>>>1;
     }  
     return ans;
}
}
