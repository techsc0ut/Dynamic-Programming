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
