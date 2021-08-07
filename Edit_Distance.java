/**
  
  Given two strings s and t. Find the minimum number of operations that need to be performed on str1 to convert it to str2. The possible operations are:
    Insert
    Remove
    Replace
       
                 **/
 
class Solution {
    public int editDistance(String s, String t) {
        int n=s.length();
        int m=t.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=i;
        }
        for(int i=0;i<dp.length;i++){
            dp[i][0]=i;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(dp[i][j-1],Math.min(dp[i-1][j-1],dp[i-1][j]))+1;
                }
            }
        }
        return dp[n][m];
    }
}
