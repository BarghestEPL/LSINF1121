import java.util.*;

public class GlobalWarmingImpl extends GlobalWarming {
    private final int width;
    private boolean[] visited;
    /**
     * In the following, we assume that the points are connected to
     * horizontal or vertical neighbors but not to the diagonal ones
     * @param altitude is a n x n matrix of int values representing altitudes (positive or negative)
     * @param waterLevel is the water level, every entry <= waterLevel is flooded
     */
    public GlobalWarmingImpl(int[][] altitude, int waterLevel) {
        super(altitude,waterLevel);
        // TODO
        width = altitude.length;
        visited = new boolean[width * width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                visited[i * width + j] = altitude[i][j] <= waterLevel;
            }
        }
    }
    
    /**
     *
     * @param p1 a safe point with valid coordinates on altitude matrix
     * @param p2 a safe point (different from p1) with valid coordinates on altitude matrix
     * @return the shortest simple path (vertical/horizontal moves) if any between from p1 to p2 using only vertical/horizontal moves on safe points.
     *         an empty list if not path exists (i.e. p1 and p2 are not on the same island).
     */
    public List<Point> shortestPath(Point p1, Point p2) {
        // TODO
        // expected time complexity O(n^2)
        LinkedList<Point> output = new LinkedList<>();

        if(visited[p1.x * width + p1.y]) return output;
        if(visited[p2.x * width + p2.y]) return output;

        if(p1.equals(p2)) {
            output.push(p1);
            return output;
        }

        Point[] edgeTo = new Point[visited.length];
        boolean[] flags = new boolean[visited.length];
        System.arraycopy(visited, 0, flags, 0, visited.length);

        Queue<Point> queue = new LinkedList<>();
        int src = p1.x * width + p1.y;
        flags[src] = true;
        edgeTo[src] = p1;
        queue.add(p1);

        while(!queue.isEmpty()){
            Point p = queue.poll();
            if(p.equals(p2)) break;

            int k = p.x * width + p.y;
            if(p.x - 1 >= 0 && !flags[k - width]){
                edgeTo[k - width] = p;
                flags[k - width] = true;
                queue.add(new Point(p.x - 1, p.y));
            }

            if(p.x + 1 < width && !flags[k + width]){
                edgeTo[k + width] = p;
                flags[k + width] = true;
                queue.add(new Point(p.x + 1, p.y));
            }

            if(p.y - 1 >= 0 && !flags[k - 1]){
                edgeTo[k - 1] = p;
                flags[k - 1] = true;
                queue.add(new Point(p.x, p.y - 1));
            }

            if(p.y + 1 < width && !flags[k + 1]){
                edgeTo[k + 1] = p;
                flags[k + 1] = true;
                queue.add(new Point(p.x, p.y + 1));
            }
        }

        if(edgeTo[p2.x * width + p2.y] == null) return output;

        Point curr = p2;
        while(output.peek() != p1) {
            output.push(curr);
            curr = edgeTo[curr.x * width + curr.y];
        } return output;
    }
}