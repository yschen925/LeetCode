class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {

        vector<int> list;
        //sol.1 swap, 4ms 75% faster
        findPermute(nums, 0);
        //sol.2, 4ms 75% faster
        // findPermute(nums, list);
        return res;
    }
    
private:
    vector<vector<int>> res;
   
    //sol.1
    void findPermute(vector<int>& nums, int start){
        if(start>=nums.size()){
            res.push_back(vector<int>(nums));
            return;
        }
        
        for(int i=start;i<nums.size();i++){
            swap(nums[start], nums[i]);
		    findPermute(nums, start + 1);
		    swap(nums[start], nums[i]);
        }
        
    }
    
//     //sol.2
//     void findPermute(vector<int>& nums, vector<int>& list){
//         if(nums.size()==0){
//             res.push_back(vector<int>(list));
//             return;
//         }
        
//         for(int i=0;i<nums.size();i++){
//             int cur=nums[i];
//             nums.erase(nums.begin()+i);
//             list.push_back(cur);
                
//             findPermute(nums, list);
            
//             nums.insert(nums.begin()+i,cur);
//             list.pop_back();
//         }
        
//     }
};
