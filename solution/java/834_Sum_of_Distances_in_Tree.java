class Solution {
    int[] dist, count;
    ArrayList<HashSet<Integer>> tree;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        tree = new ArrayList<HashSet<Integer>>();
        dist = new int[N];
        count = new int[N];
        for (int i = 0; i < N ; ++i)
            tree.add(new HashSet<Integer>());
        
        //build adjacency list
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        
        //node 0 is root
        //cal dist of node 0, and cal subtree of all node
        dfs(0, -1);
        
        //for all other node, 
        //dist[cur] = dist[parent]-subtree[cur]+(n-subtree[cur]);
        //node dist before (parent) +1;
        //node dist after and include (cur) -1;
        dfs2(0, -1);
        return dist;
    }

    public void dfs(int cur, int pre) {
        for (int next : tree.get(cur)) {
            if (next == pre) continue;
            dfs(next, cur);
            count[cur] += count[next];
            dist[cur] += dist[next] + count[next];
        }
        count[cur]++;
    }


    public void dfs2(int cur, int pre) {
        for (int next : tree.get(cur)) {
            if (next == pre) continue;
            dist[next] = dist[cur]-count[next]+(count.length-count[next]);
            dfs2(next, cur);
        }
    }
}
