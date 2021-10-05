class Solution {
    public int maxJumps(int[] arr, int d) {
        int n=arr.length;
        int res=1;
        int[] dp=new int[n];
        
        for(int i=0;i<n;i++)
            res=Math.max(res,dfs(arr,d,dp,i));
            
        return res;
    }
    
    private int dfs(int[] arr, int d, int[] dp, int i){
        if(dp[i]!=0) return dp[i];
        
        int res=1;
        
        for(int j=i+1;j<=Math.min(i+d,arr.length-1)&&arr[j]<arr[i];j++)
            res=Math.max(res,1+dfs(arr,d,dp,j));
        
        for(int j=i-1;j>=Math.max(i-d,0)&&arr[j]<arr[i];j--)
            res=Math.max(res,1+dfs(arr,d,dp,j));
        
        
        return dp[i]=res;
    }
}
