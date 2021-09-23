class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //sol1. recursive
        //https://leetcode.com/problems/subsets/discuss/27281/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)
        
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        
        backtrack(nums,0,res,list);
        
        return res;
        
        
//         //sol2.iterative
//         List<List<Integer>> res=new ArrayList<>();
//         res.add(new ArrayList<>());
        
//         for(int i=0;i<nums.length;i++){
//             int n=res.size();
//             for(int j=0;j<n;j++){
//                 List<Integer> list=new ArrayList<>(res.get(j));
//                 list.add(nums[i]);
//                 res.add(list);
//             }
//         }
//         return res;
    }
    
    private void backtrack(int[] nums, int start, List<List<Integer>> res, List<Integer> list){
        res.add(new ArrayList<>(list));
        
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            backtrack(nums, i+1, res, list);
            list.remove(list.size()-1);
        }
    }
}
