// Top Down Memoization
class Solution{
    static int dp[][];
	public int minOperations(String s1, String s2){ 
	    dp=new int[s1.length()+1][s2.length()+1];
	    for(int x[]:dp){
	        Arrays.fill(x,-1);
	    }
	    return func(s1,s2,s1.length(),s2.length());
	} 
	public int func(String s1, String s2, int n, int m){
	    if(n==0 || m==0){
	        return dp[n][m]=n==0?m:n;    
	    }
	    if(dp[n][m]!=-1){
	        return dp[n][m];
	    }
	    if(s1.charAt(n-1)==s2.charAt(m-1)){
	        return dp[n][m]=func(s1,s2,n-1,m-1);
	    }else{
	        return dp[n][m]=1+Math.min(func(s1,s2,n,m-1),func(s1,s2,n-1,m));
	    }
	}
}

/*-------------------------------------------------------------------------*/

// Bottom-Up DP TABULATION
class Solution{
	public int minOperations(String s1, String s2){ 
	    int n=s1.length();
	    int m=s2.length();
	    int [][]dp=new int[n+1][m+1];
	    for(int i=0;i<=m;i++){
	        dp[0][i]=i;
	    }
	    for(int i=0;i<=n;i++){
	        dp[i][0]=i;
	    }
	    for(int i=1;i<=n;i++){
	        for(int j=1;j<=m;j++){
	            if(s1.charAt(i-1)==s2.charAt(j-1)){
	                dp[i][j]=dp[i-1][j-1];
	            }else{
	                dp[i][j]=1+Math.min(dp[i-1][j],dp[i][j-1]);
	            }
	        }
	    }
	    return dp[n][m];
	}
}
