class Solution{
    static int dp[][];
    static int palindromicPartition(String str){
        dp=new int[str.length()][str.length()];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return func(str,0,str.length()-1);
    }
    static boolean IsPal(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }
    static int func(String S, int i,int j){
        if(i>=j){
            return 0;
        }else if(IsPal(S,i,j)){
            return dp[i][j]=0;
        }else if(dp[i][j]!=-1){
            return dp[i][j];
        }
        else{
            int ans=Integer.MAX_VALUE;
            for(int k=i;k<=j-1;k++){
                int left=-1, right=-1;
                if(dp[i][k]!=-1){
                    left=dp[i][k];
                }else{
                    left=func(S,i,k);
                }
                if(dp[k+1][j]!=-1){
                    right=dp[k+1][j];
                }else{
                    right=func(S,k+1,j);
                }
                int temp=left+right+1;
                if(ans>temp){
                    ans=temp;
                }
            }
            return dp[i][j]=ans;
        }
    }
}
