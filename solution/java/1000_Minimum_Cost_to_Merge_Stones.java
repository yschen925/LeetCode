class Solution {
    public int mergeStones(int[] stones, int k) {
        // 4ms, 40% faster
        // Time O(N^3/K) Space O(N^2)
      
        // dp[i][j] means the minimum cost needed to merge stones[i] ~ stones[j].
            
        int n=stones.length;
        //***point 
        if((n-1)%(k-1)>0) return -1;
        
        int[] prefix=new int[n+1];
        for(int i=0;i<n;i++)
            prefix[i+1]=prefix[i]+stones[i];
        
        int[][] dp=new int[n][n];
        //***point <=n
        for(int m=k;m<=n;m++){
            for(int i=0;i+m<=n;i++){
                int j=i+m-1;
                dp[i][j]=Integer.MAX_VALUE;
                
                //***point mid+=k-1
                // We can merge K piles into one pile,
                // we can't merge K + 1 piles into one pile.
                // We can merge K + K - 1 piles into on pile,
                // We can merge K + (K - 1) * steps piles into one pile.
                for(int mid=i;mid<j;mid+=k-1){
                    dp[i][j]=Math.min(dp[i][j], dp[i][mid]+dp[mid+1][j]);
                }
                
                //***point (j-i)%(k-1)==0, the last merge from i to j
                //cost = stone[i] + stone[i+1] +.... + stone[j] = prefix[j + 1] - prefix[i]
                if((j-i)%(k-1)==0)
                    dp[i][j]+=prefix[j+1]-prefix[i];
            }
        }
        return dp[0][n-1];
    }
}
