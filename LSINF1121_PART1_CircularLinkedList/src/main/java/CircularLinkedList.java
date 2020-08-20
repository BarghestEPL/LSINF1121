import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularLinkedList<Item> implements Iterable<Item> {
    private long nOp = 0; // count the number of operations
    private int n;          // size of the stack
    private Node  last;   // trailer of the list

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

    public CircularLinkedList() {
        last = null;
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private long nOp() {
        return nOp;
    }



    /**
     * Append an item at the end of the list
     * @param item the item to append
     */
    public void enqueue(Item item) {
        // TODO STUDENT: Implement add method
        Node node = new Node();
        node.item = item;

        if(last == null){
            node.next = node;
        } else {
            node.next = last.next;
            last.next = node;
        }

        last = node;
        nOp++;
        n++;
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     */
    public Item remove(int index) throws IndexOutOfBoundsException {
        // TODO STUDENT: Implement remove method
        if(index < 0 || index > n - 1){
            throw new IndexOutOfBoundsException();
        }

        Node prev = last;
        Node curr = last.next;
        for (int i = 0; i < index; i++) {
            prev = curr;
            curr = curr.next;
        }

        Item output = curr.item;
        prev.next = curr.next;
        nOp++;
        n--;
        return output;
    }


    /**
     * Returns an iterator that iterates through the items in FIFO order.
     * @return an iterator that iterates through the items in FIFO order.
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        // TODO STUDENT: Implement the ListIterator
        int c;
        long flag;
        Node current;
        public ListIterator(){
            c = 0;
            flag = nOp;
            current = last;
        }

        @Override
        public boolean hasNext() throws ConcurrentModificationException {
            if(flag != nOp){
                throw new ConcurrentModificationException();
            }
            return c < n;
        }

        @Override
        public Item next() throws NoSuchElementException {
            if(hasNext()){
                current = current.next;
                Item output = current.item;
                c++;
                return output;
            } else {
                throw new NoSuchElementException();
            }
        }

        @Override
        public void remove() throws UnsupportedOperationException{
            throw new UnsupportedOperationException();
        }
    }

}