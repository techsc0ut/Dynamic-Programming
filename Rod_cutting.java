class Solution{
    public int cutRod(int price[], int n) {
        int dp[]=new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int max=-1;
            for(int j=1;j<=i;j++){
                max=Math.max(max,dp[i-j]+price[j-1]);
            }
            dp[i]=max;
        }return dp[n];
    }
}
