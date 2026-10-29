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
        if(intervals.isEmpty()) return true;
        intervals.sort(Comparator.comparingInt(inner -> inner.start));
        int previousEndTime = intervals.get(0).end;

        for(int i = 1; i < intervals.size(); i++){
            int currentStartTime = intervals.get(i).start;

            if(currentStartTime < previousEndTime){
                return false;
            }else{
                previousEndTime = Math.max(previousEndTime, intervals.get(i).end);
            }
        }

        return true;
    }
}
