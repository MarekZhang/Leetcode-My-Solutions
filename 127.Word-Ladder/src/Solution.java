class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);
        int p1 = intervals[0][0];
        int p2 = intervals[0][1];
        List<int[]> list = new ArrayList<>();
        int N = intervals.length;
        for(int i = 1; i < N; i++){
            int[] interval = intervals[i];
            if(interval[0] > p2) {
                list.add(new int[]{p1, p2});
                p1 = interval[0];
                p2 = interval[1];
            }
            else if(interval[0] < p1) p1 = interval[0];
            else if(interval[1] > p2) p2 = interval[1];
        }

        list.add(new int[]{p1, p2});
        int[][] res = new int[list.size()][2];
        int idx = 0;
        for(int[] arr : list) res[idx++] = arr;

        return res;
    }
}