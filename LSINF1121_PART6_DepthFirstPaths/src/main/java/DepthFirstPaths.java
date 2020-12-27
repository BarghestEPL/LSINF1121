//TODO import

import java.util.Stack;

public class DepthFirstPaths {
    private boolean[] marked; // marked[v] = is there an s-v path?
    private int[] edgeTo;     // edgeTo[v] = last edge on s-v path
    private final int s;

    /**
     * Computes a path between s and every other vertex in graph G
     * @param G the graph
     * @param s the source vertex
     */
    public DepthFirstPaths(Graph G, int s) {
        this.s = s;
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    // Depth first search from v
    private void dfs(Graph G, int v) {
        //TODO question 2
        Stack<Integer> stack = new Stack<>();
        marked[v] = true;
        edgeTo[v] = v;
        stack.push(v);

        while(!stack.isEmpty()){
            int x = stack.pop();
            Iterable<Integer> iterable = G.adj(x);
            for(int neighbor: iterable){
                if(!marked[neighbor]){
                    edgeTo[neighbor] = x;
                    marked[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
    }

    /**
     * Is there a path between the source s and vertex v?
     * @param v the vertex
     * @return true if there is a path, false otherwise
     */
    public boolean hasPathTo(int v) {
        //TODO question 3
        return marked[v];
    }

    /**
     * Returns a path between the source vertex s and vertex v, or
     * null if no such path
     * @param v the vertex
     * @return the sequence of vertices on a path between the source vertex
     *         s and vertex v, as an Iterable
     */
    public Iterable<Integer> pathTo(int v) {
        //TODO question 4
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        int prev = v;
        int curr = edgeTo[v];
        while(prev != curr){
            stack.push(curr);
            prev = curr;
            curr = edgeTo[curr];
        }
        return stack;
    }
}
