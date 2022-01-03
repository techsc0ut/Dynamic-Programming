class Solution {
    public int jump(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[nums.length-1]=0;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]==0){
                dp[i]=0;
            }else{
                for(int a=1;a<=nums[i];a++){
                    if(i+a>=nums.length){
                        break;
                    }
                    if(dp[i+a]!=0){
                        dp[i]=Math.min(dp[i],dp[i+a]+1);    
                    }
                    if(i+a==nums.length-1){
                        dp[i]=1;
                    }
                }
                if(dp[i]==Integer.MAX_VALUE){
                    dp[i]=0;
                }
            }
        }
        return dp[0];
    }
}
