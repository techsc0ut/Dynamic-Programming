/* Memoized Recursive Solution */
class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int [] x:dp){
            Arrays.fill(x,-1);
        }
        return func(dp,0,0,m,n);
    }
    static int func(int dp[][],int i,int j,int m,int n){
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(i>m-1 || j>n-1){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        return dp[i][j]=func(dp,i+1,j,m,n)+func(dp,i,j+1,m,n);
    }
}
