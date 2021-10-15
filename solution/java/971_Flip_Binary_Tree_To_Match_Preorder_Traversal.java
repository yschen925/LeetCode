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
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        
        return (flip(root,voyage)==true) ? res : Arrays.asList(-1);
        
    }
    
    private boolean flip(TreeNode root, int[] voyage){
        if(root==null) return true;
        else if(root.val!=voyage[idx++]) return false;
        
        if(root.left!=null && root.left.val!=voyage[idx]){
            res.add(root.val);
            return flip(root.right, voyage)&&flip(root.left, voyage);
        }
        return flip(root.left, voyage)&&flip(root.right, voyage);
    }
    
    private int idx=0;
    private List<Integer> res=new ArrayList<>();
}
