class Solution {
    public int minDistance(String word1, String word2) {
        int n1=word1.length();
        int n2=word2.length();
        /* if s1 is empty, then we need to insert n2 number of elements */
        if(n1==0){
            return n2;
        }
        /* if s2 is empty, then we need to remove n1 number of elements */
        if(n2==0){
            return n1;
        }
        int dp[][]=new int[n1+1][n2+1];
        for(int i=0;i<=n1;i++){
            for(int j=0;j<=n2;j++){
                /* when s1 is empty, we need to insert j number of characters to transform into string till jth index */
                if(i==0){
                    dp[i][j]=j;
                }
                /* when s2 is empty, we need to remove i number of characters to transform into empty string */ 
                else if(j==0){
                    dp[i][j]=i;
                }
                /* when character matches, then we just need to find the min no. of operations to transform string s1 till (i-1)th index to string s2 till (j-1)th index */
                else if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                /* when characters don't match, we need to find the min operations from the three choices of remove, insert and replace */
                else{
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        return dp[n1][n2];
    }
}
