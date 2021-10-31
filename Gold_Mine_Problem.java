class Solution{
    static int maxGold(int R, int C, int M[][]){
        if(R==1){
            int max=0;
            for(int i=0;i<C;i++){
                max+=M[0][i];
            }
            return max;
        }
        int mat[][]=new int[R][C];
        for(int col=C-1;col>=0;col--){
            for(int row=0;row<R;row++){
                if(col==C-1){
                    mat[row][col]=M[row][col];
                }else if(row==0){
                    mat[row][col]=M[row][col]+Math.max(mat[row][col+1],mat[row+1][col+1]);
                }else if(row==R-1){
                    mat[row][col]=M[row][col]+Math.max(mat[row][col+1],mat[row-1][col+1]);
                }else{
                    mat[row][col]=M[row][col]+Math.max(mat[row][col+1],
                    Math.max(mat[row-1][col+1],mat[row+1][col+1]));
                }
            }
        }
        int max=mat[0][0];
        for(int i=0;i<R;i++){
            if(max<mat[i][0]){
                max=mat[i][0];
            }
        }
        return max;
    }
}
