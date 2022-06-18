/* Recursive + Memoization */
class Solution{ 
    static int dp[][];
    static int knapSack(int W, int wt[], int val[], int N) { 
        dp=new int[W+1][N+1];
        for(int x[]:dp){
            Arrays.fill(x,-1);
        }
        return func(W,N,wt,val);
    } 
    static int func(int sackWt, int lastItem, int wt[], int val[]){
       if(lastItem==0 || sackWt==0){
           return dp[sackWt][lastItem]=0;
       }
       if(dp[sackWt][lastItem]!=-1){
           return dp[sackWt][lastItem];
       }
       if(wt[lastItem-1]<=sackWt){
           return dp[sackWt][lastItem]=Math.max(val[lastItem-1]+func(sackWt-wt[lastItem-1],lastItem-1,wt,val),
           func(sackWt,lastItem-1,wt,val));
       }else{
           return dp[sackWt][lastItem]=func(sackWt,lastItem-1,wt,val);
       }
    }
}

/* Tabulation DP*/
class Solution { 
    static int knapSack(int W, int wt[], int val[], int n){ 
        int dp[][]=new int[n+1][W+1];
        for(int i=1;i<=n;i++){
            for(int j=0;j<=W;j++){
                if(wt[i-1]<=j){
                    dp[i][j]=Math.max(dp[i-1][j],val[i-1]+dp[i-1][j-wt[i-1]]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    } 
}


