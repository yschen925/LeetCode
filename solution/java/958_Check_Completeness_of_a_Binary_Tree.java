/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
//         //sol1. BFS
//         Queue<TreeNode> q=new LinkedList<>();
//         q.add(root);
        
//         while(q.peek()!=null){
//             TreeNode node=q.poll();            
//             q.offer(node.left);
//             q.offer(node.right);
//         }
        
//         while(!q.isEmpty()){
//             TreeNode node=q.poll();
//             if(node!=null) return false;
//         }
//         return true;
        
        
        
//         //sol1.5 BFS stop when meet first null child
//         Queue<TreeNode> q=new LinkedList<>();
//         q.add(root);
        
//         while(q.peek()!=null){
//             TreeNode node=q.poll();  
            
//             if(node.left==null){
//                 if(node.right!=null)
//                     return false;
//                 else
//                     break;
//             }
//             q.offer(node.left);
            
//             if(node.right==null){
//                 break;
//             }
//             q.offer(node.right);
//         }
        
//         while(!q.isEmpty()){
//             TreeNode node=q.poll();
//             if(node.left!=null || node.right!=null) return false;
//         }
//         return true;
        
        
        
        //sol2. DFS, faster
        // if left subtree is a full tree with l nodes,
        // right subtree must have r nodes that l / 2 <= r <= l
        // if right subtree is a full tree with r nodes,
        // left subtree must have l nodes that r <= l <= r * 2 + 1.
        
        return dfs(root) >= 0;
    }
    
     public int dfs(TreeNode root) {
        if (root == null) return 0;
         
        int l=dfs(root.left), r=dfs(root.right);
        if ((l&(l+1)) == 0 && l/2<=r && r<=l)
            return l+r+1;
        if ((r&(r+1)) == 0 && r<=l && l<=r*2+1)
            return l+r+1;
        return -1 ;
    }
}
