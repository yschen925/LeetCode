class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        // //sol.top down, slow
        // Map<Integer, List<Integer>> graph = new HashMap<>();
        // int total = 0;
        // for (int i = 0; i < manager.length; i++) {
        //     int j = manager[i];
        //     if (!graph.containsKey(j))
        //         graph.put(j, new ArrayList<>());
        //     graph.get(j).add(i);
        // }
        // return topDown(graph, informTime, headID);
        
        
        //sol.bottom up
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,bottomUp(manager,informTime,i));
        }
        return max;
    }
    
    private int topDown(Map<Integer, List<Integer>> graph, int[] informTime, int cur) {
        int max = 0;
        if (!graph.containsKey(cur))
            return max;
        for (int i = 0; i < graph.get(cur).size(); i++)
            max = Math.max(max, topDown(graph, informTime, graph.get(cur).get(i)));
        return max + informTime[cur];
    }
    
    
    private int bottomUp(int[] manager, int[] informTime, int i){
        if(manager[i]!=-1){
            informTime[i]+=bottomUp(manager,informTime,manager[i]);
            manager[i]=-1;
        }
        return informTime[i];
    }
}
