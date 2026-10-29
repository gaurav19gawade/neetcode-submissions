class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> result = new ArrayList<>();


        for(int i = 0; i < intervals.length; i++){
            int[] currentInterval = intervals[i];

            if(currentInterval[0] > newInterval[1]){
                result.add(Arrays.asList(newInterval[0], newInterval[1]));

                for(int j = i; j < intervals.length; j++){
                    result.add(Arrays.asList(intervals[j][0], intervals[j][1]));
                }
                return listToInt(result);
            } else if(newInterval[0] > currentInterval[1]){
                result.add(Arrays.asList(currentInterval[0], currentInterval[1]));
            }else{
                newInterval[0] = Math.min(currentInterval[0], newInterval[0]);
                newInterval[1] = Math.max(currentInterval[1], newInterval[1]);
            }
        }
        result.add(Arrays.asList(newInterval[0], newInterval[1]));
        return listToInt(result);

    }


    private int[][] listToInt(List<List<Integer>> result){
        int[][] res = new int[result.size()][2];
        
        for(int i = 0; i < res.length; i++){
            for(int j = 0; j < res[0].length; j++){
                res[i][j] = result.get(i).get(j);
            }
        }

        return res;
    }
}