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

        intervals.sort(Comparator.comparing(interval -> interval.start));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(Interval interval : intervals){
            int upcomingStartTime = interval.start;
            int upcomingEndTime = interval.end;
            if(minHeap.isEmpty()){
                minHeap.add(upcomingEndTime);
                continue;
            }

            if(minHeap.peek()<=upcomingStartTime){
                minHeap.remove();
            }

            minHeap.add(upcomingEndTime);
        }

        return minHeap.size();

    }
}
