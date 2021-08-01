class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        if(n<=1){
            return 0;
        }
        int dp[][]=new int[k+1][n];
        for(int i=1;i<=k;i++){
            int max=Integer.MIN_VALUE;
            for(int j=1;j<n;j++){
                if(max<dp[i-1][j-1]-prices[j-1]){
                    max=dp[i-1][j-1]-prices[j-1];
                }
                if(max+prices[j]>dp[i][j-1]){
                    dp[i][j]=max+prices[j];
                }else{
                    dp[i][j]=dp[i][j-1];
                }
            }
        }return dp[k][n-1];
    }
}
