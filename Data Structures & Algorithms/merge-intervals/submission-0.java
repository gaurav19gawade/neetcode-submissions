class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++){
            int[] previous = result.get(result.size()-1);
            int[] current = intervals[i];
            if(previous[1] >= current[0]){
                previous[1] = Math.max(previous[1], current[1]);
            }else{
                result.add(current);
            }
        }

        int[][] res = new int[result.size()][2];

        for(int i = 0; i < result.size(); i++){
            res[i][0] = result.get(i)[0];
            res[i][1] = result.get(i)[1];
        }

        return res;
    }
}
