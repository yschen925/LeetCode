class RandomizedSet {

    private HashMap<Integer,Integer> valToIdx=new HashMap<>();
    private List<Integer> list=new ArrayList<>();
    private Random random=new Random();
    
    public RandomizedSet() {
        valToIdx=new HashMap<>();
        list=new ArrayList<>();
        // random=new Random();
    }
    
    public boolean insert(int val) {
        if(valToIdx.containsKey(val)) return false;
        else{
            list.add(val);
            valToIdx.put(val,list.size()-1);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(!valToIdx.containsKey(val)) return false;
        else{
            //remove val
            int idx=valToIdx.get(val);
            valToIdx.remove(val);
            
            //update last item to val idx
            if(idx<list.size()-1){
                int last=list.get(list.size()-1);
                list.set(idx,last);
                valToIdx.put(last,idx);
            }
            list.remove(list.size()-1);
            
            return true;
        }
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
