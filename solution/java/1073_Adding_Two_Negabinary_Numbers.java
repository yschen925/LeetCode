class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        
        int idx1=arr1.length-1;
        int idx2=arr2.length-1;
        
        Stack<Integer> st=new Stack<>();
        
        int carry=0;
        while(idx1>=0 || idx2>=0 || carry!=0){
            if(idx1>=0) carry+=arr1[idx1--];
            if(idx2>=0) carry+=arr2[idx2--];
            st.push(carry&1);
            carry=-(carry>>1);//***point
        }
        
        while(!st.isEmpty()&&st.peek()==0)
            st.pop();
        
        if(st.size()==0) st.push(0);
        
        int[] res=new int[st.size()];
        int i=0;
        while(!st.isEmpty()){
            res[i++]=st.pop();
        }
        return res;
    }
}
