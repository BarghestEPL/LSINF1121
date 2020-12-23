import java.util.*;

public class GlobalWarmingImpl extends GlobalWarming {
   private class QuickUnion {
       int nsets;
       private final int[] id;
       public QuickUnion(int n){
           nsets = n;
           id = new int[n];
           for (int i = 0; i < n; i++){
               id[i] = i;
           }
       }

       private int root(int i){
           while(i != id[i]) i = id[i];
           return i;
       }

       public boolean find(int p, int q){
           return root(p) == root(q);
       }

       public void unite(int p, int q){
           int i = root(p), j = root(q);
           if(i != j) nsets--;
           id[i] = j;
       }
   }

   int n;
   private QuickUnion quickUnion;

   public GlobalWarmingImpl(int[][] altitude, int waterLevel) {
       super(altitude,waterLevel);
       // expected pre-processing time in the constructror : O(n^2 log(n^2))
       // TODO
       n = altitude.length;
       quickUnion = new QuickUnion(n * n);
       for (int i = 0; i < n; i++) {
           for (int j = 0; j < n; j++) {
               if(altitude[i][j] > waterLevel){
                   int k = i * n + j;
                   if(i + 1 < n && altitude[i + 1][j] > waterLevel){
                       quickUnion.unite(k, k + n);
                   }

                   if(i - 1 >= 0 && altitude[i - 1][j] > waterLevel){
                       quickUnion.unite(k, k - n);
                   }

                   if(j + 1 < n && altitude[i][j + 1] > waterLevel){
                       quickUnion.unite(k, k + 1);
                   }

                   if(j - 1 >= 0 && altitude[i][j - 1] > waterLevel){
                       quickUnion.unite(k, k - 1);
                   }
               }
           }
       }
   }

   public int nbIslands() {
       // TODO
       // expected time complexity O(1)
       return quickUnion.nsets;
   }


   public boolean onSameIsland(Point p1, Point p2) {
       // TODO
       // expected time complexity O(1)
       if(p1.equals(p2)) return false;
       return quickUnion.find(p1.x * n + p1.y, p2.x * n + p2.y);
   }
}