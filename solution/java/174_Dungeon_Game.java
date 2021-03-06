class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length;
        int n=dungeon[0].length;
        //***point hp needed
        int[][] dp=new int[m][n];
        
        //***point backward dp[m-1][n-1] must at least hp=1
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1){
                    dp[i][j]=Math.max(1-dungeon[i][j], 1);
                }else if(i==m-1){
                    dp[i][j]=Math.max(dp[i][j+1]-dungeon[i][j], 1);
                }else if(j==n-1){
                    dp[i][j]=Math.max(dp[i+1][j]-dungeon[i][j], 1);
                }else{
                    int pre=Math.min(dp[i+1][j], dp[i][j+1]);
                    dp[i][j]=Math.max(pre-dungeon[i][j], 1);
                }
            }
        }
        
        return dp[0][0];
    }
}
