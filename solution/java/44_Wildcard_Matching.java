class Solution {
    public boolean isMatch(String s, String p) {
        int sLen=s.length();
        int pLen=p.length();
        boolean[][] dp=new boolean[sLen+1][pLen+1];
        
        dp[sLen][pLen]=true;
        for(int i=pLen-1;i>=0;i--){
            //pattern **** can mathch to string ''
            if(p.charAt(i)!='*')
                break;
            else
                dp[sLen][i]=true;
        }
        
        for(int i=sLen-1;i>=0;i--){
            for(int j=pLen-1;j>=0;j--){
                if(s.charAt(i)==p.charAt(j)||p.charAt(j)=='?')
                    dp[i][j]=dp[i+1][j+1];
                else if(p.charAt(j)=='*')
                    dp[i][j]=dp[i+1][j]||dp[i][j+1];
                else
                    dp[i][j]=false;
            }
        }
        
        return dp[0][0];
    }
}
