class Solution {
    //Time Complexity - O(n!)， Space Complexity - O(n)。
    //backtracking + DFS
    //ims, 100% faster
    
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        getPermute(nums, res, new ArrayList<>());
        return res;
    }
    
    public void getPermute(int [] nums, List<List<Integer>> res, List<Integer> tempList){
        
        if(tempList.size()==nums.length){
            res.add(new ArrayList<>(tempList));
        }else{
        
            for(int i=0;i<nums.length;i++){
                if(tempList.contains(nums[i])) continue; //point

                tempList.add(nums[i]);
                getPermute(nums, res, tempList);
                tempList.remove(tempList.size()-1);
            }
        }
        
    }
    
    //e.g. 1 2 3
    //[1] 2~3
        //[1,2]
            //[1,2,3]
        //[1,3]
            //[1,3,2]
    //[2] 1 3
        //
}
