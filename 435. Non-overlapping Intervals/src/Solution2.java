class Solution {
    //time O(nlogn) || space O(1)
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if(intervals == null || n == 0) return 0;

        Arrays.sort(intervals, (o1, o2)->(o1[1] - o2[1]));

        int count = 1;
        int preIdx = 0;
        for(int i = 1; i < n; i++)
            if(intervals[i][0] >= intervals[preIdx][1]){
                count++;
                preIdx = i;
            }

        return n - count;
    }
}