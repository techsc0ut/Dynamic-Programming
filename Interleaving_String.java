class Solution {
    HashMap<String,Boolean> H;
    int n1, n2, n3;
    public boolean isInterleave(String s1, String s2, String s3) {
        n1=s1.length();
        n2=s2.length();
        n3=s3.length();
        if(n1+n2!=n3){
            return false;
        }
        H=new HashMap<>();
        return func(s1,s2,s3,0,0,0);
    }
    public boolean func(String s1, String s2, String s3, int p1, int p2, int p3){
        if(p3==n3){
            if(p1==n1 && p2==n2){
                return true;
            }return false;
        }
        String key=p1+"*"+p2+"*"+p3;
        if(H.get(key)!=null){
            return H.get(key);
        }
        if(p1==n1){
            boolean x;
            if(s2.charAt(p2)==s3.charAt(p3)){
                x=func(s1,s2,s3,p1,p2+1,p3+1);
            }else{
                x=false;
            }
            H.put(key,x);
            return x;
        }
        if(p2==n2){
            boolean x;
            if(s1.charAt(p1)==s3.charAt(p3)){
                x=func(s1,s2,s3,p1+1,p2,p3+1);
            }else{
                x=false;
            }
            H.put(key,x);
            return x;
        }
        boolean x1=false, x2=false;
        if(s1.charAt(p1)==s3.charAt(p3)){
            x1=func(s1,s2,s3,p1+1,p2,p3+1);
        }
        if(s2.charAt(p2)==s3.charAt(p3)){
            x2=func(s1,s2,s3,p1,p2+1,p3+1);
        }
        boolean res=(x1 || x2);
        H.put(key,res);
        return res;
    }
}
