/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {

        public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        int size = intervals.size();
        if (size <= 1) return intervals;
        
        ArrayList<Interval> result = new ArrayList<Interval>();
        
        quickSort(intervals, 0, intervals.size() - 1);
        
        Interval temp = intervals.get(0);
        result.add(temp);
        
        for (int i = 1; i < intervals.size(); i++) {
            ArrayList<Interval> tempMerge = mergerIntervals(temp, intervals.get(i));
            if (tempMerge.size() == 1) {
                result.remove(result.size() - 1);
                result.add(tempMerge.get(0));
                temp = result.get(result.size() - 1);
            } else {
                result.add(tempMerge.get(1));
                temp = tempMerge.get(1);
            }
        }
        
        return result;
           
    }
    
    public static ArrayList<Interval> mergerIntervals(Interval left, Interval right) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        if (left.end < right.start) {
            result.add(left);
            result.add(right);
        } else {
            int max = Math.max(left.end, right.end);
            Interval merged = new Interval(left.start, max);
            result.add(merged);
        }
        return result;
    }
    
    public static void quickSort(List<Interval> intervals, int start, int end)
    {
        if(start < end)
        {
            int q = partition(intervals,start,end);
            quickSort(intervals, start, q);
            quickSort(intervals, q + 1, end);
        }
    }

    private static int partition(List<Interval> intervals, int start, int end) {

        int x = intervals.get(start).start;
        int i = start - 1 ;
        int j = end + 1 ;

        while (true) {
            i++;
            while ( i < end && intervals.get(i).start < x)
                i++;
            j--;
            while (j > start && intervals.get(j).start > x)
                j--;
            if (i < j)
                swap(intervals, i, j);
            else
                return j;
        }
    }
    
    public static void swap(List<Interval> intervals, int i, int j) {
        Interval temp = intervals.get(i);
        intervals.set(i, intervals.get(j));
        intervals.set(j, temp);
    }

}