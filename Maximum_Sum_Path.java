class Solution{
    static int maximumPath(int N, int Mat[][]){
        int dp[][]=new int[N][N];
        for(int i=N-1;i>=0;i--){
            for(int j=0;j<N;j++){
                if(i==N-1){
                    dp[i][j]=Mat[i][j];
                }else if(j==0){
                    dp[i][j]=Mat[i][j]+Math.max(dp[i+1][j],dp[i+1][j+1]);
                }else if(j==N-1){
                    dp[i][j]=Mat[i][j]+Math.max(dp[i+1][j],dp[i+1][j-1]);
                }else{
                    dp[i][j]=Mat[i][j]+Math.max(dp[i+1][j],Math.max(dp[i+1][j-1],dp[i+1][j+1]));
                }
            }
        }
        int res=-1;
        for(int i=0;i<N;i++){
            res=Math.max(res,dp[0][i]);
        }return res;
    }
}
