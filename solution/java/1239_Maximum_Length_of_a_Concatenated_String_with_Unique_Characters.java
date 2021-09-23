class Solution {
    public int maxLength(List<String> arr) {
      
      //10ms, 80%faster
      //O(2^n)
      
        List<Integer> dp=new ArrayList<>();
        dp.add(0);//***point
        int max=0;
        
        for(String s:arr){
            int mask=0;
            int dup=0;
            
            //check string contains duplicate char by itself
            for(char c:s.toCharArray()){
                dup|=mask&(1<<(c-'a'));//***point
                mask|=(1<<(c-'a'));
            }
            
            if(dup>0) continue;
            
            //check string contains duplicate char with previous
            //**point loop backword to avoid new added mask
            for(int i=dp.size()-1;i>=0;i--){
                if((dp.get(i)&mask)>0) continue;
                dp.add(dp.get(i)|mask);
                max=Math.max(max,Integer.bitCount(dp.get(i)|mask));
            }
        }
        return max;
    }
}
