class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        //sol.sliding window
        int origHappy=0;
        int makeHappy=0;
        int maxMakeHappy=0;
        int n=customers.length;
        
        for(int i=0;i<n;i++){
            
            origHappy+=customers[i]-customers[i]*grumpy[i];
            makeHappy+=customers[i]*grumpy[i];
            
            if(i-minutes>=0){
                makeHappy-=customers[i-minutes]*grumpy[i-minutes];
            }
            
            maxMakeHappy=Math.max(maxMakeHappy,makeHappy);
        }
        
        return origHappy+maxMakeHappy;
        
        
//         //sol.my sliding window
//         int max=0;
//         int n=customers.length;
        
//         for(int i=0;i<n;i++){
//             max+=customers[i]-customers[i]*grumpy[i];
//         }
        
//         int cur=max;
//         int windows=minutes;
//         for(int i=0;i<n;i++){
//             if(i-minutes>=0 && windows==0){
//                 if(grumpy[i-minutes]>0)
//                     cur-=customers[i-minutes];
//                 ++windows;
//             }
            
//             if(windows>0){
//                 if(grumpy[i]>0)
//                     cur+=customers[i];
//                 --windows;
//             }
            
//             max=Math.max(max,cur);
//         }
        
//         return max;
    }
}
