class Solution {
    public int shortestPath(int[][] grid, int k) {
        //sol1. bfs
        //***
        //DFS with memoization will not work to find shortest path where from a node a path can span any direction including back to current parent (unlike tree). The memoization will save the result for the node for one particular path from current parent. But there may be shortest path from node back to parent. As leetcode testcases are not exhaustive, this solution is passing. 
        
        int[][] moves=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        
        int m=grid.length;
        int n=grid[0].length;
        int res=0;
        
        //***point
        boolean[][][] visited=new boolean[m][n][k+1];
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0,0});
        
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] cur=q.poll();
                int cur_i=cur[0];
                int cur_j=cur[1];
                int cur_k=cur[2];

                if(cur_i==m-1 && cur_j==n-1) return res;

                for(int[] move:moves){
                    int next_i=cur_i+move[0];
                    int next_j=cur_j+move[1];
                    int next_k=cur_k;

                    if(next_i>=0 && next_i<m && next_j>=0 && next_j<n){
                        if(grid[next_i][next_j]==1){
                            ++next_k;
                        }

                        if(next_k<=k && !visited[next_i][next_j][next_k]){
                            visited[next_i][next_j][next_k]=true;
                            q.offer(new int[]{next_i,next_j,next_k});
                        }
                    }
                }
            }
            ++res;
        }
        return -1;
    }
}
