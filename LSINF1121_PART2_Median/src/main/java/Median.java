public class Median {
	public static int partition(Vector a, int lo, int hi){
	    int x = a.get(hi), i = lo;
	    for (int j = lo; j < hi; j++) {
            if(a.get(j) <= x){
                a.swap(i, j);
                i++;
            }
        }
	    a.swap(i, hi);
        return i;
    }

    public static int kthSmallest(Vector a, int lo, int hi, int k){
        int pos = partition(a, lo, hi);
        while(pos != k){
            if(pos < k){
                lo = pos + 1;
            }
            else{
                hi = pos - 1;
            }
            pos = partition(a, lo, hi);
        }
        return a.get(pos);
    }

    public static int median(Vector a, int lo, int hi){
	    return kthSmallest(a, lo, hi, (hi + lo) / 2);
    }

    public static void main(String[] args) {
	    Vector test = new Vector(7);
	    test.set(0, 12);
	    test.set(1, 3);
	    test.set(2, 5);
	    test.set(3, 7);
	    test.set(4, 4);
	    test.set(5, 19);
	    test.set(6, 26);
	    System.out.println(median(test, 0, 6));
    }

}
