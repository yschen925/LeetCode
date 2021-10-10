class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int m=board.length;
        int n=board[0].length;
        boolean[][] seen=new boolean[m][n];
        // HashSet<String> map=new HashSet<>(Arrays.asList(words));
        Node root=new Node();
        
        for(String word:words){
            Node node=root;
            for(char c:word.toCharArray()){
                if(node.children[c-'a']==null)
                    node.children[c-'a']=new Node();
                node=node.children[c-'a'];
            }
            node.isWord=true;
            node.word=word;
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int idx=board[i][j]-'a';
                if(root.children[idx]!=null)
                    dfs(board,seen,root.children[idx],m,n,i,j);
            }
        }
        
        return res;
    }
    
    class Node{
        Node[] children=new Node[26];
        boolean isWord;
        String word;
    }
    
    private List<String> res=new ArrayList<String>();
    private int[][] moves=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    
    private void dfs(char[][] board, boolean[][] seen, Node node, int m, int n, int x, int y){
        
        if(node.isWord){
            res.add(node.word);
            node.isWord=false;
            node.word="";
        }
        
        seen[x][y]=true;
        for(int[] move:moves){
            int next_x=x+move[0];
            int next_y=y+move[1];
            if(next_x>=0 && next_x<m && next_y>=0 && next_y<n &&
              !seen[next_x][next_y]){
                int idx=board[next_x][next_y]-'a';
                if(node.children[idx]!=null)
                    dfs(board,seen,node.children[idx],m,n,next_x,next_y);
            }
        }
        seen[x][y]=false;
    }
}
