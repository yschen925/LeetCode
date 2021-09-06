class Solution {
public:
    int setNum=2;
    
    bool canPartition(vector<int>& nums) {
        
        //sol1. 1d dp, 84ms, 85% faster
        int sum = accumulate(nums.begin(), nums.end(), 0), target = sum >> 1;
    	  if (sum & 1) return false;
      	vector<int> dp(target + 1, 0);
      	dp[0] = 1;
      	for(auto num : nums) 
          	for(int i = target; i >= num; i--)
              	dp[i] = dp[i] || dp[i - num];
      	return dp[target];
        
        
//         //sol1.5 2d dp, slow
//         vector<int> subset(2);
//         int n=nums.size();
//         int sum=0;
//         for(int num : nums){
//             sum+=num;
//         }
        
//         if(nums.size()<setNum || sum%setNum!=0) return false;
        
//         sum/=setNum;
        
//         vector<vector<bool>> dp(n+1, vector<bool>(sum+1));

//         //init
//         for(int i=0;i<n+1;i++) dp[i][0]=true;
        
//         //dp
//         for(int i=1;i<n+1;i++){
//             for(int s=1;s<sum+1;s++){
//                 dp[i][s]=dp[i-1][s];
                
//                 if(s>=nums[i-1]){
//                     dp[i][s]=dp[i][s]||dp[i-1][s-nums[i-1]];
//                 }
//             }
//         }
        
//         return dp[n][sum];
        
        
        
//         //sol2. backtrack, TLE
//         sort(nums.begin(),nums.end());
//         reverse(nums.begin(),nums.end());
        
//         vector<int> subset(2);
//         int sum=0;
//         for(int num : nums){
//             sum+=num;
//         }
        
//         if(nums.size()<setNum || sum%setNum!=0) return false;
        
//         return find(nums,subset,0,sum/setNum);
    }

private:
    
//     //sol2.
//     bool find(vector<int>& nums, vector<int> &subset, int idx, int sum){
//         if(idx==nums.size()) return true;
        
//         int num=nums[idx];
//         for(int i=0;i<setNum;i++){
//             if(subset[i]+num>sum || (i>0 && subset[i]==subset[i-1])) continue;
                
//             subset[i]+=num;
//             if(find(nums, subset, idx+1, sum))
//                 return true;
//             subset[i]-=num;
//         }
        
//         return false;
//     }
    
};
