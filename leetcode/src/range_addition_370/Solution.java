package range_addition_370;

public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] shenmewanyier=new int[length];
        for(int i=0;i<updates.length;i++){
            shenmewanyier[updates[i][0]]+=updates[i][2];
            if(updates[i][1]<length-1){
            shenmewanyier[updates[i][1]+1]+=-1*updates[i][2];
            }
        }
        int sum=0;
        for(int i=0;i<length;i++){
           
            sum+=shenmewanyier[i];
            shenmewanyier[i]=sum;
        }
        return shenmewanyier;
    }
}