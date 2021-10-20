class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        
        //sol. sliding windows
        int n=s.length();
        int[] cost=new int[n];
        
        for(int i=0;i<n;i++){
            cost[i]=Math.abs(s.charAt(i)-t.charAt(i));
        }
        
        int i=0, j;
        for(j=0;j<n;++j){
            maxCost-=cost[j];
            if(maxCost<0){
                maxCost+=cost[i];
                ++i;
            }
        }
        return j-i;
    }
}
