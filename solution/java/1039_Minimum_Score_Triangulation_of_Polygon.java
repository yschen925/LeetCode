class Solution {
    public int minScoreTriangulation(int[] values) {
        int n=values.length;
        int[][] dp=new int[n][n];
        
        for(int len=3;len<=n;len++){
            for(int i=0;i<n-len+1;i++){
                int j=i+len-1;
                dp[i][j]=Integer.MAX_VALUE;
                
                for(int k=i+1;k<j;k++){
                    dp[i][j]=Math.min(dp[i][k]+values[i]*values[k]*values[j]+dp[k][j], dp[i][j]);
                }
            }
        }
        
        return dp[0][n-1];
    }
}
