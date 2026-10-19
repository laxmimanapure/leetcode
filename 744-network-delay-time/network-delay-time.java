class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:times){
            int u=e[0];
            int v=e[1];
            int wt=e[2];
            adj.get(u).add(new int[]{v,wt});
        }
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.offer(new int[]{0,k});
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int d=curr[0];
            int node=curr[1];
            if(d>dist[node]){
                continue;
            }
            for(int[] ni:adj.get(node)){
                int nextnode=ni[0];
                int w=ni[1];
                if(dist[node]+w<dist[nextnode]){
                    dist[nextnode]=dist[node]+w;
                    pq.offer(new int[]{dist[nextnode],nextnode});
                }
            }


        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
             if (dist[i] == Integer.MAX_VALUE) {
                 return -1;
                } 
                ans = Math.max(ans, dist[i]); 
                }
         return ans;
    }
}