class Solution {
    public int minTaps(int n, int[] ranges) {
        if (n <= 0 || ranges == null || ranges.length == 0){
            return 0;
        }
        int[] A = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            A[Math.max(0, i - ranges[i])] = i + ranges[i];
        }
        int answer = 0;
        int r = 0, nr = 0;
        for(int i = 0; i <=n; i++){
            if(i <= r){
                if (A[i] > nr){
                    nr = A[i];  
                } 
            }else{
                if(nr != r){
                    answer++;  
                } 
                if(nr >= n){
                    return answer;    
                } 
                r = nr;
                if (r < i){
                    return -1;    
                }
                else {
                    i--;
                }
            }
        }
        if(nr != r){
            answer++;    
        }
        if(nr < n) {
            return -1;
        }
        return answer;
    }
}
