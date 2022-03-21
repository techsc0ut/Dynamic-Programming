/*
  Thanks to aditya verma for his approach :)
*/
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length==1){
            if(Math.abs(nums[0])==Math.abs(target)){
                return 1;
            }return 0;
        }
        int curSum=0;
        for(int x:nums){
            curSum+=x;
        }
        if(target>curSum || (curSum-target)%2!=0){
            return 0;            
        }
        int s1=(target+curSum)/2;
        return countSubsetSum(nums,nums.length,s1);
    }
    static int countSubsetSum(int nums[], int N, int sum){
        int dp[][]=new int[N+1][sum+1];
        dp[0][0]=1;
        int zeroCount=0;
        for(int i=1; i<=N; i++) {
			if(nums[i-1]==0) zeroCount++;
			dp[i][0] = (int)(Math.pow(2, zeroCount));
		}
        for(int i=1;i<=N;i++){
            for(int j=1;j<=sum;j++){
                if(j>=nums[i-1]){
                    dp[i][j]=dp[i-1][j-nums[i-1]]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[N][sum];
    }
}
