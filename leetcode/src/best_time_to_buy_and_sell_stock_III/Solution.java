package best_time_to_buy_and_sell_stock_III;

public class Solution {
	 public int maxProfit(int[] prices) {
	        int maxprofit=0;
	        if(prices.length<=1) return 0;
	        int leftmin=prices[0];
	        int[] leftProfit=new int[prices.length];
	        for(int i=1;i<prices.length-1;i++){
	            // int left=max(prices,0,i);
	            // int right=max(prices,i,prices.length-1);
	            // maxprofit=Math.max(maxprofit,left+right);
	            if(prices[i]<leftmin) leftmin=prices[i];
	           else{
	               leftProfit[i]=(prices[i]-leftmin)>maxprofit?prices[i]-leftmin:maxprofit;
	           } 
	        }
	        int ans=leftProfit[prices.length-1];
	        int rightProfit=0;
	        int rightmax=prices[prices.length-1];
	        for(int j=prices.length-2;j>=0;j--){
	            if(prices[j]>rightmax){
	                rightmax=prices[j];
	            }
	            else{
	               rightProfit= (rightmax-prices[j])>rightProfit?rightmax-prices[j]:rightProfit;
	            }
	            ans=Math.max(rightProfit+leftProfit[j],ans);
	        }
	        return ans;
	        
	        // return maxprofit;
	    }
}
