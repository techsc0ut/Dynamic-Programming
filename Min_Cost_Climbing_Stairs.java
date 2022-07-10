/* Memoized Recursive */
class Solution {
    int dp[];
    public int minCostClimbingStairs(int[] nums) {
        int n=nums.length;
        dp=new int[n];
        Arrays.fill(dp,-1);
        return Math.min(func(nums,n-1),func(nums,n-2));
    }
    public int func(int nums[], int i){
        if(i==0 || i==1){
            return nums[i];
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        return dp[i]=nums[i]+Math.min(func(nums,i-1),func(nums,i-2));
    }
}

/* DP TABLE */
class Solution {
    public int minCostClimbingStairs(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            if(i==0 || i==1){
                dp[i]=nums[i];
            }else{
                dp[i]=nums[i]+Math.min(dp[i-1],dp[i-2]);
            }
        }return Math.min(dp[n-1],dp[n-2]);
    }
}
