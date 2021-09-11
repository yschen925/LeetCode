class Solution {
    public String removeKdigits(String num, int k) {
        //two pass
        //l to r rm if decresing
        //r to l rm if decresing
        
        if(k>=num.length()) return "0";
        
        Deque<Character> deque = new ArrayDeque<>();
        for(char c: num.toCharArray()){

            while(k>0 && !deque.isEmpty() && deque.peekLast()>c){
                deque.removeLast();
                k--;
            }
            deque.addLast(c);
        }
        
        while(k>0) {
            deque.removeLast();
            k--;
        }
        
        //rm front 0
        while(!deque.isEmpty() && deque.peekFirst()== '0') 
            deque.removeFirst();
     
        if(deque.isEmpty()) return "0";

        // build number from deque
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }
        return sb.toString();
    }
}
