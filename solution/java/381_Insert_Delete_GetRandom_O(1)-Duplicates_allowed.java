class RandomizedCollection {

    private List<Integer> list;
    private HashMap<Integer,HashSet<Integer>> map;
    private Random random=new Random();
    
    public RandomizedCollection() {
        list=new ArrayList<>();
        map=new HashMap<>();
    }
    
    public boolean insert(int val) {
        list.add(val);
        if(!map.containsKey(val))
            map.put(val,new LinkedHashSet<>());
        map.get(val).add(list.size()-1);
        return map.get(val).size()==1;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val) || 
           map.get(val).size()==0) return false;
        
        //***point
        int rm_idx=map.get(val).iterator().next();
        //rm val of rm_idx in map
        map.get(val).remove(rm_idx);
        //move last item to rm_idx in list 
        int last=list.get(list.size()-1);
        list.set(rm_idx,last);
        map.get(last).add(rm_idx);
        map.get(last).remove(list.size()-1);
        list.remove(list.size()-1);
        return true;
    }
    
    public int getRandom() {
        //***point
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
