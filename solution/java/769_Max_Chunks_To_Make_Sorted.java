class Solution {
    public int maxChunksToSorted(int[] arr) {
        
        //sol.1 2pass
        int res=0;
        int n=arr.length;
        int[] leftMax=new int[n];
        int[] rightMin=new int[n];
        
        leftMax[0]=arr[0];
        for(int i=1;i<n;i++){
            leftMax[i]=Math.max(leftMax[i-1],arr[i]);
        }
        
        rightMin[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--){
            rightMin[i]=Math.min(rightMin[i+1],arr[i]);
        }
        
        for(int i=0;i<n-1;i++){
             if(leftMax[i]<=rightMin[i+1]) res++;
        }
        
        return res+1;
        
        
//         //sol.2
//         //Iterate the array, if the max(A[0] ~ A[i]) = i,
//         int maxVal=Integer.MIN_VALUE;
//         int res=0;
        
//         for(int i=0;i<arr.length;i++){
//             maxVal=Math.max(maxVal,arr[i]);
//             if(maxVal==i)
//                 ++res;
//         }
        
//         return res;
        
        
        
        //sol.my
//         int maxVal=Integer.MIN_VALUE;
//         int minVal=Integer.MAX_VALUE;
//         int idx=0;
//         int res=0;
        
//         for(int i=0;i<arr.length;i++){
//             //
//             maxVal=Math.max(maxVal,arr[i]);
//             minVal=Math.min(minVal,arr[i]);
            
//             if(maxVal==minVal){
//                 if(maxVal==i) 
//                     ++res;
//             }else if(maxVal==i){
                
//                 if(maxVal-minVal==i-idx){
//                     ++res;
//                     //reset
//                     maxVal=Integer.MIN_VALUE;
//                     minVal=Integer.MAX_VALUE;
//                     idx=i+1;
//                 }
//             }
//         }
        
//         return res;
    }
}
