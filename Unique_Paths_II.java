class Solution {
    int dp[][];
    public int uniquePathsWithObstacles(int[][] m) {
        if(m[0][0]==1) return 0;
        dp=new int[m.length][m[0].length];
        for(int x[]:dp){
            Arrays.fill(x,-1);
        }
        return func(m.length-1,m[0].length-1,m);
    }
    public int func(int i, int j, int[][]m){
        if(m[i][j]==0){
            if(i==0 && j==0){
                return dp[i][j]=1;
            }
            if(i==0){
                return dp[i][j]=func(i,j-1,m);
            }
            if(j==0){
                return dp[i][j]=func(i-1,j,m);
            }else if(dp[i][j]!=-1){
                return dp[i][j];
            }
            else{
                return dp[i][j]=func(i-1,j,m)+func(i,j-1,m);
            }    
        }return dp[i][j]=0;
    }
}
