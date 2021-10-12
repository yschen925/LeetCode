class Solution {
    public String removeDuplicateLetters(String s) {
        
        boolean[] seen=new boolean[26];
        int[] lastIdx=new int[26];
        for(int i=0;i<s.length();i++){
            lastIdx[s.charAt(i)-'a']=i;
        }
        
        Stack<Integer> st=new Stack();
        for(int i=0;i<s.length();i++){
            int c=s.charAt(i)-'a';
            if(seen[c]) continue;
            
            while(!st.isEmpty() && st.peek()>c && lastIdx[st.peek()]>i){
                seen[st.pop()]=false;
            }
            st.push(c);
            seen[c]=true;
        }
        
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.insert(0,(char)(st.pop()+'a'));
        }
        return sb.toString();
    }
}
