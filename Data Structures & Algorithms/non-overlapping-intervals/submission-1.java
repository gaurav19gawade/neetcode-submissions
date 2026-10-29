class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int prevEndTime = intervals[0][1];
        int count = 0;

        for(int i = 1; i < intervals.length; i++){
            int currStartTime = intervals[i][0];
            if(currStartTime < prevEndTime){
                count++;
                prevEndTime = Math.min(prevEndTime, intervals[i][1]);
            }else{
                prevEndTime = intervals[i][1];
            }
        }
        return count;
    }
}