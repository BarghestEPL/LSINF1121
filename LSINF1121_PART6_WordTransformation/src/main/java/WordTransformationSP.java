import java.util.*;

public  class WordTransformationSP {
    public static String rotation(String s, int start, int end) {
        return s.substring(0,start) + new StringBuilder(s.substring(start,end)).reverse().toString() + s.substring(end);
    }

    public static int minimalCost(String from, String to) {
        Queue<String> queue = new LinkedList<>();
        Hashtable<String, Integer> distTo = new Hashtable<>();

        queue.add(from);
        distTo.put(from, 0);
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            Integer dist = distTo.get(curr);
            for (int i = 0; i < from.length(); i++) {
                for (int j = from.length(); j > i; j--) {
                    String rot = rotation(curr, i, j);
                    Integer cost = distTo.get(rot);
                    if (cost == null || cost > dist + j - i) {
                        distTo.put(rot, dist + j - i);
                        queue.add(rot);
                    }
                }
            }
        }
        return distTo.get(to);
    }
}