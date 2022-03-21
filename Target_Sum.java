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
	/* Problem reduced to s1-s2=target =>(Eq-1) [because if we seperate +elements and -elements, then we can say
		s1=(+a,+b,+c) and s2=(-c,-d,-e) and now problem reduced to s1-s2=target]
		but again we know that s1+s2=arraySum =>(Eq-2)
			=> adding equation 1 and 2
			=> s1=(target+arraySum)/2
		so finally problem gets reduced to finding count of subsets with given sum i.e s1 in our case*/
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
