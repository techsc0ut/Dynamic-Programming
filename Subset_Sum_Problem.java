class Solution{
    static Boolean isSubsetSum(int N, int arr[], int sum){
        boolean dp[][]=new boolean[N+1][sum+1];
        dp[0][0]=true;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }return dp[N][sum];
    }
}
