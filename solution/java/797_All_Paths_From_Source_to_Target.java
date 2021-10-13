class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        //sol.dfs
        //Its an "Acyclic" graph, so there is no way you can go around in circles.
        //no need to check seen
        
        int n=graph.length;
        LinkedList<Integer> list=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();

        list.add(0);
        dfs(graph,res,list,0,n);
        
        return res;
    }
    
    private void dfs(int[][] graph, List<List<Integer>> res, LinkedList<Integer> list, int cur, int n){
        
        if(cur==n-1){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int next:graph[cur]){

            list.add(next);            
            dfs(graph,res,list,next,n);
            list.removeLast();
        }
        
        return;
    }
}
