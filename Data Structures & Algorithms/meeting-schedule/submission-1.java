/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() == 0) return true;
        intervals.sort((x , y) -> Integer.compare(x.end , y.end));
        Interval prev = intervals.get(0);
        for(int i = 1; i < intervals.size();i++){
            Interval curr = intervals.get(i);
            if(prev.end > curr.start) return false;
            prev = curr;
        }
        return true;
    }
}
