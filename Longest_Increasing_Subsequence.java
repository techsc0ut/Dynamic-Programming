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



