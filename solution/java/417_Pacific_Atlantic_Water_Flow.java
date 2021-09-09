class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
//         //BFS, 30ms, 14.9% faster
//         int n=heights.length;
//         int m=heights[0].length;
        
//         boolean[][] toPac=new boolean[n][m];
//         boolean[][] toAtl=new boolean[n][m];
//         Queue<int[]> qPac=new LinkedList<>();
//         Queue<int[]> qAtl=new LinkedList<>();
        
//         //init
//         for(int i=0;i<n;i++){
//             toPac[i][0]=true;
//             toAtl[i][m-1]=true;
            
//             qPac.add(new int[]{i,0});
//             qAtl.add(new int[]{i,m-1});
//         }
        
//         for(int j=0;j<m;j++){
//             toPac[0][j]=true;
//             toAtl[n-1][j]=true;
            
//             qPac.add(new int[]{0,j});
//             qAtl.add(new int[]{n-1,j});
//         }
        
//         bfs(heights, toPac, qPac);
//         bfs(heights, toAtl, qAtl);
        
//         List<List<Integer>> res=new ArrayList<>();
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(toPac[i][j] && toAtl[i][j]){
//                     List<Integer> list=new ArrayList<>();
//                     list.add(i);
//                     list.add(j);
//                     res.add(list);
//                 }
//             }
//         }
//         return res;
        
        
        
        //DFS, 4ms, 80.5% faster//9ms 39.3 faster
        int n=heights.length;
        int m=heights[0].length;
        
        boolean[][] toPac=new boolean[n][m];
        boolean[][] toAtl=new boolean[n][m];
        
        //init
        for(int i=0;i<n;i++){
            dfs(heights, toPac, i, 0);
            dfs(heights, toAtl, i, m-1);
        }
        
        for(int j=0;j<m;j++){            
            dfs(heights, toPac, 0, j);
            dfs(heights, toAtl, n-1, j);
        }
        
        
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(toPac[i][j] && toAtl[i][j]){
                    List<Integer> list=new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }
        return res;
    }
    
    private int[][] moves=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    
    //sol1.BFS
    private void bfs(int[][] heights, boolean[][] toMap, Queue<int[]> queue){
        int n=heights.length;
        int m=heights[0].length;
        
        while(!queue.isEmpty()){
            int[] cur=queue.poll();
            int x=cur[0];
            int y=cur[1];
            
            toMap[x][y]=true;
            
            for(int[] move:moves){
                int nx=x+move[0];
                int ny=y+move[1];
                
                if(nx>=0 && nx<n && ny>=0 && ny<m && !toMap[nx][ny] && heights[x][y]<=heights[nx][ny]){
                    queue.add(new int[]{nx,ny});
                }
            }
            
        }
    }
    
    //sol2.DFS
    private void dfs(int[][] heights, boolean[][] toMap, int x, int y){
        int n=heights.length;
        int m=heights[0].length;
        
        toMap[x][y]=true;
        
        for(int[] move:moves){
            int nx=x+move[0];
            int ny=y+move[1];
                
            if(nx>=0 && nx<n && ny>=0 && ny<m && !toMap[nx][ny] && heights[x][y]<=heights[nx][ny]){
                dfs(heights, toMap, nx, ny);
            }
        }
    }
}
