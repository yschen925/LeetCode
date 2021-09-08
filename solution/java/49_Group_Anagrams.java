class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //5ms 99% faster
      
        if (strs == null || strs.length == 0) return new ArrayList<>();
        
        HashMap<String, List<String>> map=new HashMap<>();
        
        for(String s:strs){
            
            // //sol.1 int array store cnt
            // int[] charCnt=new int[26];
            // for(char c:s.toCharArray()) charCnt[c-'a']+=1;
            // String sig=Arrays.toString(charCnt);
            
            //sol.2 char array store cnt
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            // //***point "String.valueOf" faster than "Arrays.toString"
            // String sig=Arrays.toString(ca);
            String sig=String.valueOf(ca);
            
            if(!map.containsKey(sig)) 
                map.put(sig, new ArrayList<String>());
            map.get(sig).add(s);
        }
        
        return new ArrayList<>(map.values());
        
    }
}
