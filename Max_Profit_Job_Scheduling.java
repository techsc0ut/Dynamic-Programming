import java.util.*;
class Solution{
    public int jobScheduling(int[] s, int[] e, int[] p) {
        int n=s.length;
        if(n==1){
            return p[0];
        }
        int DP[]=new int[n];
        Job jobs[]=new Job[n];
        for(int i=0;i<n;i++){
            jobs[i]=new Job(s[i],e[i],p[i]);
        }
        Arrays.sort(jobs);
        DP[0]=jobs[0].profit;
        for(int i=1;i<n;i++){
            int incl=jobs[i].profit;
            int ind=bSearch(jobs,i);
            if(ind!=-1){
                incl+=DP[ind];
            }
            DP[i]=Math.max(incl,DP[i-1]);
        }
        return DP[n-1];
    }
    static int bSearch(Job[] jobs,int i){
        int start=0,end=i-1;
        int ans=-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(jobs[mid].end<=jobs[i].start){
                ans=mid;
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return ans;
    }
}
class Job implements Comparable<Job>{
    int start;
    int end;
    int profit;
    Job(){}
    Job(int s,int e,int p){
        this.start=s;
        this.end=e;
        this.profit=p;
    }
    public int compareTo(Job J){
        return this.end-J.end;
    }
}
