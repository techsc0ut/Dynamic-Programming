class Solution{
    static int dp[];
    public int maximizeCuts(int n,int x,int y,int z){
       dp=new int[n+1];
       Arrays.fill(dp,-1);
       int res=func(n,x,y,z);
       if(res<0) return 0;
       return res;
    }
    static int func(int len,int x,int y,int z){
        if(len==0){
            return 0;
        }else if(dp[len]!=-1){
            return dp[len];
        }else{
            int op1=Integer.MIN_VALUE,op2=Integer.MIN_VALUE,op3=Integer.MIN_VALUE;
            if(len>=x){
                op1=func(len-x,x,y,z);
            }
            if(len>=y){
                op2=func(len-y,x,y,z);
            }
            if(len>=z){
                op3=func(len-z,x,y,z);
            }
            return dp[len]=1+Math.max(op1,Math.max(op2,op3));
        }
    }
}
