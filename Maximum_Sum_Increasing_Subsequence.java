class Solution{
	public int maxSumIS(int arr[], int n){  
	    if(n==1){
	        return arr[0];
	    }
	    int max=-1;
	    int dp[]=new int[n];
	    for(int i=0;i<n;i++){
	        dp[i]=arr[i];
	        if(max<dp[i]){
	            max=dp[i];
	        }
	    }
	    for(int i=1;i<n;i++){
	        for(int j=0;j<i;j++){
	            if(arr[j]<arr[i]){
	                dp[i]=Math.max(dp[i],dp[j]+arr[i]);
	            }
	        }
	        if(max<dp[i]){
	            max=dp[i];
	        }
	    }return max;
	}  
}
