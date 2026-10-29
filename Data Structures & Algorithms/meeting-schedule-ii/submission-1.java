/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }


Why a Heap?
A heap is perfect here because:

Efficient minimum lookup: You need to quickly find which meeting ends earliest (pq.peek() is O(1))
Efficient updates: When you reuse a room, you remove the old end time and add the new one (O(log n) each)
Size = answer: The heap size at the end = minimum rooms needed
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(inner -> inner.start));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        

        for(int i = 0; i < intervals.size(); i++){
            int currentStart = intervals.get(i).start;
            int currentEnd = intervals.get(i).end;

            if(!pq.isEmpty() && currentStart >= pq.peek()){
                pq.poll();
            }
            pq.add(currentEnd);
        }

        return pq.size();
    }
}
