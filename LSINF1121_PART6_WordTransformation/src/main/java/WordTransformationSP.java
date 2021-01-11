import java.util.*;

public  class WordTransformationSP {

    /**
     * Rotate the substring between start and end of a given string s
     * eg. s = HAMBURGER, rotation(s,4,8) = HAMBEGRUR i.e. HAMB + EGRU + R
     */
    /**
     *
     * Rotate the substring between start and end of a given string s
     * eg. s = HAMBURGER, rotation(s,4,8) = HAMBEGRUR i.e. HAMB + EGRU + R
     * @param s
     * @param start
     * @param end
     * @return rotated string
     */
    public static String rotation(String s, int start, int end) {
        return s.substring(0,start)+new StringBuilder(s.substring(start,end)).reverse().toString()+s.substring(end);
    }

    /**
     * Compute the minimal cost from string "from" to string "to" representing the shortest path
     * @param from
     * @param to
     * @return
     */
    public static int minimalCost(String from, String to) {
        HashMap<String, Integer> words = new HashMap<>();
        PriorityQueue<Word> q = new PriorityQueue<>();
        words.put(from,0);
        q.add(new Word(from,0));

        int 
        while (!q.isEmpty()){
            Word current = q.poll();
            String curr = current.s;
            for (int i = 0; i<to.length();i++){
                for (int j = i+2;j<to.length()+1;j++){
                    String newS = rotation(curr, i,j);
                    int cost = current.cost + j-i;
                    Integer getter = words.get(newS);
                    if (getter == null || cost < getter){
                        words.put(newS,cost);
                        q.add(new Word(newS,cost));
                    }
                }
            }
        }
        return words.get(to);
    }

    public static class Word implements Comparable<Word>{
        String s;
        int cost;
        Word(String s, int cost){
            this.s = s;
            this.cost = cost;
        }

        @Override
        public int compareTo(Word w) {
            return this.cost - w.cost;
        }
    }

    public static void main(String[] args) {

    }
}