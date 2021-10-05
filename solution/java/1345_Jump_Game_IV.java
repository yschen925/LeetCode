class Solution {
    public int minJumps(int[] arr) {
        int n=arr.length;
        int cnt=0;
        boolean[] seen=new boolean[n];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int a=arr[i];
            if(!map.containsKey(a))
                map.put(a,new ArrayList<>());
            map.get(a).add(i);
        }
        
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        seen[0]=true;
        
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int curIdx=q.poll();
                if(curIdx==n-1) return cnt;
                

                List<Integer> next=map.get(arr[curIdx]);
                next.add(curIdx-1);
                next.add(curIdx+1);
                for(int idx:next){
                    if(idx>=0 && idx<n && !seen[idx]){
                        q.add(idx);
                        seen[idx]=true;
                    }
                }
                next.clear();

            }
            cnt++;
        }
        return -1;
    }
}
