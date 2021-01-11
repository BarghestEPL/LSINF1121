import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    public static Iterable<Integer> shortestPath(int [][] maze,  int x1, int y1, int x2, int y2) {
        if (maze[x1][y1] == 1 || maze[x2][y2] == 1) return new LinkedList<>();
        int row = maze.length, col = maze[0].length;

        Queue<Integer> queue = new LinkedList<>();
        int[] prev = new int[row * col];
        Arrays.fill(prev, -1);

        int s = x1 * col + y1;
        prev[s] = -2;
        queue.add(s);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int x = curr / col, y = curr % col;

            if (x + 1 < row && maze[x + 1][y] == 0 && prev[curr + col] == -1) {
                prev[curr + col] = curr;
                queue.add(curr + col);
            }

            if (x - 1 >= 0 && maze[x - 1][y] == 0 && prev[curr - col] == -1) {
                prev[curr - col] = curr;
                queue.add(curr - col);
            }

            if (y + 1 < col && maze[x][y + 1] == 0 && prev[curr + 1] == -1) {
                prev[curr + 1] = curr;
                queue.add(curr + 1);
            }

            if (y - 1 >= 0 && maze[x][y - 1] == 0 && prev[curr - 1] == -1) {
                prev[curr - 1] = curr;
                queue.add(curr - 1);
            }
        }

        LinkedList<Integer> path = new LinkedList<>();
        int curr = x2 * col + y2;
        while (curr != -2) {
            if (curr == - 1) return new LinkedList<>();
            path.addFirst(curr);
            curr = prev[curr];
        }
        return path;
    }
}
