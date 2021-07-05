class Solution{
    static int nCr(int n,int r){
        if(r>n){
            return 0;
        }
        if(n-r<r){
            r=n-r;
        }
        int dp[]=new int[r+1];
        dp[0]=1;
        int mod=1000000007;
        for(int i=1;i<=n;i++){
            for(int j=Math.min(i,r);j>0;j--){
                dp[j]=(dp[j-1]+dp[j])%mod;
            }
        }return dp[r];
    }
}
