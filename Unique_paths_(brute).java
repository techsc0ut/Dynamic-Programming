class Solution {
    public int uniquePaths(int m, int n) {
        return func(0,0,m,n);
    }
    static int func(int i,int j,int m,int n){
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(i>m-1 || j>n-1){
            return 0;
        }
        return func(i+1,j,m,n)+func(i,j+1,m,n);
    }
}
