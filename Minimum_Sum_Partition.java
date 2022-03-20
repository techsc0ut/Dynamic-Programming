class Solution{
  static boolean dp[][];
	public int minDifference(int arr[], int n){
	    int curSum=0;
	    for(int x:arr){ curSum+=x; }
	    int s1=0;
	    func(arr,n,curSum/2);
	    for(int  i=0;i<=curSum/2;i++){
	        if(dp[n][i]){
	            s1=i;
	        }
	    }
	    return curSum-(2*s1);
	} 
	static boolean func(int arr[], int n, int sum){
	    dp=new boolean[n+1][sum+1];
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
        }return dp[n][sum];
	} 
}
