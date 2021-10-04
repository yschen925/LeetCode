class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
            
//         //sol.two pointer + sliding windows TLE
//         //set 2 as reachable
//         int m=s.length();
//         char[] arr=s.toCharArray();
        
//         arr[0]='2';
//         int j=0;//**point reduce time
//         for(int i=0;i<m;i++){
//             if(arr[i]=='2'){
//                 for(j=Math.max(j,i+minJump);j<=Math.min(m-1,i+maxJump);j++){
//                     if(arr[j]=='0') arr[j]='2';
//                 }
//             }
//         }
        
//         return (arr[m-1]=='2');
        
        
        //sol dp+sliding windows
        int n = s.length(), pre = 0;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; ++i) {
            if (i >= minJump && dp[i - minJump])
                pre++;
            if (i > maxJump && dp[i - maxJump - 1])
                pre--;
            dp[i] = pre > 0 && s.charAt(i) == '0';
        }
        return dp[n - 1];
        
        
//         //sol.dp TLE
//         int m=s.length();
//         int n=maxJump-minJump+1;
        
//         boolean[] dp=new boolean[m];
//         dp[0]=true;
        
//         for(int i=1;i<m;i++){
//             if(s.charAt(i)=='0'){
//                 for(int j=0;j<n;j++){
//                 // for(int j=n-1;j>=0;j--){
//                     int pre=i-(minJump+j);
//                     if(pre>=0 && dp[pre]==true){
//                         dp[i]=true;
//                         break;
//                     }
//                 }
//             }
//         }
        
//         return dp[m-1];
        
//         //sol.dp
//         int m=s.length();
//         int n=maxJump-minJump+1;
        
//         boolean[] dp=new boolean[m];
//         dp[0]=true;
        
//         if(s.charAt(m-1)=='1') return false;
        
//         for(int i=1;i<m;i++){
//             if(s.charAt(i)=='0'){
//                 // for(int j=0;j<n;j++){
//                 for(int j=n-1;j>=0;j--){
//                     int pre=i-(minJump+j);
//                     if(pre>=0 && dp[pre]==true){
//                         dp[i]=true;
//                         break;
//                     }
//                 }
//             }
//         }
        
//         return dp[m-1];
    }
}
