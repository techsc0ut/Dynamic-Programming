class Solution{
    static int eggDrop(int k, int n){
	    int dp[][]=new int[k+1][n+1];
	    for(int i=1;i<=k;i++){
	        for(int j=1;j<=n;j++){
	            if(i==1){
	                dp[i][j]=j;// Only 1 egg, therefore in the worst we have to check each floor.
	            }else if(j==1){
	                dp[i][j]=1;// Only 1 floor, so 1 attempt required 
	            }else{
	                int min=Integer.MAX_VALUE;
	                for(int pj=0,mj=j-1;mj>=0;mj--,pj++){
	                    int v1=dp[i-1][pj];// if egg breaks
	                    int v2=dp[i][mj];// if egg survives
	                    int max=Math.max(v1,v2);
	                    min=Math.min(min,max);
	                }
	                dp[i][j]=min+1;
	            }
	        }
	    }return dp[k][n];
	}
}
