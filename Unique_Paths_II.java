/* DP Solution */
class Solution {
    public int uniquePathsWithObstacles(int[][] m) {
        if(m[0][0]==1) return 0;
        int dp[][]=new int[m.length][m[0].length];
        dp[0][0]=1;
        for(int i=1;i<m.length;i++){
            if(m[i][0]==0){
                dp[i][0]=dp[i-1][0];    
            }
        }
        for(int i=1;i<m[0].length;i++){
            if(m[0][i]==0){
                dp[0][i]=dp[0][i-1];
            }
        }
        for(int i=1;i<m.length;i++){
            for(int j=1;j<m[0].length;j++){
                if(m[i][j]==0){
                    dp[i][j]=dp[i][j-1]+dp[i-1][j];
                }
            }
        }
        return dp[m.length-1][m[0].length-1];
    }
}

/* Recursive Memoized */
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
