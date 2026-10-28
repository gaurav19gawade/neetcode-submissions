class Union {
    int[] parent;

    Union(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int findParent(int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    // returns false if x and y were already connected (cycle)
    public boolean union(int x, int y) {
        int px = findParent(x);
        int py = findParent(y);
        if (px == py) return false;
        parent[px] = py;
        return true;
    }
}

class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        Union union = new Union(n);
        for (int[] edge : edges) {
            if (!union.union(edge[0], edge[1])) return false;
        }
        return true;
    }
}