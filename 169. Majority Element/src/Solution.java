class Solution {
    //time complexity O(N) | space complexity O(N);
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int i : nums){
            count.putIfAbsent(i, 0);
            count.put(i, count.get(i) + 1);
        }
        int res = 0;
        int N = nums.length;
        for(Map.Entry<Integer, Integer> entry : count.entrySet())
            if(entry.getValue() > N / 2){
                res = entry.getKey();
                return res;
            }
        
        return res;
    }   
}