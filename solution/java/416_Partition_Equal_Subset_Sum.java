class Solution {
    public boolean canPartition(int[] nums) {
        //66ms, 58% faster
      
        int sum=0;
        int n=nums.length;
        
        
        for(int num: nums){
            sum+=num;
        }
        if(sum%2==1) return false;
        
        
        //init
        sum/=2;
        boolean[][] dp = new boolean[n+1][sum+1];
        //always 0, with set=0;
        for(int i=0;i<n+1;i++) dp[i][0]=true;
        for(int s=1;s<sum+1;s++) dp[0][s]=false;
        
        // // with only one number, we can form a subset only when the required sum is equal to its value
        // int target = sum / 2;
        // if(nums[0] <= target) dp[0][nums[0]] = true;
        
        
        //dp
        for(int i=1;i<n+1;i++){
            for(int s=1;s<sum+1;s++){
                dp[i][s] = dp[i-1][s];
                if(s>=nums[i-1]){
                    dp[i][s] = dp[i][s]||dp[i-1][s-nums[i-1]]; 
                }
            }
        }
        
        return dp[n][sum];
    }
}
