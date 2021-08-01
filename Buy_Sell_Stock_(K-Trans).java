/*
  This is non-optimized version , and takes O(n^3) time .
*/
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        if(n<=1){
            return 0;
        }
        int dp[][]=new int[k+1][n];
        for(int i=0;i<=k;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }else{
                    int max=0;
                    for(int c=0;c<j;c++){
                        if(i-1>=0){
                            max=Math.max(max,dp[i-1][c]+(prices[j]-prices[c]));    
                        }
                    }
                    if(j-1>=0){
                        max=Math.max(max,dp[i][j-1]);
                    }
                    dp[i][j]=max;    
                }
            }
        }return dp[k][n-1];
    }
}
