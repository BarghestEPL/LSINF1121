import java.util.*;

public  class WordTransformationSP {
    private static class Graph {
        private int E;
        private final Dictionary<String, List<String>> adj;

        public Graph() {
            E = 0;
            adj = new Hashtable<>();
        }

        public int E() { return E; }

        private boolean isIn(String x){
            return adj.get(x) != null;
        }

        private void add(String x, String y){
            List<String> keyNeighbors = adj.get(x);
            if(keyNeighbors != null){
                keyNeighbors.add(y);
            }
            else{
                LinkedList<String> tmp = new LinkedList<>();
                tmp.add(y);
                adj.put(x, tmp);
            }
        }

        public void addEdge(String key, String value) {
            E++;
            add(key, value);
            add(value, key);
        }

        public Iterable<String> adj(String key) {
            return adj.get(key);
        }
    }

    public static String rotation(String s, int start, int end) {
        return s.substring(0,start)+new StringBuilder(s.substring(start,end)).reverse().toString()+s.substring(end);
    }

    public static void permutations(Graph graph, String from) {
        if(!graph.isIn(from)) {
            for (int i = 0; i < from.length(); i++) {
                for (int j = 0; j < ; j++) {
                    
                }
            }
        }
    }

    public static int minimalCost(String from, String to) {
        //TODO
        Graph graph = new Graph();
        permutations(graph, from);

    }
}