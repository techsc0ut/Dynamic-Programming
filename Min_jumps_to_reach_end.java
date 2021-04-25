import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}
class Solution{
    static int minJumps(int[] arr){
      int dp[]=new int[arr.length];
      for(int i=0;i<arr.length;i++){
          dp[i]=Integer.MAX_VALUE;
      }
      dp[0]=0;
      for(int j=1;j<arr.length;j++){
          for(int k=0;k<j;k++){
              if(dp[k]!=Integer.MAX_VALUE && arr[k]+k>=j){  // First Checking that , whether we have find the min jumps to reach kth position , 
                                                            // and then checking whether we are able to reach jth position from kth position or not , i.e maximum reachability.
                  if(dp[k]+1<dp[j]){
                      dp[j]=dp[k]+1;
                  }
              }
          }
      }
      if(dp[arr.length-1]!=Integer.MAX_VALUE){
          return dp[arr.length-1];
      }else{
          return -1;
      }
    }
}
