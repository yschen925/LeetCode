class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        //sol1.
        int i=0;
        while(i<nums.length){
            int j=nums[i]-1;
            if(nums[i]!=nums[j]){
                //swap
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }else{
                ++i;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for(i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                res.add(nums[i]);
            }
        }
        
        return res;
        
        
        
//         // sol.my
//         List<Integer> res=new ArrayList<>();
        
//         for(int i=0;i<nums.length;i++){
//             //int cur=nums[i];
//             if(nums[i]==i+1 || nums[i]==-1) continue;
//             else{
//                 while(nums[i]!=i+1 & nums[i]!=-1){
//                     int tmp=nums[nums[i]-1];
//                     if(tmp==nums[i]){
//                         nums[i]=-1;
//                         res.add(tmp);
//                     }else{
//                         nums[nums[i]-1]=nums[i];
//                         nums[i]=tmp;
//                     }
//                 }
//             }
//         }
        
//         return res;
    }
}
