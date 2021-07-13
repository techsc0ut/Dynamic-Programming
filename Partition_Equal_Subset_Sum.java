class Solution{
    static int equalPartition(int N, int arr[]){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        if(sum%2==1){
            return 0;
        }
        return subset_sum(N,arr,sum/2);
    }
    static int subset_sum(int N,int arr[],int tar){
        int dp[][]=new int[N+1][tar+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 && j==0){
                    dp[i][j]=1;
                }else if(i==0){
                    dp[i][j]=0;
                }else if(j==0){
                    dp[i][j]=1;
                }else{
                    if(dp[i-1][j]==1){
                        dp[i][j]=1;
                    }else{
                        int val=arr[i-1];
                        if(j>=val){
                            if(dp[i-1][j-val]==1){
                                dp[i][j]=1;
                            }
                        }
                    }
                }
            }
        }return dp[N][tar];
    }
}
