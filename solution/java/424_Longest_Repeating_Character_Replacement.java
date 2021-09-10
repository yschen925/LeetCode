class Solution {
    public int characterReplacement(String s, int k) {
        
        //6~18ms
      
        //If replaceCount is bigger than k, we got an invalid window,
        //we should skip it until window is valid again, 
        //but only expands window size, never shrink 
        //(because even if we got a smaller window thats valid, 
        //it doesn't matter because we already found a window thats bigger and valid)
        
        
        int maxlen=0;
        int curCnt=0;
        int[] rpt = new int[26];
        
        int start=0;
        for(int end=0;end<s.length();end++){
            rpt[s.charAt(end)-'A']++;
            //***point 
            curCnt=Math.max(curCnt, rpt[s.charAt(end)-'A']);
            
            if(end-start+1-curCnt>k){
                rpt[s.charAt(start)-'A']--;
                start++;   
            }
            
            maxlen=Math.max(maxlen, end-start+1);
        }
        
        return maxlen;
    }
}
