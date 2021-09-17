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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //sol. BFS queue
//         //BFS
//         List<List<Integer>> res = new ArrayList<>();
//         Queue<TreeNode> q = new LinkedList<>();
//         int lv=-1;
        
//         if(root!=null) q.offer(root);
//         while(!q.isEmpty()){
//             lv++;
//             int lv_size=q.size();
//             List<Integer> lv_res = new ArrayList<>();
            
//             for(int i=0;i<lv_size;i++){
//                 TreeNode n = q.poll();
                
//                 if(lv%2==0) lv_res.add(n.val);
//                 else lv_res.add(0, n.val);
                
//                 if(n.left!=null) q.offer(n.left);
//                 if(n.right!=null) q.offer(n.right);
//             }
//             res.add(lv_res);
//         }
        
//         return res;
        
        
        //sol2. recursive
        List<LinkedList<Integer>> res=new LinkedList<>();
        traversal(root, 0, res);
        return new ArrayList<>(res);
    }
    
    private void traversal(TreeNode node, int level, List<LinkedList<Integer>> res){
        
        if(node==null) return;
        
        if(res.size()<=level){
            res.add(new LinkedList<Integer>());
        }
        
        if(level%2==0){
            //l to r
            res.get(level).addLast(node.val);
        }else{
            //r to l
            res.get(level).addFirst(node.val);
        }
        
        traversal(node.left, level+1, res);
        traversal(node.right, level+1, res);
    }
}
