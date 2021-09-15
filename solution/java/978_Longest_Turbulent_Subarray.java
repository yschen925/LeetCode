class Solution {
    public int maxTurbulenceSize(int[] arr) {
        //dp
        int res=1;
        int[] dp=new int[2];
        dp[0]=1;
        dp[1]=1;
        
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                dp[(0+i)%2]=1;
                dp[(1+i)%2]+=1;
                res=Math.max(res, dp[(1+i)%2]);
            }else if(arr[i]<arr[i-1]){
                dp[(0+i)%2]+=1;
                dp[(1+i)%2]=1;
                res=Math.max(res, dp[(0+i)%2]);
            }else{
                dp[0]=1;
                dp[1]=1;
            }
            // res=Math.max(res, Math.max(dp[0],dp[1]));
        }
        return res;
    }
}
