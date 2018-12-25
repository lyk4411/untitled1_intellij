package leetcode;

/**
 * Created by lyk on 2018-12-25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class RegionsCutBySlashes {
    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
        DSU dsu = new DSU(4 * N * N);
        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c) {
                int root = 4 * (r * N + c);
                char val = grid[r].charAt(c);
                if (val == '\\') {
                    dsu.union(root + 0, root + 1);
                    dsu.union(root + 2, root + 3);
                }
                if (val == '/') {
                    dsu.union(root + 0, root + 3);
                    dsu.union(root + 1, root + 2);
                }
                if (val == ' '){
                    dsu.union(root + 0, root + 1);
                    dsu.union(root + 1, root + 2);
                    dsu.union(root + 2, root + 3);
                }

                // north south
                if (c + 1 < N)
                    dsu.union(root + 1, (root + 4) + 3);
                if (r + 1 < N)
                    dsu.union(root + 2, (root + 4 * N) + 0);
            }

        int ans = 0;
        for (int x = 0; x < 4 * N * N; ++x) {
            if (dsu.find(x) == x)
                ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        RegionsCutBySlashes rcbs = new RegionsCutBySlashes();
        System.out.println(rcbs.regionsBySlashes(new String[]{" /", "/ "}));
        System.out.println(rcbs.regionsBySlashes(new String[]{ " /", "  "}));
        System.out.println(rcbs.regionsBySlashes(new String[]{ "\\/", "/\\"}));
        System.out.println(rcbs.regionsBySlashes(new String[]{ "/\\", "\\/"}));
        System.out.println(rcbs.regionsBySlashes(new String[]{ "//", "/ "}));
    }
}

class DSU {
    int[] parent;

    public DSU(int N) {
        parent = new int[N];
        for (int i = 0; i < N; ++i)
            parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}
