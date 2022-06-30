/* Approach 1 */
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        
        int leastLeft=prices[0];
        int dpl[]=new int[n];
        
        for(int i=1;i<n;i++){
            if(prices[i]<leastLeft){
                leastLeft=prices[i];
            }
            dpl[i]=Math.max(dpl[i-1],prices[i]-leastLeft);
        }
        
        int maxRight=prices[n-1];
        int dpr[]=new int[n];
        
        for(int i=n-2;i>=0;i--){
            if(prices[i]>maxRight){
                maxRight=prices[i];
            }
            dpr[i]=Math.max(dpr[i+1],maxRight-prices[i]);
        }
        
        int ans=0;
        
        for(int i=0;i<n;i++){
            if(ans<dpr[i]+dpl[i]){
                ans=dpr[i]+dpl[i];
            }
        }
        
        return ans;
    }
}
