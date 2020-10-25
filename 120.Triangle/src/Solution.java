class Solution {
    //top - bottom || time complexity O(N) || space complexity O(N)
    public int minimumTotal(List<List<Integer>> triangle) {
        int N = triangle.size();
        if(N == 0 || triangle.get(0).size() == 0)
            return 0;
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < N; i++)
            res.add(new ArrayList<>());
        res.get(0).add(triangle.get(0).get(0));
        for(int i = 1; i < N; i++){
            List<Integer> prevRow = res.get(i - 1);//应该从memo中取值而不是triangle
            List<Integer> curRow = triangle.get(i);
            List<Integer> resRow = res.get(i);
            for(int j = 0; j < curRow.size(); j++){
                int curVal = curRow.get(j);
                int len = prevRow.size();
                //left boundary
                if(j - 1 < 0)
                    resRow.add(prevRow.get(j) + curVal);
                else if(j > len - 1)
                    resRow.add(prevRow.get(j - 1) + curVal);
                else{
                    int min = Math.min(prevRow.get(j), prevRow.get(j - 1));
                    resRow.add(min + curVal);
                }
            }
        }
        
        int sum = Integer.MAX_VALUE;
        List<Integer> lastRow = res.get(N - 1);
        for(int i = 0; i < lastRow.size(); i++){
            int tempt = lastRow.get(i);
            sum = tempt < sum ? tempt : sum;
        }
           
        return sum;
    }
}