package the_smallest_difference_lintcode;
import java.util.Arrays;

public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
        // int i=0;
        // int j=0;
        Arrays.sort(A);
        Arrays.sort(B);
        int ans=Integer.MAX_VALUE;
        int i=0;
        int j=0;
        while(i<A.length&&j<B.length){
            ans=Math.min(Math.abs(A[i]-B[j]),ans);
            if(ans==0) return 0;
            if(A[i]<B[j]) i++;
            else if(A[i]>B[j]) j++;
        }
        return ans;
    }
}
