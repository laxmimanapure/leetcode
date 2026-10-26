class DSU{
    int[] parent;
    int size[];
    DSU(int n){
        parent=new int[n];        
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x]=find(parent[x]);
    }
    boolean union(int x,int y){
        int rootA=find(x);
        int rootB=find(y);
        if(rootA==rootB){
            return false;
        }
        if(size[rootA]<size[rootB]){
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }
        parent[rootB]=rootA;
        size[rootA]+=size[rootB];
        return true;
    }

}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        DSU dsu=new DSU(n);
        HashMap<String,Integer> map=new HashMap();
        for(int i=0;i<accounts.size();i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String email=accounts.get(i).get(j);
                if(map.containsKey(email)){
                    dsu.union(i,map.get(email));
                }else{
                    map.put(email,i);
                }
            }
        }
        HashMap<Integer,TreeSet<String>> m=new HashMap<>();
        for(String e:map.keySet()){
            int root=dsu.find(map.get(e));
            m.putIfAbsent(root,new TreeSet<>());
            m.get(root).add(e);
        }
        List<List<String>> ans=new ArrayList<>();
        for(int root:m.keySet()){
            List<String> l=new ArrayList<>();
            l.add(accounts.get(root).get(0));
            l.addAll(m.get(root));
            ans.add(l);
        }
        return ans;

        

    }
}