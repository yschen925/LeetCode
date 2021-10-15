class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        //start w/ top glass contain all wine
        double[] dp=new double[query_row+2];
        
        dp[0]=poured;
        //per row
        for(int i=1;i<=query_row;i++){
            for(int j=query_row;j>=0;j--){
                double half=Math.max((dp[j]-1)/2, 0.0);
                dp[j+1]+=half;
                dp[j]=half;
            }
        }
        
        return Math.min(dp[query_glass],1.0);
    }
}
