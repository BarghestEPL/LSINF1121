import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DigraphImplem implements Digraph {
    private int E;
    private final int V;
    private final List<List<Integer>> adj;
    public DigraphImplem(int V) {
        // TODO
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V; this.E = 0;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new LinkedList<>());
        }
    }

    /**
     * The number of vertices
     */
    public int V() {
        // TODO
        return V;
    }

    /**
     * The number of edges
     */
    public int E() {
        // TODO
        return E;
    }

    /**
     * Add the edge v->w
     */
    public void addEdge(int v, int w) {
        // TODO
        E++;
        adj.get(v).add(w);
    }

    /**
     * The nodes adjacent to node v
     * that is the nodes w such that there is an edge v->w
     */
    public Iterable<Integer> adj(int v) {
        // TODO
        return adj.get(v);
    }

    /**
     * A copy of the digraph with all edges reversed
     */
    public Digraph reverse() {
        // TODO
        DigraphImplem output = new DigraphImplem(this.V);
        for (int i = 0; i < V; i++) {
            Iterable<Integer> iterable = adj.get(i);
            for (int neighbor : iterable) {
                output.addEdge(neighbor, i);
            }
        }
        return output;
    }
}
