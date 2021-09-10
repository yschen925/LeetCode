class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        //330ms
      
        //int diff=num[j]-nums[i]
        //dp[j][diff]=dp[j][diff]+dp[i][diff]+1
        
        int n=nums.length;
        int res=0;
        HashMap<Integer,Integer>[] dp= new HashMap[n];
        // Arrays.fill(dp, new HashMap<Integer,Integer>());
        
        for(int i=0;i<n;i++){
            dp[i] = new HashMap<>();
            
            for(int j=0;j<i;j++){
                                
                //***point  there is no valid arithmetic subsequence slice that can have difference out of the Integer value range. But we do need a long integer to filter out those invalid cases.
                long LDiff = (long) nums[i]-nums[j];
                if(LDiff<=Integer.MIN_VALUE || LDiff>Integer.MAX_VALUE) continue;
                
                int diff=(int) LDiff;
                int ci=dp[i].getOrDefault(diff, 0);
                int cj=dp[j].getOrDefault(diff, 0);
                
                //***point if j_diff has value, it means j must contains at least two node previously.
                res+=cj;
                dp[i].put(diff,ci+cj+1);
            }
        }
        
        return res;
    }
}
