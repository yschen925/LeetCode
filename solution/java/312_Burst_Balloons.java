class Solution {
    public int maxCoins(int[] nums) {
        //***point
        int n=nums.length;
        
        int[] coins=new int[n+2];
        coins[0]=1;
        coins[n+1]=1;
        for(int i=0;i<nums.length;i++){
            coins[i+1]=nums[i];
        }
        
        int[][]dp=new int[n+2][n+2];
        
        for(int len=1;len<=n;len++){
            for(int i=1;i<=n-len+1;i++){
                int j=i+len-1;
                
                for(int k=i;k<=j;k++){
                    //***point
                    dp[i][j]=Math.max(dp[i][j], dp[i][k-1]+(coins[i-1]*coins[k]*coins[j+1])+dp[k+1][j]);
                }
            }
        }
        
        return dp[1][n];
    }
}
