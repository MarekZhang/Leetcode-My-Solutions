public class Solution2{
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
            sum += nums[i];

        if(sum % 2 != 0)
            return false;
        int n = nums.length;
        int capacity = sum / 2;
        boolean[] memo = new boolean[capacity + 1];

        for(int i = 0; i <= capacity; i++)
            memo[i] = nums[0] == capacity;

        for(int i = 1; i < n; i++)
            for(int j = capacity; j >= nums[i]; j--)
                memo[j] = memo[j] || memo[j - nums[i]];

        return memo[capacity];
    }

}