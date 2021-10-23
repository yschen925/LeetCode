class MyCalendar {

        
    // //sol1.
    // private List<int[]> books = new ArrayList<>();
    //sol2.
    private TreeSet<int[]> books = new TreeSet<int[]>((int[] a, int[] b) -> a[0] - b[0]);
    // //sol2.5
    //  TreeMap<Integer, Integer> books = new TreeMap<>();
    
    public MyCalendar() {
        // //sol1
        // books = new ArrayList<>();
        //sol2
        books = new TreeSet<int[]>((int[] a, int[] b) -> a[0] - b[0]);
        // //sol2.5
        // books = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        // //sol1. naive compare all exist pair, slow.
        // for(int[] b :books){
        //     //check if interval overmap
        //     if(Math.max(b[0],start) < Math.min(b[1],end)) return false;
        // }
        // books.add(new int[]{start,end});
        // return true;
        
        
        //sol2. TreeSet to keep exist pair sorted, fasest
        int[] book = new int[] { start, end };
        int[] floor = books.floor(book);
        int[] ceiling = books.ceiling(book);
        
        if (floor != null && start < floor[1]) 
            return false; // (s, e) start within floor
        if (ceiling != null && ceiling[0] < end) 
            return false; // ceiling start within (s, e)
        
        books.add(book);
        return true;
        
        
//         //sol2.5 TreeMap to keep exist pair sorted
//         java.util.Map.Entry<Integer, Integer> floor = books.floorEntry(start);
//         java.util.Map.Entry<Integer, Integer> ceiling = books.ceilingEntry(start);
        
//         if (floor!=null && start<floor.getValue()) 
//             return false; // (s, e) start within floor
//         if (ceiling!=null && ceiling.getKey()<end) 
//             return false; // ceiling start within (s, e)
        
//         books.put(start, end);
//         return true;
    }

}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
