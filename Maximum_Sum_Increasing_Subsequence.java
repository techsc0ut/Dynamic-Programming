class Solution{
	public int maxSumIS(int arr[],int n){  
	    int res=arr[0];
	    int dp[]=new int[n];
	    dp[0]=arr[0];
	    for(int i=1;i<n;i++){
	        int max=0;
	        for(int j=0;j<i;j++){
	            if(arr[i]>arr[j]){
	                if(max<dp[j]){
	                    max=dp[j];
	                }
	            }
	        }
	        dp[i]=max+arr[i];
	        res=Math.max(res,dp[i]);
	    }return res;
	}  
}
