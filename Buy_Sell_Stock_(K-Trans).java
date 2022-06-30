/*
  This is non-optimized version , and takes O(n^3) time .
*/
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        if(n==0 || n==1){
            return 0;
        }
        int dp[][]=new int [k+1][n];
        for(int i=1;i<k+1;i++){
            for(int j=1;j<n;j++){
                int max=dp[i][j-1];
                for(int a=0;a<j;a++){
                    if(max<(dp[i-1][a]+prices[j]-prices[a])){
                        max=(dp[i-1][a]+prices[j]-prices[a]);
                    }
                }
                dp[i][j]=max;
            }
        }return dp[k][n-1];
    }
}
