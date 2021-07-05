class Solution { 
    static int knapSack(int W, int wt[], int val[], int n){ 
        int i, w; 
        int K[][]=new int[n+1][W+1]; 
        K[0][0]=0;
        for(i=1;i<=n;i++){ 
            for(w=0;w<=W;w++){ 
                //if weight of current item is more than Knapsack capacity W
                //then this item cannot be included in the optimal solution.
                if(wt[i-1]<=w) {
                    K[i][w]=Math.max(val[i-1]+K[i-1][w-wt[i-1]],K[i-1][w]);    
                }
                //else updating K[i][w] as K[i-1][w].
                else{
                    K[i][w] = K[i-1][w];     
                }
             } 
        } 
        //returning the result.
        return K[n][W]; 
    } 
}
