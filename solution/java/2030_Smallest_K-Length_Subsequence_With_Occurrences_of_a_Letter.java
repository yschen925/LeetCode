class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        //remain letter count in string s.
        int lRem=0;
        Stack<Character> st=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==letter)
                ++lRem;
        }
        
        
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            
            //pop stack if
            //1. stack NOT empty .
            //2. remain string + stack char cnt is longer than required length.
            //3. a. stack top char is NOT required letter. or.
            //   b. remain string contain enough required letter.
            while(!st.isEmpty() && 
                  c<st.peek() && 
                  s.length()-i+st.size()>k &&
                  (st.peek()!=letter || lRem>repetition)){
                if(st.pop()==letter)
                    ++repetition;
            }
            
            if(st.size()<k){
                //***point, if c==letter always add to stack
                if(c==letter){
                    st.push(c);
                    --repetition;
                }else if(st.size()+repetition<k){
                    st.push(c);
                }
            }
            
            if(c==letter)
                --lRem;
        }
        
        
        StringBuilder sb=new StringBuilder();
        for(Character c:st){
            sb.append(c);
        }
        return sb.toString();
    }
}
