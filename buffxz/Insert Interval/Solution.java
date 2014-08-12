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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        if (intervals == null) {
            return null;
        }
        
        int index = getIndex(intervals, newInterval);
        
        if (index > 0 && intervals.get(index - 1).end >= newInterval.end) {
            return intervals;
        } else if (index > 0 && intervals.get(index - 1).end >= newInterval.start) {
            int tempStart = intervals.get(index - 1).start;
            intervals.remove(index - 1);
            intervals.add(index - 1, new Interval(tempStart, newInterval.end));
            index--;
        } else {
            intervals.add(index, newInterval);
        }
        
        int i = index;
        while (i < intervals.size() - 1) {
            if (getMergerRes(intervals, i, i + 1) == 2) {
                
            } else {
                break;
            }
        }
        
        return intervals;
    }
    
    
    private int getMergerRes(List<Interval> intervals, int i, int j) {
        Interval prev = intervals.get(i);
        Interval cur = intervals.get(j);
        
        int prevEnd = prev.end;
        int curEnd = cur.end;
        int prevFront = prev.start;
        int curFront = cur.start;
        
        if (prevEnd < curFront ) {
            return 0;
        } else if (prevEnd <= curEnd) {
            //merge
            Interval newOne = new Interval(prevFront, curEnd);
            intervals.remove(i);
            intervals.remove(i);
            intervals.add(i, newOne);
            return 1;
        } else {
            intervals.remove(j);
            return 2;
        }
    }
    
    private int getIndex(List<Interval> intervals, Interval newInterval) {
        // int len = intervals.size();
        // if (len == 0) return 0;
        // int left = 0;
        // int right = len - 1;
        
        int target = newInterval.start;
        // while (left <= right) {
        //     int mid = left + (right - left) / 2;
        //     if (intervals.get(mid).start < target) {
        //         if (left == mid) break;
        //         left = mid;
        //     } else {
        //         if (right == mid) break;
        //         right = mid;
        //     }
        // }
        
        // return target > intervals.get(left).start ? left + 1 : left;
        for (int i = 0; i < intervals.size(); i++) {
            if (target <= intervals.get(i).start) return i;
        }
        return intervals.size();
        
    }
}