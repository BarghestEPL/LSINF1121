public class ConnectedComponents {
    public static class QuickUnion {
        private int nSets;
        private final int[] ids;

        public QuickUnion(int n) {
            nSets = n;
            ids = new int[n];
            for (int i = 0; i < n; i++) {
                ids[i] = i;
            }
        }

        public int root(int x) {
            while(ids[x] != x) x = ids[x];
            return x;
        }

        public boolean find(int p, int q) {
            return root(p) == root(q);
        }

        public void unite(int p, int q) {
            int x = root(p);
            int y = root(q);
            if(x != y) {
                ids[x] = y;
                nSets--;
            }
        }

        public int nSets(){
            return nSets;
        }
    }
    /**
     * @return the number of connected components in g
     */
    public static int numberOfConnectedComponents(Graph g) {
        // TODO
        QuickUnion quickUnion = new QuickUnion(g.V());
        for (int i = 0; i < g.V(); i++) {
            Iterable<Integer> iterable = g.adj(i);
            for (int neighbor : iterable) {
                quickUnion.unite(i, neighbor);
            }
        }
        return quickUnion.nSets();
    }
}