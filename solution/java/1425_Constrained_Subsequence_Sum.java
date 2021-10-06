class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
//         //sol.1 dp O(N*K) TLE
//         int res=Integer.MIN_VALUE;
//         int[] dp=new int[nums.length];
        
//         for(int i=0;i<nums.length;i++){
//             int max=0;
//             for(int j= Math.max(0,i-k); j<i;j++){
//                 max=Math.max(max,dp[j]);
//             }
//             dp[i]=max+nums[i];
//             res=Math.max(res, dp[i]);
//         }
        
//         return res;
        
        
        
//         //sol.2 dp+deque store max presum from i-1 to i-k, O(N) 
//         int res=Integer.MIN_VALUE;
//         int[] dp=new int[nums.length];
//         Deque<Integer> deque=new LinkedList<>();
        
//         for(int i=0;i<nums.length;i++){
//             int max=(deque.isEmpty()) ? 0 : dp[deque.peekFirst()];
//             max=Math.max(max,0);
            
//             dp[i]=max+nums[i];
//             res=Math.max(res, dp[i]);
            
//             while(!deque.isEmpty() && dp[i]>=dp[deque.peekLast()]){
//                 deque.pollLast();
//             }
//             deque.addLast(i);
//             if(i-deque.peekFirst()+1>k){
//                 deque.pollFirst();
//             }
//         }
        
//         return res;
        
        
        
//         //sol.2.5 dp using orig arr+deque store max presum from i-1 to i-k, O(N) 
//         int res=Integer.MIN_VALUE;
//         Deque<Integer> deque=new LinkedList<>();
        
//         for(int i=0;i<nums.length;i++){
//             int max=(deque.isEmpty()) ? 0 : nums[deque.peekFirst()];
//             max=Math.max(max,0);
            
//             nums[i]=max+nums[i];
//             res=Math.max(res, nums[i]);
            
//             while(!deque.isEmpty() && nums[i]>=nums[deque.peekLast()]){
//                 deque.pollLast();
//             }
//             deque.addLast(i);
//             if(i-deque.peekFirst()+1>k){
//                 deque.pollFirst();
//             }
//         }
        
//         return res;
        
        
        //sol.2.5.2 dp using orig arr+ArrayDeque store max presum from i-1 to i-k, O(N) 
        //ArrayDeque is little faster than linklist
        int res=Integer.MIN_VALUE;
        ArrayDeque<int[]> deque=new ArrayDeque<>();
        
        for(int i=0;i<nums.length;i++){
            int max=(deque.isEmpty()) ? 0 : deque.getFirst()[1];
            max=Math.max(max,0);
            
            nums[i]=max+nums[i];
            res=Math.max(res, nums[i]);
            
            while(!deque.isEmpty() && nums[i]>=deque.getLast()[1]){
                deque.removeLast();
            }
            deque.addLast(new int[]{i,nums[i]});
            if(i-deque.getFirst()[0]+1>k){
                deque.removeFirst();
            }
        }
        
        return res;
    }
}
