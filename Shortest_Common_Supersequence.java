class Solution{
    public static int shortestCommonSupersequence(String X,String Y,int m,int n){
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 || j==0){
                    dp[i][j]=0;
                }else if(X.charAt(i-1)==Y.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        /* Printing SCS */
        /**
        String Res="";
        int i=m, j=n;
        while(i>0 && j>0){
            if(X.charAt(i-1)==Y.charAt(j-1)){
                Res=X.charAt(i-1)+Res;
                i--;j--;
            }else if(dp[i-1][j]>dp[i][j-1]){
                Res=X.charAt(i-1)+Res;
                i--;
            }else{
                Res=Y.charAt(j-1)+Res;
                j--;
            }
        }
        while(i>0){
            Res=X.charAt(i-1)+Res;
            i--;
        }
        while(j>0){
            Res=Y.charAt(j-1)+Res;
            j--;
        }
        System.out.println(Res);
        **/
        return ((m+n)-dp[m][n]);
        
    }
}
