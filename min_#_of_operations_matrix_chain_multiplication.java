/* Top Down (Memoized) */
class Solution{
    static int dp[][];
    static int matrixMultiplication(int N, int arr[]){
        dp=new int[N+1][N+1];
        for(int x[]:dp){
            Arrays.fill(x,-1);
        }
        return func(arr,1,arr.length-1);
    }
    static int func(int arr[], int i, int j){
        if(i>=j){
            return dp[i][j]=0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp=func(arr,i,k)+func(arr,k+1,j);
            temp+=(arr[i-1]*arr[k]*arr[j]);
            min=min>temp?temp:min;
        }
        return dp[i][j]=min;
    }
}

/* Bottom Up */
import java.util.ArrayList;
public class Solution{
    public static int minMultiplicationOperations(ArrayList<Integer> arr){
    	int dp[][]=new int[arr.size()-1][arr.size()-1];
        for(int gap=0;gap<dp.length;gap++){
            for(int i=0,j=gap;j<dp.length;i++,j++){
                if(gap==0){
                    dp[i][j]=0;
                }else if(gap==1){
                    dp[i][j]=arr.get(i)*arr.get(j)*arr.get(j+1);
                }else{
                    int min=Integer.MAX_VALUE;
                    for(int k=i;k<j;k++){
                        int lp=dp[i][k];
                        int rp=dp[k+1][j];
                        int mp=arr.get(i)*arr.get(k+1)*arr.get(j+1);
                        int to=lp+rp+mp;
                        if(min>to){
                            min=to;
                        }
                    }
                    dp[i][j]=min;
                }
            }
        }
        return dp[0][dp[0].length-1];
    }
}
