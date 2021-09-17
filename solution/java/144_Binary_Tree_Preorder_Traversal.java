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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Deque<TreeNode> deque=new LinkedList<>();
        
        if(root!=null)
            deque.addLast(root);
        
        while(!deque.isEmpty()){
            TreeNode node=deque.poll();
            res.add(node.val);
            
            if(node.right!=null) deque.addFirst(node.right);
            if(node.left!=null) deque.addFirst(node.left);
        }
        
        return res;
    }
}
