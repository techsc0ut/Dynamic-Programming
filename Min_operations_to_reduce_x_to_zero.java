class Solution {
    HashMap<String,Integer> H;
    public int minOperations(int[] nums, int x) {
        if(x==0){
            return 0;
        }
        if(nums.length==1){
            if(nums[0]==x){
                return 1;
            }return -1;
        }
        if(nums[0]>x && nums[nums.length-1]>x){
            return -1;
        }
        H=new HashMap<>();
        int ans=func(x,0,nums.length-1,nums,0);
        return ans>=Integer.MAX_VALUE?-1:ans;
    }
    public int func(int x, int i, int j, int nums[],int count){
        if(x==0){
            return count; 
        }
        if(x<0 || i>j){
            return Integer.MAX_VALUE;
        }
        String key=i+"*"+j+"*"+x;
        if(H.get(key)!=null){
            return H.get(key);
        }
        int l=Integer.MAX_VALUE, r=Integer.MAX_VALUE;
        l=func(x-nums[i],i+1,j,nums,count+1);
        r=func(x-nums[j],i,j-1,nums,count+1);
        int ans=Math.min(l,r);
        H.put(key,ans);
        return ans;
    }
}
