class Solution{
    int longestCommonSubstr(String text1, String text2, int n, int m){
        int dp[][]=new int[n+1][m+1];
        int res=-1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];                                        
                }else{
                    dp[i][j]=0;
                }
                res=Math.max(res,dp[i][j]);
            }
        }return res;
    }
}
