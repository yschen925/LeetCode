class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] usedList = new boolean[nums.length];
        
        
        getPermuteUnique(nums, res, new ArrayList<>(), usedList);
        
        return res;
    }
    
    public void getPermuteUnique(int[] nums, List<List<Integer>> res, List<Integer> tempList, boolean[] usedList){
        
        if(tempList.size()==nums.length){
            res.add(new ArrayList<>(tempList));
        }else{
            for(int i=0;i<nums.length;i++){
                if(usedList[i]==true || (i>0 &&nums[i]==nums[i-1]&&usedList[i-1]==true) ) continue; //point
                
                usedList[i]=true;
                tempList.add(nums[i]);
                getPermuteUnique(nums, res, tempList, usedList);
                tempList.remove(tempList.size()-1);
                usedList[i]=false;
            }
        }
        
    }
}
