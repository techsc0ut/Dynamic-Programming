class Solution {
    public int rob(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return nums[0]>nums[1]?nums[0]:nums[1];
        }
        int inc=0, exc=0;
        for(int i=0;i<nums.length;i++){
            int ni=exc+nums[i];
            int ne=Math.max(inc,exc);
            inc=ni;
            exc=ne;
        }return inc>exc?inc:exc;
    }
}
