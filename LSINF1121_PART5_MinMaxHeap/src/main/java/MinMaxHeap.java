import java.util.Arrays;

public class MinMaxHeap<Key extends Comparable<Key>> {

    // ---------------------------------------------------------------------------------------
    // Instance variables
    // ---------------------------------------------------------------------------------------

    // You are not allowed to add/delete variables, nor modifying their names or visibility.
    public Key[] pq;          // contains the elements starting at position 1
    public int N = 0;         // number of elements in the heap
    public int height = 0;    // should help you to know if you are at a level min or max

    // ---------------------------------------------------------------------------------------------------
    // Functions that you should implement. This is the only part of this class that you should modify ;-)
    // ---------------------------------------------------------------------------------------------------

    /**
     * @pre size() >= 1
     */
    public Key min() {
        //TODO O(1) expected
        return isEmpty() ? null : pq[1];
    }

    /**
     * @pre size() >= 1
     */
    public Key max() {
        //TODO O(1) expected
        if(isEmpty()) return null;
        if(size() == 1) return pq[1];
        if(size() == 2) return pq[2];
        return less(2, 3) ? pq[3] : pq[2];
    }

    /**
     * @pre 1 <= k <= size()
     */
    private void swim(int k) {
        //TODO O(log N) expected
        if(k == 1) return;
        boolean flag = height % 2 == 0; // MaxFloor: true, MinFloor: false
        if(less(k, k / 2) == flag){
            exch(k, k / 2);
            k /= 2;
        }
        else{
            flag = !flag;
        }

        while(k >= 4 && less(k, k / 4) == flag){
            exch(k, k / 4);
            k /= 4;
        }
    }

    // ---------------------------------------------------------------------------------------
    // Constructor and helpers. You should not modify this. However, using them may be useful.
    // ---------------------------------------------------------------------------------------

    public MinMaxHeap(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    /**
     * @return pq[i] < pq[j]
     */
    public boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    /**
     * Exchanges positions i and j in pq
     */
    private void exch(int i, int j) {
        Key e = pq[i];
        pq[i] = pq[j];
        pq[j] = e;
    }

    /**
     * @return true if the heap is empty, false else
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * @return the size of the heap
     */
    public int size() {
        return N;
    }

    /**
     * @param v value to insert in the heap. v != null.
     */
    public void insert(Key v) {
        pq[++N] = v;
        if (N >= (1 << height)) height++;
        swim(N);
    }

    @Override
    public String toString() {
        return Arrays.toString(pq);
    }
}