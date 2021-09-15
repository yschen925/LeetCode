class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int h=wall.size();
        HashMap<Integer,Integer> map=new HashMap<>();
        
        int count=0;
        for(List<Integer> list: wall){
            int width=0;
            for(int i=0;i<list.size()-1;i++){
                width+=list.get(i);
                map.put(width, map.getOrDefault(width,0)+1);
                count = Math.max(count, map.get(width));
            }
        }

        return h-count;
    }
}
