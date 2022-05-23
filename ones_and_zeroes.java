/* Recursive Approach */

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        return func(0,m,n,strs);
    }
    public int func(int index, int m, int n, String strs[]){
        if(index==strs.length || m+n==0){
            return 0;
        }
        // Consider case
        int cnt[]=count(strs[index]);
        int consider=0;
        if(m>=cnt[0] && n>=cnt[1]){
            consider=1+func(index+1,m-cnt[0],n-cnt[1],strs);
        }
        // Not Consider case
        int notConsider=func(index+1,m,n,strs);
        return Math.max(consider,notConsider);
    }
    public int[] count(String s){
        int a=0, b=0;
        for(char c:s.toCharArray()){
            if(c=='0'){
                a++;
            }else{
                b++;
            }
        }
        return new int[]{a,b};
    }
}

//_____________________________________________________________________________________//


/* Memoized Solution */

class Solution {
    int dp[][][];
    public int findMaxForm(String[] strs, int m, int n) {
        dp=new int[strs.length][m+1][n+1];
        return func(0,m,n,strs);
    }
    public int func(int index, int m, int n, String strs[]){
        if(index==strs.length || m+n==0){
            return 0;
        }
        if(dp[index][m][n]>0){
            return dp[index][m][n];
        }
        // Consider case
        int cnt[]=count(strs[index]);
        int consider=0;
        if(m>=cnt[0] && n>=cnt[1]){
            consider=1+func(index+1,m-cnt[0],n-cnt[1],strs);
        }
        // Not Consider case
        int notConsider=func(index+1,m,n,strs);
        return dp[index][m][n]=Math.max(consider,notConsider);
    }
    public int[] count(String s){
        int a=0, b=0;
        for(char c:s.toCharArray()){
            if(c=='0'){
                a++;
            }else{
                b++;
            }
        }
        return new int[]{a,b};
    }
}
