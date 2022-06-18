class Solution{
    static Boolean isSubsetSum(int N, int arr[], int sum){
       boolean dp[][]=new boolean[N+1][sum+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 && j==0){
                    dp[i][j]=true;
                }else if(i==0){
                    dp[i][j]=false;
                }else if(j==0){
                    dp[i][j]=true;
                }else{
                    if(dp[i-1][j]==true){                  // Batting Nahi krega , to check kar pichle bande bna payenge pure runs .
                         dp[i][j]=true; 
                    }else{                                 // Batting krega to de check kr , remaining run bna payenge pichle bande .
                        int val=arr[i-1];
                        if(j>=val){
                            if(dp[i-1][j-val]==true){
                                dp[i][j]=true;
                            }
                        }
                    }
                }
            }
        }return dp[N][sum];
    }
}
