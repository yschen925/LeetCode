class Solution {
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        boolean[] seen=new boolean[n];
        
        return reach(arr,seen,start);
    }
    
    //sol.1.5
    private boolean reach(int[] arr, boolean[] seen, int idx){
        
        if(idx<0 || idx>=arr.length || seen[idx]) return false;
        else if(arr[idx]==0) return true;
        else {
            seen[idx]=true;
            return (reach(arr,seen,idx+arr[idx])||
                    reach(arr,seen,idx-arr[idx]));
        }
    }
 
//     // sol.1 
//     private boolean reach(int[] arr, boolean[] seen, int idx){
//         if(arr[idx]==0) return true;
        
//         seen[idx]=true;
        
//         int rIdx=idx+arr[idx];
//         if(rIdx<arr.length && !seen[rIdx]){
//             if(reach(arr,seen,rIdx)) return true;
//         }
        
//         int lIdx=idx-arr[idx];
//         if(lIdx>=0 && !seen[lIdx]){
//             if(reach(arr,seen,lIdx)) return true;
//         }
        
//         return false;
//     }
}
