class Solution{
    public long count(int S[],int m,int n){ 
        long dp[]=new long[n+1];
        Arrays.fill(dp,0);
        dp[0]=1;
        for(int j=0;j<m;j++){
            for(int i=S[j];i<dp.length;i++){
                dp[i]+=dp[i-S[j]];    
            }       
        }
        return dp[n];
    } 
}
