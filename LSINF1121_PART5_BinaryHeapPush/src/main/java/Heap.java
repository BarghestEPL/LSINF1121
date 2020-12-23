import java.util.Arrays;

/**
 * A binary heap where the content is placed in the array `content`.
 *
 * The array `content` represents a tree and is based on the methods we have seen in the course:
 * The ith node of the tree has indices 2*i and 2*i+1 as children.
 *
 * remarks:
 * - This heap uses a 1-indexing, ie. the first index in the array is 1 instead of 0 as usual. This could ease your computations.
 *   By this way, the index O of the array `content` must always stay empty.
 * - You can use the function increaseSize() to double the size of the array `content`, if needed.
 * - The expected complexity is O(log n) for the insertion in the heap.
 */
public class Heap {
    protected int[] content;
    protected int size;

    public Heap(int initSize) {
        size = 0;
        content = new int[initSize];
    }

    /**
     * Doubles the size of the inner storage array
     */
    protected void increaseSize() {
        int[] newContent = new int[content.length * 2];
        System.arraycopy(content, 0, newContent, 0, content.length);
        content = newContent;
    }

    /**
     * Add a new value to the heap.
     * @param val value to add
     */
    public void push(int val) {
        //TODO
        //operation on this.content.
        //use increaseSize() if needed.
        int x = ++size;
        if(size == content.length) increaseSize();
        while(x > 1 && val < content[x / 2]){
            content[x] = content[x / 2];
            x /= 2;
        }
        content[x] = val;
    }

    //You can add other functions if needed here

    /**
     * Returns the content of the inner array
     */
    public int[] getContent() {
        return content;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.push(5);
        heap.push(1);
        heap.push(2);
        heap.push(3);
        heap.push(8);
        heap.push(10);
        heap.push(6);
        heap.push(0);
        System.out.println(Arrays.toString(heap.getContent()));
    }
}
