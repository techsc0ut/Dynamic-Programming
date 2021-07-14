class Solution{
    static int longestSubsequence(int N,int nums[]){
        int dp[]=new int[nums.length];
        dp[0]=1;int res=1;
        for(int i=1;i<dp.length;i++){
            int max=0;
            for(int j=0;j<i;j++){
                if(Math.abs(nums[j]-nums[i])==1){
                    if(max<dp[j]){
                        max=dp[j];
                    }
                }
            }
            dp[i]=max+1;
            res=Math.max(dp[i],res);
        }return res;    
    }
}
