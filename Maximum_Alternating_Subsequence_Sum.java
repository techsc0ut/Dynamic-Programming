/* Recursive Memoized Solution */
class Solution {
    static long dp[][];
    public long maxAlternatingSum(int[] nums) {
        dp=new long[nums.length+1][2];
        for(long x[]:dp){
            Arrays.fill(x,-1);
        }return func(0,0,nums);
    }
    static long func(int i, int j, int nums[]){
        if(i==nums.length){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int total=(j==0)?nums[i]:(-1*nums[i]);
        dp[i][j]=Math.max(total+func(i+1,j^1,nums),func(i+1,j,nums));
        return dp[i][j];
    }
}
