class Solution{
    static int maxGold(int n,int m,int M[][]){
        if(n==1 && m==1){
            return M[0][0];
        }int res=-1;
        if(m==1){
            for(int j=0;j<n;j++){
                res=Math.max(res,M[j][0]);
            }return res;
        }
        if(n==1){
            res=0;
            for(int j=0;j<m;j++){
                res+=M[0][j];
            }return res; 
        }
        int dp[][]=new int[n][m];
        for(int j=m-1;j>=0;j--){
            for(int i=0;i<n;i++){
                if(j==m-1){
                    dp[i][j]=M[i][j];
                }else if(i==0){
                    dp[i][j]=Math.max(dp[i][j+1],dp[i+1][j+1])+M[i][j];
                }
                else if(i==n-1){
                    dp[i][j]=Math.max(dp[i-1][j+1],dp[i][j+1])+M[i][j];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j+1],Math.max(dp[i+1][j+1],dp[i][j+1]))+M[i][j];
                }
            }
        }
        res=dp[0][0];
        for(int i=0;i<n;i++){
            res=Math.max(res,dp[i][0]);
        }
        return res;
    }
}
