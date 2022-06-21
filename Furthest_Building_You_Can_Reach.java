class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        return func(0,bricks,ladders,heights);
    }
    public int func(int i, int bricks, int ladders, int[] heights){
        if(i==heights.length-1){
            return i;
        }
        else if(heights[i+1]<=heights[i]){
            return func(i+1,bricks,ladders,heights);
        }else{
            int brUse=i;
            int brReq=heights[i+1]-heights[i];
            if(brReq<=bricks){
                brUse=func(i+1,bricks-brReq,ladders,heights);
            }
            int ladUse=i;
            if(ladders!=0){
                ladUse=func(i+1,bricks,ladders-1,heights);
            }
            if(brUse==i && ladUse==i){
                return i;
            }else if(brUse!=i && ladUse!=i){
                return brUse>ladUse?brUse:ladUse;
            }else if(brUse==i){
                return ladUse;
            }return brUse;
        }
    }
}
