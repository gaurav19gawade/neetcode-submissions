class Union {
    int[] parent;
    int[] size;

    Union(int capacity) {
        this.parent = new int[capacity];
        this.size = new int[capacity];

        for (int i = 0; i < capacity; i++) {
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }

    public int findParent(int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    public void merge(int x, int y) {
        int pOfX = findParent(x);
        int pOfY = findParent(y);

        if (pOfX == pOfY)
            return;

        if (size[pOfX] > size[pOfY]) {
            parent[pOfY] = pOfX;
            size[pOfX] += size[pOfY];
        } else {
            parent[pOfX] = pOfY;
            size[pOfY] += size[pOfX];
        }
    }
}


class Solution {
    public int countComponents(int n, int[][] edges) {
        int connectedComp = 0;
        Union union = new Union(n);

        for(int[] edge: edges){
            union.merge(edge[0], edge[1]);
        }

        for(int i = 0; i < n; i++){
            int pOfI = union.findParent(i);
            if(pOfI == i) connectedComp++;
        }
        return connectedComp;
    }
}
