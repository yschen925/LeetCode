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
    public TreeNode bstFromPreorder(int[] preorder) {
        
        return build(preorder,Integer.MAX_VALUE);
    }
    
    private int idx=0;
    private TreeNode build(int[] preorder, int bound){
        if(idx>=preorder.length||preorder[idx]>bound) return null;
        TreeNode node=new TreeNode(preorder[idx++]);
        node.left=build(preorder, node.val);
        node.right=build(preorder, bound);
        return node;
    }
}
