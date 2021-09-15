class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int closest;
        closest=nums[0]+nums[1]+nums[nums.length-1];//
        
        for(int i=0;i<nums.length-2;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int cur=nums[i]+nums[j]+nums[k];
                closest=(Math.abs(target-closest)<Math.abs(target-cur)) ? closest: cur;
                
                if(target<cur){
                    k--;
                }else if(target>cur){
                    j++;
                }else{
                    return target;
                }
            }
        }
        return closest;
    }
}
