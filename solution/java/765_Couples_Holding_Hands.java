class Solution {
    
    //sol1.5
    public int minSwapsCouples(int[] row) {
        int swap=0;
        int groupCnt=row.length/2;
        UnionFind uf = new UnionFind(groupCnt);
        
        for(int i=0;i<groupCnt;i++){
            int p1=row[i*2];
            int p2=row[i*2+1];
            
            uf.union(p1/2,p2/2);
        }
        
        return groupCnt - uf.getCnt();
    }
    
    class UnionFind {
        
        int[] group;
        int count;
        
        public UnionFind(int x){
            group=new int[x];
            for(int i=0;i<x;i++){
                group[i]=i;
            }
            count=x;
        }
        
        public int find(int x){
            if(group[x]!=x) group[x]=find(group[x]);
            // System.out.println("group[x]"+group[x]);
            return group[x];
        }
        
        public void union(int x, int y){
            int rx=find(x);
            int ry=find(y);
            
            if(rx!=ry){
                group[ry]=rx;
                count--;
            }
        }
        
        public int getCnt(){
            return count;
        }
    }
    
    //sol1 unionfind slow
//     public int minSwapsCouples(int[] row) {
//         int swap=0;
//         int groupCnt=row.length/2;
//         UnionFind uf = new UnionFind(row.length);
        
//         for(int i=0;i<groupCnt;i++){
//             int p1=row[i*2];
//             int p2=row[i*2+1];
            
//             int g1=p1/2;
//             int g2=p2/2;
            
//             // System.out.println(p1+","+g1);
//             // System.out.println(p2+","+g2);
            
//             if(g1!=g2 && uf.find(p1)!=uf.find(p2)){
//                 swap++;
//                 uf.union(p1,p2);
//             }
//         }
        
//         return swap;
//     }
    
//     class UnionFind {
        
//         int[] group;
        
//         public UnionFind(int x){
//             group=new int[x];
//             for(int i=0;i<x/2;i++){
//                 group[2*i]=i;
//                 group[2*i+1]=i;
//             }
//         }
        
//         public int find(int x){
//             //if(group[x]!=x) group[x]=find(group[x]);
//             // System.out.println("group[x]"+group[x]);
//             return group[x];
//         }
        
//         public void union(int x, int y){
//             int rx=find(x);
//             int ry=find(y);
            
//             // if(rx!=ry)
//             //     group[ry]=rx;
//             for(int i=0;i<group.length;i++)
//                 if(group[i]==ry) group[i]=rx;
//         }
//     }
}
