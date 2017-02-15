package super_ugly_number_313;

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n==1) return 1;
        int[] f=new int[primes.length];
        int[] dp=new int[n];
        int[] index=new int[primes.length];
        for(int i=0;i<primes.length;i++){
            f[i]=primes[i];
        }
        for(int j=1;j<n;j++){
            int min=Integer.MAX_VALUE;
            // int index=0;
              for(int i=0;i<primes.length;i++){
                     if(f[i]<min){
                        min=f[i];
                     }
                 }
            dp[j]=min;
            for(int i=0;i<primes.length;i++){
                if(min==f[i]) f[i]=dp[++index[i]]*primes[i];
            }
        }
        return dp[n-1];
    }
}
