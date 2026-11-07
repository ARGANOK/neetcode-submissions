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
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((x, y) ->
            Integer.compare(x.start, y.start));
        PriorityQueue<Interval> pq = new PriorityQueue<>((x , y)->x.end-y.end);
        if(intervals.size() == 0)  return 0;
        pq.add(intervals.get(0));
        for(int i = 1; i < intervals.size();i++){
            Interval prev = pq.peek();
            Interval curr = intervals.get(i);
            if(prev.end <= curr.start){
                pq.poll();
            }
            pq.add(curr);
        }
        return pq.size();
    }
}
