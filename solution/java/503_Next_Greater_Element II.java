class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        Arrays.fill(res,-1);
        Stack<Integer> st=new Stack<>();
        
        //2-pass
        for(int i=0;i<2;i++){
            for(int idx=0;idx<n;idx++){
                while(!st.isEmpty() && nums[st.peek()]<nums[idx])
                    res[st.pop()]=nums[idx];
                st.push(idx);
            }
        }
        return res;
    }
}
