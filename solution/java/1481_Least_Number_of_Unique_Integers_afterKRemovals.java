class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        
        //bucketsort O(n)
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int num:arr){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        
        //bucket for size=0~arr.length
        int unique=0;
        int[] buckets=new int[arr.length+1];
        for(int count:map.values()){
            buckets[count]+=1;
            unique+=1;
        }
        
        for(int i=1;i<buckets.length;i++){
            if(k-buckets[i]*i<=0) {
                unique-=k/i;
                break;
            }else{
                unique-=buckets[i];
                k-=buckets[i]*i;
            }
        }
        return unique;
        
        
//         //O(nlogn)
//         HashMap<Integer, Integer> map= new HashMap<>();
//         for(int num:arr){
//             map.put(num, map.getOrDefault(num,0)+1);
//         }
        
//         PriorityQueue<Integer> minheap = new PriorityQueue<>();
//         for(Map.Entry<Integer,Integer> entry: map.entrySet()){
//             minheap.offer(entry.getValue());
//         }
        
//         while(k>0 && !minheap.isEmpty()){
//             k-=minheap.poll();
//         }
        
//         return (k<0) ? minheap.size()+1 : minheap.size();
    }
}
