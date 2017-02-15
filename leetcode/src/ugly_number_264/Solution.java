package ugly_number_264;

public class Solution {
	   public int nthUglyNumber(int n) {
	    if(n==1) return 1;
	    if(n==2) return 2;
	    if(n==3) return 3;
	    if(n==4) return 4;
	    int[] dp=new int[n];
	    dp[0]=1;
	    int f1=2;
	    int f2=3;
	    int f3=5;
	    int i1=0;int i2=0;int i3=0;
	    for(int i=1;i<n;i++){
	       dp[i]= Math.min(Math.min(f1,f2),f3);
	       if(dp[i]==f1){
	            f1=2*dp[++i1];
	          //  i1++;
	        }
	         if(dp[i]==f2){
	            f2=3*dp[++i2];
	            //i2++;
	        }
	         if(dp[i]==f3){
	            f3=5*dp[++i3];
	         //   i3++;
	        }
	    }
	    return dp[n-1];
	}
	}