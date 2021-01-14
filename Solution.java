class Solution {
    public int minOperations(int[] nums, int x) {
        Map<Integer, Integer> left = new HashMap<Integer, Integer>();
        int sum = 0, N = nums.length;
        
        for(int i = 0; i < N - 1 && sum < x; i++){
            //need add sum == 0 to the map, the operations can be all in right side
            left.put(sum, i);
            sum += nums[i];
        }

        int res = Integer.MAX_VALUE;
        sum = 0;
        //find the complement part in the right side
        for(int i = N - 1; i >= 0 && sum <= x; i--){
            //need consider complement == x, the operations can be all in left side
            int complement = x - sum;
            if(left.containsKey(complement)){
                int operations = left.get(complement) + N - 1 - i;
                res = res < operations ? res : operations; 
            }
            sum += nums[i];
        }

        return res ==  Integer.MAX_VALUE ? -1 : res;
    }

}