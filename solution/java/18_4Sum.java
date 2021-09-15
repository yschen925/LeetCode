class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> set=new HashSet<>();
        LinkedList<Integer> list=new LinkedList<>();
        
        
        Arrays.sort(nums);
        kSum(nums, target, set, list, 4, 0, 0);
        
        return new ArrayList<>(set);
    }
    
    private void kSum(int[] nums, int target, HashSet<List<Integer>> set, LinkedList<Integer> list, int k, int sum, int start){
        
        if(k==2){
            twoSum(nums, target, set, list, sum, start);
        }else{
            for(int i=start;i<=nums.length-k;i++){
                
                sum+=nums[i];
                list.add(nums[i]);
                kSum(nums, target, set, list, k-1, sum, i+1);
                sum-=nums[i];
                list.removeLast();
                
                //***point improve from 70ms to 17ms
                while(i+1<=nums.length-k && nums[i]==nums[i+1]) 
                    i++;
            }
        }
    }
    
    private void twoSum(int[] nums, int target, HashSet<List<Integer>> set, LinkedList<Integer> list, int sum, int start){
        int i=start, j=nums.length-1;
        while(i<j){
            if(sum+nums[i]+nums[j]>target){
                while(i<j && sum+nums[i]+nums[j]>target) j--;
            }else if(sum+nums[i]+nums[j]<target){
                while(i<j && sum+nums[i]+nums[j]<target) i++;
            }else{  
                List<Integer> newList=new ArrayList<>(list);
                newList.add(nums[i]);
                newList.add(nums[j]);
                set.add(new ArrayList<>(newList));

                i++;
                j--;
            }
        }
    }
}
