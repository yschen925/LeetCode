class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList<>();
        int top=0;
        int down=matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;
        
        while(top<=down && left<=right){
            //top left to top right
            //++up
            //top right to down right
            //++right
            //down right to down left
            //--down
            //down left to up left
            //--left
            
            for(int j=left;j<=right;j++)
                res.add(matrix[top][j]);
            ++top;
            if(top>down) break;
            
            for(int i=top;i<=down;i++)
                res.add(matrix[i][right]);
            --right;
            if(left>right) break;
            
            for(int j=right;j>=left;j--)
                res.add(matrix[down][j]);
            --down;
            if(top>down) break;
            
            for(int i=down;i>=top;i--)
                res.add(matrix[i][left]);
            ++left;
            if(left>right) break;
        }
        
        return res;
    }
}
