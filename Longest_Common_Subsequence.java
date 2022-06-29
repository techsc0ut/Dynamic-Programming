/* RECURSIVE + MEMOIZATION */
class Solution {
    int dp[][];
    public int longestCommonSubsequence(String s1, String s2) {
        dp=new int[s1.length()+1][s2.length()+1];
        for(int v[]:dp){
            Arrays.fill(v,-1);
        }
        return func(s1,s2,s1.length(),s2.length());
    }
    public int func(String s1, String s2, int i, int j){
        if(i==0 || j==0){
            return dp[i][j]=0;
        }else if(dp[i][j]!=-1){
            return dp[i][j];
        }
        else if(s1.charAt(i-1)==s2.charAt(j-1)){
            return dp[i][j]=1+func(s1,s2,i-1,j-1);
        }else{
            return dp[i][j]=Math.max(func(s1,s2,i-1,j),func(s1,s2,i,j-1));
        }
    }
}


/* DP TABULATION */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        /*ADD HERE FOR PRINTING LCS*/
        return dp[n][m];
    }
}


/* CODE TO BE ADDED INORDER TO PRINT LCS*/
        String res="";
        int i=dp.length-1, j=dp[0].length-1;
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                res=s1.charAt(i-1)+res;
                i--;j--;
            }else{
                if(dp[i-1][j]>dp[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }
        }
        System.out.println(res);

