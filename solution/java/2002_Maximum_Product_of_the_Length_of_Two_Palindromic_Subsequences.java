class Solution {
    public int maxProduct(String s) {
        //2^n possible palindromes,
        int size=(int) Math.pow(2,12);
        int[] dp=new int[size];
        int mask=(1<<s.length())-1;
        
        //m: 1bits==current select char, 
        //foreach possible select, check if palindromic 
        for(int m=1;m<=mask;m++){
            dp[m]=getPalSize(s,m);
        }
        
        //find two select that does not conatins same char
        int res=0;
        for(int m=1;m<=mask;m++){
            if(dp[m]!=0){
                for(int n=1;n<=mask;n++){
                    if((m&n)==0){
                        res=Math.max(res,dp[m]*dp[n]);
                    }
                }
            }
        }
        return res;
    }
    
    private int getPalSize(String s, int mask){
        int i=0,j=s.length()-1, len=0;
        while(i<=j){
            if(((1<<i)&mask)==0){
                i++;
            }else if(((1<<j)&mask)==0){
                j--;
            }else if(s.charAt(i)!=s.charAt(j)){
                return 0;
            }else{
                len=(i==j)?len+1:len+2;
                i++;
                j--;
            }
        }
        return len;
    }
}
