/* Memoized Solution */
class Solution {
    static int dp[][];
    public int longestCommonSubsequence(String s1, String s2) {
        dp=new int[s1.length()+1][s2.length()+1];
        for(int x[]:dp){
            Arrays.fill(x,-1);
        }
        return LCS(s1,s2,s1.length(),s2.length());
    }
    public int LCS(String s1, String s2, int n, int m){
        if(n==0 || m==0){
            return dp[n][m]=0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        if(s1.charAt(n-1)==s2.charAt(m-1)){
            return dp[n][m]=1+LCS(s1,s2,n-1,m-1);
        }
        else{
            return dp[n][m]=Math.max(LCS(s1,s2,n-1,m),LCS(s1,s2,n,m-1));
        }
    }
}

/* Top Down DP TABLE */
class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int dp[][]=new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }return dp[s1.length()][s2.length()];
    }
}



