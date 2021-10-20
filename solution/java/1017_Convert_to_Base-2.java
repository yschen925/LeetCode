class Solution {
    public String baseNeg2(int n) {
        StringBuilder sb=new StringBuilder();
        while(n!=0){
            //***point use n&1 instead of n%2
            //   use n%2 will casue string contains '-' signal;
            sb.append(n&1);
            n=-(n>>1);
        }
        return sb.length()==0 ? "0" : sb.reverse().toString();
    }
}
