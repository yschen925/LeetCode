class Solution {
    public int[] singleNumber(int[] nums) {
        
        
        int aXORb=0;
        for(int n:nums)
            aXORb^=n;
        
        //***point
        //diff &= -diff or diff &= ~(diff-1), aka 2'complement of diff
        //gives right-most diff bit between A & B
        int mask=aXORb&-aXORb;
        
        int[] res=new int[2];
        for(int n:nums){
            //sepetate all num w/ and w/o right-most diff bit
            //since all nums appear twice except A & B
            //only A & B left over in the end.
            if((n&mask)==0){
                //XOR all w/o A's right-most diff bit, including B.
                res[0]^=n;
            }else{
                //XOR all w/ A's right-most diff bit, including A.
                res[1]^=n;
            }
        }
        
        return res;
    }
}
