class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        
        char[][] board=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        
        dfs(board,res,0,n);
        
        return res;
    }
    
    private void dfs(char[][] board, List<List<String>> res, int row, int n){
        if(row==n){
            res.add(toString(board,n));
            return;
        }
        
        for(int col=0;col<board[0].length;col++){
            if(valid(board, row, col, n)){
                board[row][col]='Q';
                dfs(board,res,row+1,n);
                board[row][col]='.';
            }
        }
    }
    
    
    private boolean valid(char[][] board, int row, int col, int n){
        // check col
        for(int i=row;i>=0;--i)
            if(board[i][col] == 'Q') return false;
        // check left diagonal
        for(int i=row,j=col;i>=0&&j>=0;--i,--j)
            if(board[i][j] == 'Q') return false;
        //check right diagonal
        for(int i=row,j=col;i>=0&&j<n;--i,++j)
            if(board[i][j] == 'Q') return false;
        return true;
	}
    
    
    private List<String> toString(char[][] board,int n){
        List<String> res=new ArrayList<String>();
        StringBuilder sb;
        for(int i=0;i<n;i++){
            sb=new StringBuilder();
            for(int j=0;j<n;j++){
                sb.append(board[i][j]);
            }
            res.add(sb.toString());
        }
        return res;
    }
}
