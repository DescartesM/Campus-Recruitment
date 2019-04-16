package JD;

import java.util.*;

public class Main {
    static class UF {
        private int[] id;
        private int[] sz; // weight for node
        private int count;

        public UF(int N) {
            count = N;
            id = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
            }
            sz = new int[N];
            for (int i = 0; i < N; i++) {
                sz[i] = 1;
            }
        }

        public int find(int x) {
            int p = x, t;
            while (p != id[p])
                p = id[p];
            // path yasuo
            while (x != p) {
                t = id[x];
                id[x] = p;
                x = t;
            }
            return x;
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public void union(int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot)
                return;
            // add the little tree to big tree
            if (sz[pRoot] < sz[qRoot]) {
                id[pRoot] = qRoot;
                sz[qRoot] += sz[pRoot]; //
            } else {
                id[qRoot] = pRoot;
                sz[pRoot] += sz[qRoot];
            }
            count--;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        UF uf = new UF(n);
        for (int i=0;i<n-1;i++){
            int p = scanner.nextInt()-1;
            int q = scanner.nextInt()-1;
            if (q == 0)
                continue;
            if (uf.connected(p, q))
                continue;
            uf.union(p, q);

        }
        int res = 0;
        for (int i=0;i<n;i++){
            if (uf.sz[i] > res)
                res = uf.sz[i];
        }
        System.out.println(res);
    }


}
