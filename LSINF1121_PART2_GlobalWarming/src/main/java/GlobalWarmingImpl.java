import java.util.*;

public class GlobalWarmingImpl extends GlobalWarming {
    private final int[] sorted;
    public GlobalWarmingImpl(int[][] altitude) {
        super(altitude);
        // expected pre-processing time in the constructror : O(n^2 log(n^2))
        // TODO
        sorted = new int[altitude.length * altitude.length];
        for (int i = 0; i < altitude.length; i++) {
            System.arraycopy(altitude[i], 0, sorted,  i * altitude.length, altitude.length);
        }
        Arrays.sort(sorted);
    }

    public int nbSafePoints(int waterLevel) {
        // TODO
        // expected time complexity O(log(n^2))
        int lo = 0, hi = sorted.length - 1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(waterLevel < sorted[mid]){
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        return sorted.length - lo;
    }
}