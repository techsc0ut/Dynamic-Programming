class Solution{
    static int maxSquare(int n, int m, int mat[][]){
        int dp[][]=new int[n][m];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(mat[i][j]==0){
                    dp[i][j]=0;
                }else if(i==n-1 || j==m-1){
                    dp[i][j]=1;
                }else{
                    dp[i][j]=Math.min(dp[i+1][j],Math.min(dp[i+1][j+1],dp[i][j+1]))+1  ;  
                }
            }
        }
        int max=dp[0][0];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                max=Math.max(max,dp[i][j]);
            }
        }return max;
    }
}
