class Solution {
    public int longestStrChain(String[] words) {
        int res=1;
        HashMap<String,Integer> H=new HashMap<>();
        Arrays.sort(words,(a,b)->(a.length()-b.length()));
        for(String s:words){
            H.put(s,1);
            for(int i=0;i<s.length();i++){
                String temp=s.substring(0,i)+s.substring(i+1);
                int max=Math.max(H.getOrDefault(temp,0)+1,H.get(s));
                H.put(s,max);
                if(res<max){
                    res=max;
                }
            }
        }return res;
    }
}
