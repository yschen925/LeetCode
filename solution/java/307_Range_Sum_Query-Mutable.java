class NumArray {

    //94ms, 43% faster
    //Insert,Update: O(logn)
    //Query: O(logn+k)
  
    class SegTreeNode{
        int start, end;
        int sum;
        SegTreeNode left;
        SegTreeNode right;
        
        public SegTreeNode(int start, int end, int sum, SegTreeNode left, SegTreeNode right){
            this.start=start;
            this.end=end;
            this.sum=sum;
            this.left=left;
            this.right=right;
        }
    }
    
    private SegTreeNode root;
    private SegTreeNode buildSegTree(int[] nums, int start, int end){
        if(start==end){
            return new SegTreeNode(start, end, nums[start], null, null);
        }else{
            int mid=start+(end-start)/2;
            SegTreeNode left=buildSegTree(nums,start,mid);
            SegTreeNode right=buildSegTree(nums,mid+1,end);
            
            int sum=left.sum+right.sum;
            return new SegTreeNode(start, end, sum, left, right);
        }
    }
    
    private void updateSegTree(SegTreeNode node, int index, int val){
        if(node.start==node.end && node.start==index){
            node.sum=val;
        }else{
            int mid=node.start+(node.end-node.start)/2;
            if(index<=mid){
                updateSegTree(node.left,index,val);
            }else{
                updateSegTree(node.right,index,val);
            }
            //update sum
            node.sum=node.left.sum+node.right.sum;
        }
        
    }
    
    private int getSegTreeSum(SegTreeNode node, int start, int end){
        
        if(node.start==start && node.end==end){
            return node.sum;
        }
        
        int mid=node.start+(node.end-node.start)/2;
        if(end<=mid){
            return getSegTreeSum(node.left, start, end);
        }else if(start>mid){
            return getSegTreeSum(node.right, start, end);
        }else{
            return getSegTreeSum(node.left, start, mid)+getSegTreeSum(node.right, mid+1, end);
        }
    }
    //
    
    public NumArray(int[] nums) {
        root=buildSegTree(nums,0,nums.length-1);
    }
    
    public void update(int index, int val) {
        updateSegTree(root, index, val);
    }
    
    public int sumRange(int left, int right) {
        return getSegTreeSum(root, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
