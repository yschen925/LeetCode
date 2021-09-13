class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {

        HashMap<Integer,Integer> seen=new HashMap<>();
        HashMap<Integer,HashMap<Integer,Integer>> adjmap= new HashMap<>();
        for(int i=0;i<n;i++)
            adjmap.put(i,new HashMap<>());
        
        for(int[] edge:edges){
            adjmap.get(edge[0]).put(edge[1],edge[2]);
            adjmap.get(edge[1]).put(edge[0],edge[2]);
        }
        
        PriorityQueue<int[]> minheap=new PriorityQueue<>((a,b)->b[1]-a[1]);
        minheap.offer(new int[]{0,maxMoves});
        
        while(!minheap.isEmpty()){
            int[] cur=minheap.poll();
            int from=cur[0];
            int move=cur[1];
            
            if(!seen.containsKey(from)){
                seen.put(from,move);
                
                for(Map.Entry<Integer,Integer> set: adjmap.get(from).entrySet()){
                    int dist=set.getKey();
                    int range=set.getValue();
                    int nextMove=move-range-1;

                    if(!seen.containsKey(dist) && nextMove>=0){
                        minheap.offer(new int[]{dist,nextMove});
                    }
                }
            }
        }
        
        int res=seen.size();
        for(int[] edge:edges){
            int v1=seen.getOrDefault(edge[0],0);
            int v2=seen.getOrDefault(edge[1],0);
            
            res+=Math.min(v1+v2,edge[2]);
        }
        return res;
    }
}
