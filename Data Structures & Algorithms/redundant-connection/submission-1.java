class Union {
    int[] parent;

    Union(int capacity){
        this.parent = new int[capacity];
        for(int i = 1; i < capacity; i++){
            parent[i] = i;
        }
    }

    public int find(int x){
        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    public boolean merge(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px == py) return false;
        parent[py] = px;
        return true;
    }
}


class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Union union = new Union(edges.length+1);

        for(int[] edge: edges){
            if(!union.merge(edge[0], edge[1])){
                return new int[]{edge[0], edge[1]};
            }
        }

        return new int[0];
    }
}
