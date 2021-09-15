class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> res=new HashSet<>();
        int n=nums.length;
        Arrays.sort(nums);
        
        for(int i=0;i<n-2;i++){
            //***point spd up
            if(i>0 && nums[i]==nums[i-1])
                continue;
            
            int j=i+1, k=n-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]<0){
                    j++;
                }else if(nums[i]+nums[j]+nums[k]>0){
                    k--;
				}else{
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    j++;
                    k--;
                    
                    //***point spd up
                    while(j<k && nums[j]==nums[j-1]) j++;
                	while(j<k && nums[k]==nums[k+1]) k--;
                }
            }
        }
        
        return new ArrayList<>(res);
    }
}
