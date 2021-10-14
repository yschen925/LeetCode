class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        //sol.prefix sum
        //a-b=n*k, a = running total, b = any previous subarray sum, 

        //== find (a+b)%k=n%k
        //== find b%k=a%k+n%k
        //== find b%k=a%k ,since (n%k==0)
        
        int[] cnt=new int[k];
        int prefix=0;
        int res=0;
        
        //***point
        //for subarray [], the sum is 0, so map[0] should initially be 1.
        cnt[0]=1;
        for(int num:nums){
            prefix=(prefix+(num%k)+k)%k;
            res+=cnt[prefix];
            cnt[prefix]++;
        }
        
        return res;
    }
}
