public class DisjointSetUnion {
    private int[] parent;
    private int[] rank;

    public DisjointSetUnion(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public static void main(String[] args) {
        DisjointSetUnion dsu = new DisjointSetUnion(10);

        dsu.union(1,4);
        dsu.union(4,1);
        dsu.union(2,6);
        dsu.union(3,2);
        dsu.union(6,3);
        dsu.union(5,5);

        System.out.println(dsu.isConnected(1,1));
        System.out.println(dsu.isConnected(2,2));
        System.out.println(dsu.isConnected(3,3));
        System.out.println(dsu.isConnected(4,4));
        System.out.println(dsu.isConnected(5,5));
    }
}
