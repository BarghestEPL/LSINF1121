import java.util.ArrayList;
import java.util.Arrays;

public class Union {

    public static Interval [] union(Interval [] intervals) {
        // TODO
        if(intervals.length > 0){
            Arrays.sort(intervals);
            ArrayList<Interval> unions = new ArrayList<>();

            int minimum = intervals[0].min, maximum = intervals[0].max;
            for (int i = 1; i < intervals.length; i++) {
                if(maximum < intervals[i].min){
                    unions.add(new Interval(minimum, maximum));
                    minimum = intervals[i].min;
                    maximum = intervals[i].max;
                }
                else{
                    maximum = Math.max(maximum, intervals[i].max);
                }
            }

            unions.add(new Interval(minimum, maximum));
            return unions.toArray(new Interval[]{});
        }
        return new Interval[]{};
    }

    /*
        input:[4,7][5,8][6,7][8,11][12,12][12,15][13,14][13,15][14,17][16,16]
        expected output:[4,11][12,17]
     */

    public static void main(String[] args) {
        Interval[] intervals = {
                new Interval(4, 7),
                new Interval(5, 8),
                new Interval(6, 7),
                new Interval(8, 11),
                new Interval(12, 12),
                new Interval(12, 15),
                new Interval(13, 14),
                new Interval(13, 15),
                new Interval(14, 17),
                new Interval(16, 16)
        };
        Interval[] test = union(intervals);
        System.out.println(Arrays.toString(test));
    }

}
